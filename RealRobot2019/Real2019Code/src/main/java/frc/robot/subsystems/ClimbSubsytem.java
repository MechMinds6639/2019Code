/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * Add your docs here.
 */
public class ClimbSubsytem extends Subsystem {
  WPI_VictorSPX _winch1;
  WPI_VictorSPX _winch2;
  public ClimbSubsytem(){
    
    _winch1= new WPI_VictorSPX(1);
    _winch2 = new WPI_VictorSPX(2);

    _winch1.setNeutralMode(NeutralMode.Brake);
    _winch2.setNeutralMode(NeutralMode.Brake);

    // _winch2.setInverted(true);
  }

  public void climbUp(){
    _winch1.set(.75); 
    _winch2.set(-.75);
  }

  public void climbDown(){
    _winch1.set(-.75);
    _winch2.set(.75);
  }


  public void stopClimb(){
    _winch1.set(0);
      _winch2.set(0);
  }

  //_winch1.set(ControlMode.PercentOutput, talonOutput);
    //_winch2.set(ControlMode.PercentOutput, talonOutput);
	//public void NotGetCircled(String NotCircle){
		//if (NotCircle == "true"){
			//notGetCircledSolenoid.set(DoubleSolenoid.Value.kForward);
		//} else if (NotCircle == "false"){
			//notGetCircledSolenoid.set(DoubleSolenoid.Value.kReverse);
		//} else if (NotCircle == "off"){
			//notGetCircledSolenoid.set(DoubleSolenoid.Value.kOff);
		//}
	//}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
