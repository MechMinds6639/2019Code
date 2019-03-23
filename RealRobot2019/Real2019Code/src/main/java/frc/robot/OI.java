/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public static Joystick _joystick;
  public static Button shiftUp, shiftDown;
  public static Button GetCircled;
  public static Button NotGetCircled;
  public static double deadband;
  public static double turnDeadband;

  // COMMANDS
  public OI() {

    // JOYSTICKS
    _joystick = new Joystick(0);
    // BUTTONS
    shiftUp = new JoystickButton(_joystick, 5);
    shiftDown = new JoystickButton(_joystick, 3);

    GetCircled = new JoystickButton(_joystick, 7);
    NotGetCircled = new JoystickButton(_joystick, 8);

    // DEADBANDS
    deadband = 0.10;
    turnDeadband = .25;
    // SHIFTs
    shiftUp.whenPressed(new ShiftUp());
    shiftDown.whenPressed(new ShiftDown());


    // Intake AKA GET CIRCLEDDDDDDDDDDDDDDD
    GetCircled.whenPressed(new GetCircled());

    // Not Intake AKA NOT GET CIRCLEDDDDDDDDDD
    NotGetCircled.whenPressed(new NotGetCircled());

    // Climb

  }
  
 public double getX() {
    if (_joystick.getX() > deadband){
      return _joystick.getX() * - RobotMap.maxSpeed;
    }
    else{
      return 0;
    }
 }
  public double getY(){
    if (_joystick.getY() > turnDeadband){
    return _joystick.getY() * - RobotMap.maxSpeed;
    }
    else{
      return 0;
    }
  }
}