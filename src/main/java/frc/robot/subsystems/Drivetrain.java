// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
// Create PWMVictor objects to control the motors on the drivetrain.

//left side motors
PWMVictorSPX leftFront = new PWMVictorSPX(Constants.LEFT_FRONT);
PWMVictorSPX leftBack = new PWMVictorSPX(Constants.LEFT_BACK);

//right side motors
PWMVictorSPX rightFront = new PWMVictorSPX(Constants.RIGHT_FRONT);
PWMVictorSPX rightBack = new PWMVictorSPX(Constants.RIGHT_BACK);


 // Create MotorControllerGroup objects to use the defined motors in a DifferentialDrive class.
 MotorControllerGroup leftMotors = new MotorControllerGroup(leftFront, leftBack);
 MotorControllerGroup rightMotors = new MotorControllerGroup(rightFront, rightBack);
 


 // Create a DifferentialDrive object with the defined motors.
 DifferentialDrive drivetrain = new DifferentialDrive(leftMotors, rightMotors);




 public Drivetrain() {
  //invert the throttle on the right side since they are installed facing the other direction
  rightMotors.setInverted(true);
  leftMotors.setInverted(false);
}
public void arcadeDrive(double throttle, double rotation)
{
  drivetrain.arcadeDrive(-throttle, rotation);
}
public void splitArcadeDrive(double throttle, double rotation)
{
  drivetrain.arcadeDrive(-throttle, rotation);
}
public void tankDrive(double left, double right) {
  drivetrain.tankDrive(left, right);  //right was negative
}
@Override
public void periodic() {
  // This method will be called once per scheduler run
}
public void driveForward(double speed)
{
  drivetrain.tankDrive(speed, speed);
}
public void driveForwardTimed(double time, double speed)
{
  drivetrain.tankDrive(speed, speed);
}
public void stop() {
  // Call DifferentialDrive's stopMotor method.
  drivetrain.stopMotor();
}
}