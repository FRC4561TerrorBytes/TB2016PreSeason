package org.usfirst.frc.team4561.robot;

import org.usfirst.frc.team4561.robot.commands.IndividualMotorDrive;
import org.usfirst.frc.team4561.robot.commands.JogSideways;
import org.usfirst.frc.team4561.robot.commands.MoveElevator;
import org.usfirst.frc.team4561.robot.triggers.JogBackwardTrigger;
import org.usfirst.frc.team4561.robot.triggers.JogForwardTrigger;
import org.usfirst.frc.team4561.robot.triggers.JogLeftTrigger;
import org.usfirst.frc.team4561.robot.triggers.JogRightTrigger;

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

	public JoystickButton joggingRightButton = new JoystickButton(driveStick,RobotMap.ROBOT_JOG_RIGHT_BUTTON);
	public JoystickButton joggingLeftButton = new JoystickButton(driveStick,RobotMap.ROBOT_JOG_LEFT_BUTTON);
	public JoystickButton joggingForwardButton = new JoystickButton(driveStick,RobotMap.ROBOT_JOG_FORWARD_BUTTON);
	public JoystickButton joggingBackwardButton = new JoystickButton(driveStick,RobotMap.ROBOT_JOG_BACKWARD_BUTTON);
	public JoystickButton elevatorUpButton = new JoystickButton(driveStick,RobotMap.MOVE_ELEVATOR_UP_BUTTON);
	public JoystickButton elevatorDownButton = new JoystickButton(driveStick,RobotMap.MOVE_ELEVATOR_DOWN_BUTTON);
	
	
	private JoystickButton driveFrontLeft = new JoystickButton(driveStick,
			RobotMap.FRONT_LEFT_MOTOR_BUTTON);
	private JoystickButton driveRearLeft = new JoystickButton(driveStick,
			RobotMap.REAR_LEFT_MOTOR_BUTTON);
	private JoystickButton driveFrontRight = new JoystickButton(driveStick,
			RobotMap.FRONT_RIGHT_MOTOR_BUTTON);
	private JoystickButton driveRearRight = new JoystickButton(driveStick,
			RobotMap.REAR_RIGHT_MOTOR_BUTTON);
	
	private JogLeftTrigger jogLeftTrigger = new JogLeftTrigger();
	private JogRightTrigger jogRightTrigger = new JogRightTrigger();
	private JogForwardTrigger jogForwardTrigger = new JogForwardTrigger();
	private JogBackwardTrigger jogBackwardsTrigger = new JogBackwardTrigger();
	
	
	
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
	
	/**
	 * The OI constructor is called from {@link Robot#robotInit()} to create the
	 * one and only OI instance. The connection of button or custom trigger to
	 * commands is made here.
	 */
	public OI() {
		driveFrontLeft.whileHeld(new IndividualMotorDrive(RobotMap.FRONT_LEFT_MOTOR_CAN));
		driveRearLeft.whileHeld(new IndividualMotorDrive(RobotMap.REAR_LEFT_MOTOR_CAN));
		driveFrontRight.whileHeld(new IndividualMotorDrive(RobotMap.FRONT_RIGHT_MOTOR_CAN));
		driveRearRight.whileHeld(new IndividualMotorDrive(RobotMap.REAR_RIGHT_MOTOR_CAN));
		
		jogLeftTrigger.whenActive(new JogSideways(true));
		jogRightTrigger.whenActive(new JogSideways(false));
		
		elevatorDownButton.whileHeld(new MoveElevator(-0.5));
		elevatorUpButton.whileHeld(new MoveElevator(0.5));
		
	}
	
	/**
	 * Returns the drive stick Y axis magnitude [-1..1] where negative is
	 * forward and backward is positive.
	 * 
	 * @return the drive stick Y axis magnitude
	 */
	public double getDriveY() {
		// Dead zone management
		double driveStickY = driveStick.getY();
		if(Math.abs(driveStickY) < RobotMap.DRIVE_DEAD_ZONE) {
			driveStickY = 0;
		}
		return driveStickY;
		// return xBoxDriveStick.getY();
	}

	/**
	 * Returns the drive stick X axis magnitude [-1..1] where negative is left
	 * and right is positive.
	 * 
	 * @return the drive stick X axis magnitude
	 */
	public double getDriveX() {
		// Dead zone management
		double driveStickX = driveStick.getX();
		if(Math.abs(driveStickX) < RobotMap.DRIVE_DEAD_ZONE) {
			driveStickX = 0;
		}
		return driveStickX;
		// return xBoxDriveStick.getX();
	}

	/**
	 * Returns the rotation stick X axis magnitude [-1..1] where negative is
	 * left and right is positive.
	 * 
	 * @return the rotation stick X axis magnitude
	 */
	public double getRotationX() {
		// Dead zone management
		double rotationStickX = rotationStick.getX();
		if(Math.abs(rotationStickX) < RobotMap.ROTATION_DEAD_ZONE) {
			rotationStickX = 0;
		}
		return rotationStickX;
		// return xBoxRotaryStick.getX();
	}
	
	/**
	 * Returns the degrees from 0 to the current direction of the rotation
	 * stick. If the stick is currently neutral, the last value is returned.
	 * 
	 * @return the degrees of the current or most recent rotation stick input
	 */
	public double getRotationDegrees() {
		if ((Math.abs(rotationStick.getX()) >= RobotMap.ROTATION_DEAD_ZONE)
				|| (Math.abs(rotationStick.getY()) >= RobotMap.ROTATION_DEAD_ZONE))
			return rotationStick.getDirectionDegrees();
		else
			return Robot.driveTrain.getNormalizedGyroAngle();
	}

}
