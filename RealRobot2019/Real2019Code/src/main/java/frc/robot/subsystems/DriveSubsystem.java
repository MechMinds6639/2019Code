/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.Faults;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.UserDrive;

public class DriveSubsystem extends Subsystem {
    
  public WPI_TalonSRX _rghtFront;  
  public WPI_TalonSRX _rghtFollower;
  public WPI_TalonSRX _rghtFollower2;
  public WPI_TalonSRX _leftFront;
  public WPI_TalonSRX _leftFollower;
  public WPI_TalonSRX _leftFollower2;
  DifferentialDrive _diffDrive;
    //Talon Declarations
    
    // public DriveSubsystem() {

    // }

    //Drive Train

    //JoyStick
    Joystick _joystick = OI._joystick;
  
    public DriveSubsystem() {
        _rghtFront = new WPI_TalonSRX(5);
        _rghtFollower = new WPI_TalonSRX(3);
        _rghtFollower2 = new WPI_TalonSRX(4);
        _leftFront = new WPI_TalonSRX(6);
        _leftFollower = new WPI_TalonSRX(7);
        _leftFollower2 = new WPI_TalonSRX(8);
        Faults _faults_L = new Faults();
        Faults _faults_R = new Faults();

        _diffDrive = new DifferentialDrive(_leftFront, _rghtFront);
        String work = "";
        
        // get gamepad stick values and limit max speed 
        //double forw =  -1 * RobotMap.maxSpeed * _joystick.getRawAxis(1);         /* positive is forward */
        //double turn =  -1 * RobotMap.maxSpeed *  _joystick.getRawAxis(0);        /* positive is right */
        
        // deadband
        // if (Math.abs(forw) < OI.deadband) {
        //     forw = 0;
        // }
        // if (Math.abs(turn) < OI.turnDeadband) {
        //     turn = 0;
        // }

        

        /*
         * [2] Make sure Gamepad Forward is positive for FORWARD, and GZ is positive for
         * RIGHT
         */
        //work += " GF:" + forw + " GT:" + turn;

        /* get sensor values */
        
        // double leftVelUnitsPer100ms = _leftFront.getSelectedSensorVelocity(0);
        // double rghtVelUnitsPer100ms = _rghtFront.getSelectedSensorVelocity(0);

        // work += " L:" + leftVelUnitsPer100ms + " R:" + rghtVelUnitsPer100ms;

        // // drive motor at least 25%, Talons will auto-detect if sensor is out of phase
        // _leftFront.getFaults(_faults_L);
        // _rghtFront.getFaults(_faults_R);

        // if (_faults_L.SensorOutOfPhase) {
        //     work += " L sensor is out of phase";
        // }
        // if (_faults_R.SensorOutOfPhase) {
        //     work += " R sensor is out of phase";
        // }
        // factory default values also set up and invert followers
        _rghtFront.configFactoryDefault();
        _rghtFollower.configFactoryDefault();
        _rghtFollower.follow(_rghtFront);
        _rghtFollower.setInverted(InvertType.FollowMaster);
        _rghtFollower2.configFactoryDefault();
        _rghtFollower2.follow(_rghtFront);
        _rghtFollower2.setInverted(InvertType.FollowMaster);
             
        //Left Motor Values
        _leftFront.configFactoryDefault();
        _leftFollower.configFactoryDefault();
        _leftFollower.follow(_leftFront);
        _leftFollower.setInverted(InvertType.FollowMaster);
        _leftFollower2.configFactoryDefault();
        _leftFollower2.follow(_leftFront);
        _leftFollower2.setInverted(InvertType.FollowMaster);
        
        //inverts UPDATE HERE
        _rghtFront.setInverted(true);
        _leftFront.setInverted(false); 	
        
        // Sensor phase
        _rghtFront.setSensorPhase(true);
        _leftFront.setSensorPhase(true);
        
        //Right Side invert DO NOT CHANGE!!!!
        _diffDrive.setRightSideInverted(false); 
    }   

    public void drive(double forwardSpeed, double turnSpeed) {
        /* drive robot */
        _diffDrive.arcadeDrive(forwardSpeed, turnSpeed);
    }
    
    
  public void initDefaultCommand() {       
    setDefaultCommand(new UserDrive());
 }
}
