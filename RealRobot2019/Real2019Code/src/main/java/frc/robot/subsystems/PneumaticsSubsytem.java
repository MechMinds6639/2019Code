/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class PneumaticsSubsytem extends Subsystem {
	//public DoubleSolenoid grabberSolenoid;
    public DoubleSolenoid circledSolenoid;
    public Solenoid InNOut; 
	public DoubleSolenoid shifterSolenoids;

	public PneumaticsSubsytem() {
    	circledSolenoid = new DoubleSolenoid(4,5);
    	InNOut = new Solenoid (6); 
		shifterSolenoids = new DoubleSolenoid(0,1);
	}
	
	 public void closeGripper(){
		circledSolenoid.set(DoubleSolenoid.Value.kReverse);	
	}
	public void openGripper(){
		circledSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void shiftUp() {
	shifterSolenoids.set(DoubleSolenoid.Value.kForward); 
	}
	public void shiftDown() {
	shifterSolenoids.set(DoubleSolenoid.Value.kReverse); 
	}
	

	public void OutGripper()	{
	  InNOut.set(true);
	} 
	public void InGripper(){
		InNOut.set(false);
	}
  @Override
  public void initDefaultCommand() {
  }
}