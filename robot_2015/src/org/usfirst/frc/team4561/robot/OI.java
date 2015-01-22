package org.usfirst.frc.team4561.robot;

import org.usfirst.frc.team4561.robot.commands.IndividualMotorDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	/*
	 * MecanumDrive system controls
	 */
	private Joystick driveStick = new Joystick(RobotMap.DRIVE_JOYSTICK);
	private Joystick rotationStick = new Joystick(RobotMap.ROTATION_JOYSTICK);
	private JoystickButton robotRelativeButton = new JoystickButton(driveStick,
			RobotMap.ROBOT_RELATIVE_BUTTON);
	private JoystickButton driveFrontLeft = new JoystickButton(driveStick,
			RobotMap.FRONT_LEFT_MOTOR_BUTTON);
	private JoystickButton driveRearLeft = new JoystickButton(driveStick,
			RobotMap.REAR_LEFT_MOTOR_BUTTON);
	private JoystickButton driveFrontRight = new JoystickButton(driveStick,
			RobotMap.FRONT_RIGHT_MOTOR_BUTTON);
	private JoystickButton driveRearRight = new JoystickButton(driveStick,
			RobotMap.REAR_RIGHT_MOTOR_BUTTON);
	
	// private Joystick xBoxDriveStick = new Joystick(RobotMap.LEFT_STICK);
	// private Joystick xBoxRotaryStick = new Joystick(RobotMap.RIGHT_STICK);
	/**
	 * Returns true if driving should be robot relative (vs field relative).
	 * 
	 * @return true if in robot relative driving mode
	 */
	public boolean isRobotRelative() {
		return robotRelativeButton.get();
	}
	public OI() {
		driveFrontLeft.whileHeld(new IndividualMotorDrive(RobotMap.FRONT_LEFT_MOTOR_CAN));
		driveRearLeft.whileHeld(new IndividualMotorDrive(RobotMap.REAR_LEFT_MOTOR_CAN));
		driveFrontRight.whileHeld(new IndividualMotorDrive(RobotMap.FRONT_RIGHT_MOTOR_CAN));
		driveRearRight.whileHeld(new IndividualMotorDrive(RobotMap.REAR_RIGHT_MOTOR_CAN));
	}
	/**
	 * Returns the drive stick Y axis magnitude [-1..1] where negative is
	 * forward and backward is positive.
	 * 
	 * @return the drive stick Y axis magnitude
	 */
	public double getDriveY() {
		return driveStick.getY();
		// return xBoxDriveStick.getY();
	}

	/**
	 * Returns the drive stick X axis magnitude [-1..1] where negative is left
	 * and right is positive.
	 * 
	 * @return the drive stick X axis magnitude
	 */
	public double getDriveX() {
		return driveStick.getX();
		// return xBoxDriveStick.getX();
	}

	/**
	 * Returns the rotation stick X axis magnitude [-1..1] where negative is
	 * left and right is positive.
	 * 
	 * @return the rotation stick X axis magnitude
	 */
	public double getRotationX() {
		return rotationStick.getX();
		// return xBoxRotaryStick.getX();
	}
}