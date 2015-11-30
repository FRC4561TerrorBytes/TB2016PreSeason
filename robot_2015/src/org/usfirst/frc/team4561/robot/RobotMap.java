package org.usfirst.frc.team4561.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Joysticks
	public static final int DRIVE_STICK = 0;
	public static final int ROT_STICK = 1;
	
	// Controller
	public static final int CONTROLLER = 2;
	//Controller Buttons
	public static final int A_BUTTON = 1;
	public static final int B_BUTTON = 2;
	public static final int X_BUTTON = 3;
	public static final int Y_BUTTON = 4;
	public static final int LEFT_BUMPER = 5;
	public static final int RIGHT_BUMPER = 6;
	public static final int BACK_BUTTON = 7;
	public static final int START_BUTTON = 8;
	public static final int LEFT_STICK = 9;
	public static final int RIGHT_STICK = 10;
	
	// Motor Controllers
	public static final int BELT_MOTOR = 7; //TODO: Placeholder
	public static final int SHOOTER_MOTOR = 9;
	public static final int FRONT_LEFT_CONTROLLER = 2;
	public static final int REAR_LEFT_CONTROLLER = 3;
	public static final int FRONT_RIGHT_CONTROLLER = 1;
	public static final int REAR_RIGHT_CONTROLLER = 0;
	
	// Motor Controller Macros
	// True means Victor, false means TalonSR
	public static final boolean DRIVETRAIN_USE_VICTORS = true;
	public static final boolean SHOOTER_USE_VICTORS = true;
	public static final boolean LOADER_USE_VICTORS = true;
	
	// Encoders
	public static final int SHOOTER_ENCODER_A_CHANNEL = 4;
	public static final int SHOOTER_ENCODER_B_CHANNEL = 5;
	
	//TODO: Add loaded sensor port
	
	// Feedback LEDs
	public static final int FLY_WHEEL_LED = 1;
	public static final int LOADED_LED = 2;
	public static final int READY_LED = 3;
}
