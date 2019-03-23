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
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
 /*
 * Add your docs here.
 */ 
public class InNOut extends Subsystem {
  
  public Solenoid intakeSolenoid = Robot.pneumaticSubsystem.InNOut;

  public void IntakeCirlce (String  Intake)
  {
    if (Intake == "true")
    {
      intakeSolenoid.getPCMSolenoidVoltageFault(1);
    }
    
    else if (Intake == "false")
    {
      intakeSolenoid.getPCMSolenoidVoltageFault(-1);
    }

   else if (Intake == "off"){
      intakeSolenoid.getPCMSolenoidVoltageFault(0);
    }
  } 
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}