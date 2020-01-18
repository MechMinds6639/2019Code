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
//import frc.robot.RobotMap;
//import frc.robot.commands.GetCircledV2;
//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.Robot;

/**
 * Add your docs here.
 * 
 */
public class PneumaticsSubsytem extends Subsystem {
	public DoubleSolenoid grabberSolenoid;
    public DoubleSolenoid circledSolenoid;
    public Solenoid InNOut; 
	public DoubleSolenoid shifterSolenoids;

	public PneumaticsSubsytem() {
		grabberSolenoid = new DoubleSolenoid(0,1);
    	circledSolenoid = new DoubleSolenoid(2,3);
    	InNOut = new Solenoid (6); 
		shifterSolenoids = new DoubleSolenoid(4,5);
	}
	

	public void clampGrabber(String clamped) {
		if(clamped == "true") {
			grabberSolenoid.set(DoubleSolenoid.Value.kForward);
		} else if (clamped == "false") {
			grabberSolenoid.set(DoubleSolenoid.Value.kReverse);

		} else if (clamped == "off") {
			grabberSolenoid.set(DoubleSolenoid.Value.kOff);
		}
	}

	 public void GetCircled(String Circled){
		if(Circled == "true"){
			//InNOut.set(Solenoid.getPCMSolenoidVoltageFault(7));
		} else if (Circled == "false"){
			//InNOut.class
		}
	}

	public void NotGetCircled(String NotCircle){
		if (NotCircle == "true"){
			//notGetCircledSolenoid.set(DoubleSolenoid.Value.kForward);
		} else if (NotCircle == "false"){
			//notGetCircledSolenoid.set(DoubleSolenoid.Value.kReverse);
		} else if (NotCircle == "off"){
			//notGetCircledSolenoid.set(DoubleSolenoid.Value.kOff);
		}
	}

	public void GetCircledV2(String CircledV2){
		if (CircledV2 == "true"){
			circledSolenoid.set(DoubleSolenoid.Value.kForward);
		} else if (CircledV2 == "false"){
			circledSolenoid.set(DoubleSolenoid.Value.kReverse);
		} else if (CircledV2 == "off"){
			circledSolenoid.set(DoubleSolenoid.Value.kOff);
		}
	}
	
	public void shiftGears(String shiftpos) {
	 	if(shiftpos == "high") {
	 		shifterSolenoids.set(DoubleSolenoid.Value.kForward);
	 	} else if (shiftpos == "low") {
	 		shifterSolenoids.set(DoubleSolenoid.Value.kReverse);
	 	}
	}

	public void shiftUp() {
	shifterSolenoids.set(DoubleSolenoid.Value.kForward); 
	}
	public void shiftDown() {
		shifterSolenoids.set(DoubleSolenoid.Value.kForward); 
	}

  @Override
  public void initDefaultCommand() {
  }
}