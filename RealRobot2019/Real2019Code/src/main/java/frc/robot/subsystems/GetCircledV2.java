/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
 public class GetCircledV2 extends Subsystem {
 public DoubleSolenoid intakeSolenoid = Robot.pneumaticSubsystem.circledSolenoid;

  public void extendOut (String extend){
    if (extend == "true" ){
      intakeSolenoid.set(Value.kForward);
    } else if (extend == "false"){
      intakeSolenoid.set(Value.kReverse);
    } else if (extend == "off"){
      intakeSolenoid.set(Value.kOff);
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
} 