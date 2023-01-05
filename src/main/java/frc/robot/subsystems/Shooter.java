// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



//import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
//import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  Spark leftShooterMotor = new Spark(Constants.SHOOTER_LEFT);  //the PWM port in Constants
  //PWMVictorSPX leftShooterMotor = new PWMVictorSPX(Constants.SHOOTER_LEFT);


  public Shooter() {
    //set shooter motors to factory defaults for safety
    //nothing for this motor controller and CIM motor pairing
  }


  //**********Spin Up and Spin Down may be reversed */
public void spinUp(double speed) {
  leftShooterMotor.set(speed);
}

public void spinDown(double speed) {
  leftShooterMotor.set(-speed);
  }


public void stopShooter()  {
  leftShooterMotor.stopMotor();
}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
