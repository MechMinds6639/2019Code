/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.NeutralMode;
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

  }

  public void climbUp(){
    _winch1.set(.90); 
    _winch2.set(-.90);
  }

  public void climbDown(){
    _winch1.set(-.90);
    _winch2.set(.90);
  }


  public void stopClimb(){
    _winch1.set(0);
    _winch2.set(0);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}