package org.usfirst.frc.team4561.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;

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
	public static final int DRIVE_JOYSTICK = 2;
	public static final int ROTATION_JOYSTICK = 1;
	public static final int ROBOT_RELATIVE_BUTTON = 1;

	public static final int ROBOT_JOG_RIGHT_BUTTON = 5;
	public static final int ROBOT_JOG_LEFT_BUTTON = 4;
	
	public static final int ROBOT_STRIFE_RIGHT_BUTTON = 5;
	public static final int ROBOT_STRIFE_LEFT_BUTTON = 4;
	// Dead zone thresholds
	public static final double DRIVE_DEAD_ZONE = 0.3;
	public static final double ROTATION_DEAD_ZONE = 0.3;

	public static final int FRONT_LEFT_MOTOR_BUTTON = 6;
	public static final int REAR_LEFT_MOTOR_BUTTON = 7;
	public static final int FRONT_RIGHT_MOTOR_BUTTON = 11;
	public static final int REAR_RIGHT_MOTOR_BUTTON = 10;
	/*
	 * XBox Controller button mappings.
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
	
	/*
	 * Gyroscope stuff
	 */
	
	public static final int GYRO_IN = 0; //analog 0
	
	/*
	 * XBox Controller axis mappings.
	 */
	public static final int LEFT_STICK_X = 1; // left: -, right, +
	public static final int LEFT_STICK_Y = 2; // up: -, down, +
	public static final int TRIGGERS = 3; // left: +, right, -
	public static final int RIGHT_STICK_X = 4; // left: -, right, +
	public static final int RIGHT_STICK_Y = 5; // up: -, down, +
	public static final int DPAD = 6; // RECOMMENDED: DO NOT USE. EXTREMLY
										// buggy.
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
	public static final int ELEVATOR_MOTOR_CAN = 5;

	/*
	 * Drivetrain Encoder mappings.
	 */
	// public static final int REAR_LEFT_ENCODER_A_CHANNEL = 0; //change port #
	// public static final int FRONT_LEFT_ENCODER_A_CHANNEL = 0; //change port #
	// public static final int REAR_RIGHT_ENCODER_A_CHANNEL = 0; //change port #
	// public static final int FRONT_RIGHT_ENCODER_A_CHANNEL = 0; //change port
	// #
	// public static final int REAR_LEFT_ENCODER_B_CHANNEL = 0; //change port #
	// public static final int FRONT_LEFT_ENCODER_B_CHANNEL = 0; //change port #
	// public static final int REAR_RIGHT_ENCODER_B_CHANNEL = 0; //change port #
	// public static final int FRONT_RIGHT_ENCODER_B_CHANNEL = 0; //change port
	// #
	/*
	 * Reverse encoder direction i.e. REVERSE_DIRECTION = True, then forward =
	 * "+", backward = "-"
	 */
	public static final boolean REVERSE_DIRECTION = true;
	/*
	 * Encoder count multiplier ENCODING_TYPE = EncodingType.k1X, count is
	 * normal ENCODING_TYPE = EncodingType.k2X, count is multiplied by 2
	 * ENCODING_TYPE = EncodingType.k4X, count is multiplied by 4
	 */
	public static final EncodingType ENCODING_TYPE = EncodingType.k1X;
	
	//Elevator Set Height Points (inches)
	public static final double RECYCLING_CAN_ON_GROUND = 9;
	public static final double TOTE_ON_GROUND = 9;
	public static final double RECYCLING_CAN_ON_PLATFORM = 11;
	public static final double TOTE_ON_PLATFORM = 11;
	
}
