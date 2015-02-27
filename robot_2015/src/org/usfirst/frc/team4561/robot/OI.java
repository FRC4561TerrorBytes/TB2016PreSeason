package org.usfirst.frc.team4561.robot;

import org.usfirst.frc.team4561.robot.commands.ClawGrab;
import org.usfirst.frc.team4561.robot.commands.ClawRelease;
import org.usfirst.frc.team4561.robot.commands.ElevatorJog;
import org.usfirst.frc.team4561.robot.commands.EnterTouringMode;
import org.usfirst.frc.team4561.robot.commands.ExtenderPitPrep;
import org.usfirst.frc.team4561.robot.commands.IndividualMotorDrive;
import org.usfirst.frc.team4561.robot.commands.JoggingPOV;
import org.usfirst.frc.team4561.robot.commands.MoveElevatorNonPID;
import org.usfirst.frc.team4561.robot.commands.MoveElevatorTo;
import org.usfirst.frc.team4561.robot.commands.MovePos;
import org.usfirst.frc.team4561.robot.commands.ReelInExtenderUnlimited;
import org.usfirst.frc.team4561.robot.commands.RotatingPOV;
import org.usfirst.frc.team4561.robot.commands.ResetGyro;
import org.usfirst.frc.team4561.robot.subsystems.Elevator;
import org.usfirst.frc.team4561.robot.triggers.JogPOVTrigger;
import org.usfirst.frc.team4561.robot.triggers.MoveElevatorTriggerNonPID;
import org.usfirst.frc.team4561.robot.triggers.MovePosPOVTrigger;
import org.usfirst.frc.team4561.robot.triggers.RobotRelativeTrigger;
import org.usfirst.frc.team4561.robot.triggers.RotatePOVTrigger;
import org.usfirst.frc.team4561.robot.triggers.ResetGyroTrigger;

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

	private boolean robotIsRelative = false;
	private static final double TOURING_MODE_MULTIPLIER = 0.5;
	private boolean isTouringMode = false;
	
	/*
	 * MecanumDrive system controls
	 */
	private Joystick driveStick = new Joystick(RobotMap.DRIVE_JOYSTICK);
	private Joystick rotationStick = new Joystick(RobotMap.ROTATION_JOYSTICK);
	private Joystick controller = new Joystick(RobotMap.CONTROLLER);

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
	private JoystickButton inGameReelInExtender = new JoystickButton(driveStick,
			RobotMap.IN_GAME_REEL_IN_EXTENDER);
	private JoystickButton pitPrepSlowExtenderIn = new JoystickButton(driveStick,
			RobotMap.PIT_PREP_SLOW_EXTENDER_IN);
	private JoystickButton pitPrepSlowExtenderOut = new JoystickButton(driveStick,
			RobotMap.PIT_PREP_SLOW_EXTENDER_OUT);
	private JoystickButton touringModeButton = new JoystickButton(driveStick, RobotMap.TOURING_MODE_BUTTON);
	
	private JoystickButton gyroResetButton1 = new JoystickButton(rotationStick,
			RobotMap.GYRO_RESET_BUTTON_1);
	private JoystickButton gyroResetButton2 = new JoystickButton(rotationStick,
			RobotMap.GYRO_RESET_BUTTON_2);
	
	
	// The next 7 are only wired to commands if the elevator subsystem
	// is actually the PID subsystem.
	private JoystickButton objectOnGroundButton = new JoystickButton(controller,
			RobotMap.OBJECT_ON_GROUND_BUTTON);
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
	private MovePosPOVTrigger triggerMovePosPOV = new MovePosPOVTrigger();
	
	private JoystickButton openClawButton = new JoystickButton(controller,
			RobotMap.OPEN_CLAW);
	private JoystickButton closeClawButton = new JoystickButton(controller,
			RobotMap.CLOSE_CLAW);
	

	private JogPOVTrigger triggerJogPOV = new JogPOVTrigger(); 
	private RotatePOVTrigger triggerRotatePOV = new RotatePOVTrigger();
	private MoveElevatorTriggerNonPID triggerMoveElevatorPOVNonPID = new MoveElevatorTriggerNonPID();
	private ResetGyroTrigger triggerResetGyro = new ResetGyroTrigger();
	private RobotRelativeTrigger triggerRobotRelative = new RobotRelativeTrigger();

	/**
	 * Returns true if driving should be robot relative (vs field relative).
	 * 
	 * @return true if in robot relative driving mode
	 */
	
	public boolean isRobotRelative() {
		if(triggerRobotRelative.get()) {
			robotIsRelative = (robotIsRelative) ? false:true;
		}
		return robotIsRelative;
	}
	
	public boolean isRobotRelativeButtonPressed() {
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
		inGameReelInExtender.whileHeld(new ReelInExtenderUnlimited());
		pitPrepSlowExtenderIn.whileHeld(new ExtenderPitPrep(true));
		pitPrepSlowExtenderOut.whileHeld(new ExtenderPitPrep(false));
		touringModeButton.whileHeld(new EnterTouringMode());		
		// Robot relative jogging triggers
		triggerJogPOV.whenActive(new JoggingPOV());
		triggerRotatePOV.whenActive(new RotatingPOV());
		
		// Non-PID elevator trigger
		triggerMoveElevatorPOVNonPID.whileActive(new MoveElevatorNonPID());
		
		//Reset Gyro Trigger
		triggerResetGyro.whenActive(new ResetGyro());
		
		// PID elevator trigger and buttons
		if (Robot.commonElevator instanceof Elevator) {
			triggerMovePosPOV.whenActive(new MovePos());
			objectOnGroundButton.whenPressed(new MoveElevatorTo(Elevator.Position.pickUp));
			objectOnToteButton.whenPressed(new MoveElevatorTo(Elevator.Position.pickUpOffTote));
			noodleChuteUprightButton.whenPressed(new MoveElevatorTo(Elevator.Position.getLitterUpright));
			noodleChuteSidewaysButton.whenPressed(new MoveElevatorTo(Elevator.Position.getLitterUpright));
			jogElevatorUpButton.whenPressed(new ElevatorJog(true));
			jogElevatorDownButton.whenPressed(new ElevatorJog(false));
		}
		
		openClawButton.whenPressed(new ClawRelease());
		closeClawButton.whenPressed(new ClawGrab());
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
	public double getControllerRightStickY() {
		double yStick = controller.getRawAxis(RobotMap.RIGHT_STICK_Y);
		if(Math.abs(yStick) < RobotMap.DRIVE_DEAD_ZONE) {
			yStick = 0.0;
		}
		return yStick;
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
			return Robot.driveTrain.getNormalizedGyroAngle();
	}
	
	public boolean getGyroResetLockPressed() {
		return gyroResetButton1.get() && gyroResetButton2.get();
	}
	
	public double getRotX() {
		return rotationStick.getX();
	}
	
	public boolean isTouringMode() {
		return isTouringMode;
	}
	
	public void setTouringMode(boolean on) {
		isTouringMode = on;
	}
	
	public double getTouringPower() {
		return TOURING_MODE_MULTIPLIER;
	}
	

}
