package org.usfirst.frc.team4561.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	/*
	 * Joystick mappings
	 */
	public static final int DRIVE_JOYSTICK = 0;
	public static final int ROTATION_JOYSTICK = 1;
	public static final int CONTROLLER = 2;
	
	// Dead zone thresholds
	public static final double DRIVE_DEAD_ZONE = 0.3;
	public static final double ROTATION_DEAD_ZONE = 0.3;

	// These are on the drive stick
	public static final int ROBOT_RELATIVE_BUTTON = 1;
	public static final int IN_GAME_REEL_IN_EXTENDER = 3;
	public static final int FRONT_LEFT_MOTOR_BUTTON = 7;
	public static final int REAR_LEFT_MOTOR_BUTTON = 9;
	public static final int FRONT_RIGHT_MOTOR_BUTTON = 8;
	public static final int REAR_RIGHT_MOTOR_BUTTON = 10;
	public static final int PIT_PREP_SLOW_EXTENDER_IN = 11;
	public static final int PIT_PREP_SLOW_EXTENDER_OUT = 12;
		
	/*
	 * Controller button mappings.
	 */
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
	
	public static final int OBJECT_ON_GROUND_BUTTON = A_BUTTON; //PG
	public static final int OBJECT_ON_TOTE_BUTTON = B_BUTTON; //PT
	public static final int RC_NOODLE_UPRIGHT = X_BUTTON; //NU
	public static final int RC_NOODLE_SIDEWAYS = Y_BUTTON; //NS
	public static final int JOG_ELEVATOR_DOWN_BUTTON = LEFT_BUMPER; //JU
	public static final int JOG_ELEVATOR_UP_BUTTON = RIGHT_BUMPER; //JD
	public static final int OPEN_CLAW = BACK_BUTTON;
	public static final int CLOSE_CLAW = START_BUTTON;
	
	/*
	 * Sensors stuff
	 */
	public static final int GYRO_IN = 0; //analog 0
	
	// The following have taken over the right rear wheel encoder ports.
	public static final int ELEVATOR_LIMIT_SW_BOTTOM = 4; //digital 10; corresponds to MXP 31
	public static final int ELEVATOR_LIMIT_SW_TOP = 5; //digital 11; corresponds to MXP 18
	
	/*
	 * Controller axis mappings.
	 */
	public static final int LEFT_STICK_X = 0; // left: -, right, +
	public static final int LEFT_STICK_Y = 1; // up: -, down, +
	public static final int LEFT_TRIGGER = 2; // depressed: +, released: neutral
	public static final int RIGHT_TRIGGER = 3; // depressed: +, released: neutral
	public static final int RIGHT_STICK_X = 4; // left: -, right, +
	public static final int RIGHT_STICK_Y = 5; // up: -, down, +

	/*
	 * DriveTrain Talon mappings.
	 */
	public static final int REAR_LEFT_MOTOR = 0;
	public static final int FRONT_LEFT_MOTOR = 1;
	public static final int REAR_RIGHT_MOTOR = 2;
	public static final int FRONT_RIGHT_MOTOR = 3;
	/*
	 * Drivetrain TalonSRX mappings.
	 */
	public static final int REAR_LEFT_MOTOR_CAN = 1;
	public static final int FRONT_LEFT_MOTOR_CAN = 4;
	public static final int REAR_RIGHT_MOTOR_CAN = 3;
	public static final int FRONT_RIGHT_MOTOR_CAN = 2; 
	public static final int ELEVATOR_MOTOR = 5;
	public static final int EXTENDER_MOTOR = 6;

	/*
	 * Pneumatics mappings
	 */
//	public static final int CLAW_PORT = 0;
	
	public static final int CLAW_CAN = 6;
	public static final int CLAW_PORT_1 = 0;
	public static final int CLAW_PORT_2 = 1;
	/*
	 * Drivetrain Encoder mappings.
	 */
	public static final int REAR_LEFT_ENCODER_A_CHANNEL = 0;
	public static final int FRONT_LEFT_ENCODER_A_CHANNEL = 6;
	public static final int REAR_RIGHT_ENCODER_A_CHANNEL = 4;
	public static final int FRONT_RIGHT_ENCODER_A_CHANNEL = 2;

	public static final int REAR_LEFT_ENCODER_B_CHANNEL = 1;
	public static final int FRONT_LEFT_ENCODER_B_CHANNEL = 7;
	public static final int REAR_RIGHT_ENCODER_B_CHANNEL = 5;
	public static final int FRONT_RIGHT_ENCODER_B_CHANNEL = 3;

	/*
	 * Elevator Encoder Mappings
	 */
	public static final int ELEVATOR_ENCODER_A_CHANNEL = 8;
	public static final int ELEVATOR_ENCODER_B_CHANNEL = 9;


}
