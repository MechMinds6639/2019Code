/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import com.ctre.phoenix.motorcontrol.Faults;
//import com.ctre.phoenix.motorcontrol.InvertType;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//import edu.wpi.first.cameraserver.CameraServer;
//import edu.wpi.cscore.UsbCamera;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.*;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.*;//import com.ctre.phoenix.motorcontrol.Faults;//import com.ctre.phoenix.motorcontrol.InvertType;//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;//import edu.wpi.first.cameraserver.CameraServer;//import edu.wpi.cscore.UsbCamera;//import edu.wpi.first.wpilibj.Joystick;//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.SensorUtil;
//import edu.wpi.first.wpilibj.buttons.*;
//import frc.robot.RobotMap;
import frc.robot.OI;
/**
 * Enable robot and slowly drive forward.
 * [1] If DS reports errors, adjust CAN IDs and firmware update.
 * [2] If motors are spinning incorrectly, first check gamepad (hold down btn1)
 * [3] If motors are still spinning incorrectly, correct motor inverts.
 * [4] Now that motors are driving correctly, check sensor phase.  If sensor is out of phase, adjust sensor phase.
 * [4] Is only necessary if you have sensors.
 */


public class Robot extends TimedRobot {
    public static DriveSubsystem driveSubsystem;
    public static PneumaticsSubsytem pneumaticSubsystem;
    // public static Object climbSubsystem;
    // public static Object Compressor;
    //Joystick _joystick = new Joystick(0);
    //UsbCamera camera1;
    // public static PneumaticsSubsytem Pnuematics;
    
    Command m_autonomousCommand;
    SendableChooser<Command> m_chooser = new SendableChooser<>();


    //THEESE HAVE TO AT THE BOTTOM
    public static OI oi;

  

    @Override
    public void robotInit() {
      driveSubsystem = new DriveSubsystem();
      pneumaticSubsystem = new PneumaticsSubsytem();
      oi = new OI();

    }
 
  @Override
  public void robotPeriodic() {

  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}