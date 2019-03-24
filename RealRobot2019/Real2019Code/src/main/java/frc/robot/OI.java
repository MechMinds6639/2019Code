/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import com.sun.tools.classfile.StackMapTable_attribute.stack_map_frame;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Clamp;
import frc.robot.commands.ClimbDown;
import frc.robot.commands.ClimbUp;
import frc.robot.commands.GetCircled;
import frc.robot.commands.GetCircledV2;
import frc.robot.commands.NotGetCircled;
import frc.robot.commands.NotGetCircledV2;
import frc.robot.commands.ObtainCircle;
import frc.robot.commands.ShiftDown;
import frc.robot.commands.ShiftUp;
import frc.robot.commands.UnClamp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public static Joystick _joystick;
  public static Button ShiftUp, ShiftDown;
  public static Button GetCircled, GetCircledV2;
  public static Button NotGetCircled, NotGetCircledV2;
  public static Button climbUp;
  public static Button climbDown;
  public static double deadband;
  public static double turnDeadband;
  public static Button Clamp;
  public static Button UnClamp;
  public static Button obtainCircle;
  // COMMANDS
  public OI() {
    // JOYSTICKS
    _joystick = new Joystick(0);
    // BUTTONS
    ShiftUp = new JoystickButton(_joystick, 1);
    ShiftDown = new JoystickButton(_joystick, 2);

    GetCircled = new JoystickButton(_joystick, 6); //open close
    GetCircledV2 = new JoystickButton(_joystick, 4);
    NotGetCircled = new JoystickButton(_joystick, 5); //In and out
    NotGetCircledV2 = new JoystickButton(_joystick, 3);
    climbUp = new JoystickButton(_joystick, 10);
    climbDown = new JoystickButton(_joystick,11);
    Clamp = new JoystickButton (_joystick, 7);
    UnClamp = new JoystickButton(_joystick, 8);
    obtainCircle = new JoystickButton(_joystick, 12);
    // DEADBANDS
    deadband = 0.0;
    turnDeadband = 0.0;
    // SHIFTs
    ShiftUp.whenPressed(new ShiftUp());
    ShiftDown.whenPressed(new ShiftDown());


    // Intake AKA GET CIRCLEDDDDDDDDDDDDDDD
    GetCircled.whenPressed(new GetCircled());
    GetCircledV2.whenPressed(new GetCircledV2());

    // Not Intake AKA NOT GET CIRCLEDDDDDDDDDD
    NotGetCircled.whenPressed(new NotGetCircled());
    NotGetCircledV2.whenPressed(new NotGetCircledV2());

    // Climb
    climbUp.whileHeld(new ClimbUp());
    climbDown.whileHeld(new ClimbDown());

    // Clamp
    Clamp.whileHeld(new Clamp());
    UnClamp.whileHeld(new UnClamp());

    obtainCircle.whenPressed(new ObtainCircle());
  }
  
 public double getX() {
    if (Math.abs(_joystick.getX())> deadband){
      return _joystick.getX() * - RobotMap.maxSpeed;
    }
    else{
    return 0;
    }
 }
  public double getY(){
    if (Math.abs(_joystick.getY()) > turnDeadband){
    return _joystick.getY() * - RobotMap.maxSpeed;
    }
    else{
      return 0;
    }
  }
}