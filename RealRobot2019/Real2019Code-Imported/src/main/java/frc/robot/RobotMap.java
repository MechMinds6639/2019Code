/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.SensorUtil;
//import edu.wpi.first.wpilibj.*;

public class RobotMap {

  //MOTORS
   
  public static WPI_VictorSPX _winch1 = new WPI_VictorSPX(1);
  public static WPI_VictorSPX _winch2 = new WPI_VictorSPX(2);
  
  //SPEEDS
  public static double maxSpeed = 1; //This value must be positive 

  //PNUEMATICS
    
     
}