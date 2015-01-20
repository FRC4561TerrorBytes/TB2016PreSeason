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
	
	/*
	 * DriveTrain actuator mappings.
	 */
	public static final int REAR_LEFT_MOTOR = 0;
	public static final int FRONT_LEFT_MOTOR = 1;
	public static final int REAR_RIGHT_MOTOR = 2;
	public static final int FRONT_RIGHT_MOTOR = 3;
	/* 
	 * Drivetrain TalonSRX mappings.
	 */
	public static final int REAR_LEFT_MOTOR_CAN = 1;   //change device ID
	public static final int FRONT_LEFT_MOTOR_CAN = 2;  //change device ID
	public static final int REAR_RIGHT_MOTOR_CAN = 3;  //change device ID
	public static final int FRONT_RIGHT_MOTOR_CAN = 4; //change device ID
	
	/* 
	 * Drivetrain Encoder mappings.
	 */
	public static final int REAR_LEFT_ENCODER_A_CHANNEL = 0;   //change port #
	public static final int FRONT_LEFT_ENCODER_A_CHANNEL = 0;  //change port #
	public static final int REAR_RIGHT_ENCODER_A_CHANNEL = 0;  //change port #
	public static final int FRONT_RIGHT_ENCODER_A_CHANNEL = 0; //change port #
	public static final int REAR_LEFT_ENCODER_B_CHANNEL = 0;   //change port #
	public static final int FRONT_LEFT_ENCODER_B_CHANNEL = 0;  //change port #
	public static final int REAR_RIGHT_ENCODER_B_CHANNEL = 0;  //change port #
	public static final int FRONT_RIGHT_ENCODER_B_CHANNEL = 0; //change port #
	/*
	 * Reverse encoder direction
	 * i.e. REVERSE_DIRECTION = True, then forward = "+", backward = "-"
	 */
	public static final boolean REVERSE_DIRECTION = true;
	/*
	 * Encoder count multiplier
	 * ENCODING_TYPE = EncodingType.k1X, count is normal
	 * ENCODING_TYPE = EncodingType.k2X, count is multiplied by 2
	 * ENCODING_TYPE = EncodingType.k4X, count is multiplied by 4
	 */
	public static final EncodingType ENCODING_TYPE = EncodingType.k1X;
	
}
