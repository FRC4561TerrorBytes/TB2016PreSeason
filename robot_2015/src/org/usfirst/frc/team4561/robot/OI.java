package org.usfirst.frc.team4561.robot;

import org.usfirst.frc.team4561.robot.commands.ElevatorJog;
import org.usfirst.frc.team4561.robot.commands.IndividualMotorDrive;
import org.usfirst.frc.team4561.robot.commands.InitGyro;
import org.usfirst.frc.team4561.robot.commands.JoggingPOV;
import org.usfirst.frc.team4561.robot.commands.MoveElevator;
import org.usfirst.frc.team4561.robot.commands.MoveElevatorTo;
import org.usfirst.frc.team4561.robot.commands.MovePos;
import org.usfirst.frc.team4561.robot.commands.RotatingPOV;
import org.usfirst.frc.team4561.robot.subsystems.Elevator;
import org.usfirst.frc.team4561.robot.triggers.InitializeGyroTrigger;
import org.usfirst.frc.team4561.robot.triggers.JogPOVTrigger;
import org.usfirst.frc.team4561.robot.triggers.MovePosPOVTrigger;
import org.usfirst.frc.team4561.robot.triggers.RotatePOVTrigger;

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
	// private Joystick arcadeBox = new Joystick(RobotMap.ARCADE_BOX);
	private Joystick controller = new Joystick(RobotMap.CONTROLLER);

	private JoystickButton robotRelativeButton = new JoystickButton(driveStick,
			RobotMap.ROBOT_RELATIVE_BUTTON);

	public JoystickButton elevatorUpButton = new JoystickButton(rotationStick,RobotMap.MOVE_ELEVATOR_UP_BUTTON);
	public JoystickButton elevatorDownButton = new JoystickButton(rotationStick,RobotMap.MOVE_ELEVATOR_DOWN_BUTTON);
	
	private JoystickButton driveFrontLeft = new JoystickButton(driveStick,
			RobotMap.FRONT_LEFT_MOTOR_BUTTON);
	private JoystickButton driveRearLeft = new JoystickButton(driveStick,
			RobotMap.REAR_LEFT_MOTOR_BUTTON);
	private JoystickButton driveFrontRight = new JoystickButton(driveStick,
			RobotMap.FRONT_RIGHT_MOTOR_BUTTON);
	private JoystickButton driveRearRight = new JoystickButton(driveStick,
			RobotMap.REAR_RIGHT_MOTOR_BUTTON);
	
	private JoystickButton objectOnGroundButton = new JoystickButton(controller,
			RobotMap.OBJECT_ON_GROUND_BUTTON);
//	private JoystickButton pos1Button = new JoystickButton(arcadeBox,
//			RobotMap.POS_1_BUTTON);
//	private JoystickButton pos2Button = new JoystickButton(arcadeBox,
//			RobotMap.POS_2_BUTTON);
//	private JoystickButton pos3Button = new JoystickButton(arcadeBox,
//			RobotMap.POS_3_BUTTON);
//	private JoystickButton pos4Button = new JoystickButton(arcadeBox,
//			RobotMap.POS_4_BUTTON);
//	private JoystickButton pos5Button = new JoystickButton(arcadeBox,
//			RobotMap.POS_5_BUTTON);
//	private JoystickButton pos6Button = new JoystickButton(arcadeBox,
//			RobotMap.POS_6_BUTTON);
	private JoystickButton objectOnToteButton = new JoystickButton(controller,
			RobotMap.OBJECT_ON_TOTE_BUTTON);
	private JoystickButton noodleChuteSidewaysButton = new JoystickButton(controller,
			RobotMap.RC_NOODLE_SIDEWAYS);
	private JoystickButton noodleChuteUprightButton = new JoystickButton(controller,
			RobotMap.RC_NOODLE_UPRIGHT);
	
	private JoystickButton jogElevatorUpButton = new JoystickButton(controller,
			RobotMap.JOG_ELEVATOR_UP_BUTTON);
	private JoystickButton jogElevatorDownButton = new JoystickButton(controller,
			RobotMap.JOG_ELEVATOR_DOWN_BUTTON);

	private JogPOVTrigger triggerJogPOV = new JogPOVTrigger(); 
	private RotatePOVTrigger triggerRotatePOV = new RotatePOVTrigger();
	private MovePosPOVTrigger triggerMovePosPOV = new MovePosPOVTrigger();
	
	public JoystickButton initGyroButton = new JoystickButton(rotationStick, RobotMap.INITIALIZE_GYRO_BUTTON);
	private InitializeGyroTrigger initGyroTrigger = new InitializeGyroTrigger();
	
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
		
		triggerJogPOV.whenActive(new JoggingPOV());
		triggerRotatePOV.whenActive(new RotatingPOV());
		triggerMovePosPOV.whenActive(new MovePos());
		
		elevatorDownButton.whileHeld(new MoveElevator(-0.5));
		elevatorUpButton.whileHeld(new MoveElevator(0.5));
		
		objectOnGroundButton.whenPressed(new MoveElevatorTo(Elevator.Position.pickUp));
//		pos1Button.whenPressed(new MoveElevatorTo(Elevator.Position.score1));
//		pos2Button.whenPressed(new MoveElevatorTo(Elevator.Position.score2));
//		pos3Button.whenPressed(new MoveElevatorTo(Elevator.Position.score3));
//		pos4Button.whenPressed(new MoveElevatorTo(Elevator.Position.score4));
//		pos5Button.whenPressed(new MoveElevatorTo(Elevator.Position.score5));
//		pos6Button.whenPressed(new MoveElevatorTo(Elevator.Position.score6));
		objectOnToteButton.whenPressed(new MoveElevatorTo(Elevator.Position.pickUpOffTote));
		noodleChuteUprightButton.whenPressed(new MoveElevatorTo(Elevator.Position.getLitterUpright));
		noodleChuteSidewaysButton.whenPressed(new MoveElevatorTo(Elevator.Position.getLitterUpright));
		jogElevatorUpButton.whenPressed(new ElevatorJog(true));
		jogElevatorDownButton.whenPressed(new ElevatorJog(false));
		initGyroTrigger.whenActive(new InitGyro());
	}
	
	public int getDrivePOV(){
		return driveStick.getPOV();
	}
	
	public int getRotatePOV(){
		return rotationStick.getPOV();
	}
	public int getDpadPOV() {
		return controller.getPOV();
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
	 * Returns the degrees from 0 to the current direction of the rotation
	 * stick. If the stick is currently neutral, the last value is returned.
	 * 
	 * @return the degrees of the current or most recent rotation stick input or
	 *         Double.MAX_VALUE if the stick is not deflected.
	 */
	public double getRotationDegrees() {
		if ((Math.abs(rotationStick.getX()) >= RobotMap.ROTATION_DEAD_ZONE)
				|| (Math.abs(rotationStick.getY()) >= RobotMap.ROTATION_DEAD_ZONE))
			return rotationStick.getDirectionDegrees();
		else
			return Double.MAX_VALUE;
	}

}
