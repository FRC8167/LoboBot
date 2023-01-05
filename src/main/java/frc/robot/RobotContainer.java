// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


//import java.util.function.DoubleSupplier;

//import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriveTrain.DriveForwardTimed;
import frc.robot.commands.DriveTrain.SplitArcadeDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //The subsystems:
  private final Drivetrain drivetrain = new Drivetrain();
  private final Shooter shooter = new Shooter();

  //Define the Operator XBox Controller
  public static XboxController driverController = new XboxController(Constants.DRIVER_CONTROLLER);

  //Create an autonomous command
  private final DriveForwardTimed driveForwardTimed = new DriveForwardTimed(drivetrain, Constants.DRIVE_FORWARD_TIME, Constants.AUTONOMOUS_SPEED);


  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();
    
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  drivetrain.setDefaultCommand(new SplitArcadeDrive(
    drivetrain, 
    () -> driverController.getLeftY(),
    () -> driverController.getRightX()
  )
  );



   }

  private void configureButtonBindings() {
    //drivetrain.setDefaultCommand(new TankDrive(drivetrain, driverController.getRightY()));

// Spin the shooter wheels up when the right bumper is pressed.
    JoystickButton SpinUpButton = new JoystickButton(driverController, Constants.kA);
    SpinUpButton.whileHeld(new RunCommand(() -> shooter.spinUp(Constants.SHOOTER_SPINUP_SPEED), shooter));
    SpinUpButton.whenReleased(new RunCommand(() -> shooter.stopShooter(), shooter));
    
    JoystickButton SpinDownButton = new JoystickButton(driverController, Constants.kB);
    SpinDownButton.whileHeld(new RunCommand(() -> shooter.spinUp(Constants.SHOOTER_SPINDOWN_SPEED), shooter));
    SpinDownButton.whenReleased(new RunCommand(() -> shooter.stopShooter(), shooter));

    // new Trigger()
    // .whenActive(() -> shooter.spinUp(driverController.getRightTriggerAxis()))
    // .whenInactive(() -> shooter.stopShooter());

    // new Trigger()
    // .whenActive(() -> shooter.spinDown(driverController.getLeftTriggerAxis()))
    // .whenInactive(() -> shooter.stopShooter());





   }    /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveForwardTimed;

  }

	
}
