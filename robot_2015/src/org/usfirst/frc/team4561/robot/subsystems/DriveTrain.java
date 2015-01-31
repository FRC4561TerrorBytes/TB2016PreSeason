package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	//Talons
	//Uncomment to use PWMTalons
//	private Talon leftFront = new Talon(RobotMap.FRONT_LEFT_MOTOR);
//	private Talon leftRear = new Talon(RobotMap.REAR_LEFT_MOTOR);
//	private Talon rightFront = new Talon(RobotMap.FRONT_RIGHT_MOTOR);
//	private Talon rightRear = new Talon(RobotMap.REAR_RIGHT_MOTOR);
	
	//CANTalonSRXs
	//Uncomment to use CANTalonSRXs
	 private CANTalon leftFront = new CANTalon(RobotMap.FRONT_LEFT_MOTOR_CAN);
	 private CANTalon leftRear = new CANTalon(RobotMap.REAR_LEFT_MOTOR_CAN);
	 private CANTalon rightFront = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR_CAN);
	 private CANTalon rightRear = new CANTalon(RobotMap.REAR_RIGHT_MOTOR_CAN);
	 
	 private RobotDrive robotDrive = new RobotDrive(leftFront, leftRear,
			rightFront, rightRear);
	 
	 //Gyroscope
	 private Gyro gyro = new Gyro(RobotMap.GYRO_IN);
	 
	 //Encoders
	 private Encoder frontLeftEncoder = new Encoder(RobotMap.FRONT_LEFT_ENCODER_A_CHANNEL, RobotMap.FRONT_LEFT_ENCODER_B_CHANNEL,
			 										RobotMap.REVERSE_DIRECTION, RobotMap.ENCODING_TYPE);
	 private Encoder rearLeftEncoder = new Encoder(RobotMap.REAR_LEFT_ENCODER_A_CHANNEL, RobotMap.REAR_LEFT_ENCODER_B_CHANNEL,
			 										RobotMap.REVERSE_DIRECTION, RobotMap.ENCODING_TYPE);
	 private Encoder frontRightEncoder = new Encoder(RobotMap.FRONT_RIGHT_ENCODER_A_CHANNEL, RobotMap.FRONT_RIGHT_ENCODER_B_CHANNEL, 
			 										RobotMap.REVERSE_DIRECTION, RobotMap.ENCODING_TYPE);
	 private Encoder rearRightEncoder = new Encoder(RobotMap.REAR_RIGHT_ENCODER_A_CHANNEL, RobotMap.REAR_RIGHT_ENCODER_B_CHANNEL, 
			 										RobotMap.REVERSE_DIRECTION, RobotMap.ENCODING_TYPE);
	
	public DriveTrain() { 
		super(0.3, 0, 0);
		getPIDController().setContinuous(false);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		gyro.initGyro();
	}
	 
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new MecanumDrive());
	}
	public void rotateToAngle(double heading) {
		setSetpoint(heading);
	}	
	public void driveRobotRelative(double x_v, double y_v, double rot) {
		leftFront.enableBrakeMode(true);
		leftRear.enableBrakeMode(true);
		rightFront.enableBrakeMode(true);
		rightRear.enableBrakeMode(true);
		robotDrive.mecanumDrive_Cartesian(x_v, y_v, rot, 0.0);
	}

	public void driveFieldRelative(double x_v, double y_v, double rot) {
		leftFront.enableBrakeMode(true);
		leftRear.enableBrakeMode(true);
		rightFront.enableBrakeMode(true);
		rightRear.enableBrakeMode(true);
		robotDrive.mecanumDrive_Cartesian(x_v, y_v, rot, gyro.getAngle());
	}
	
	public void calcFastestTurn(){
		//Changes the setpoint to make sure that the robot turns in the correct direction
		//for the fastest route to the desired position.
		if(getPIDController().getError() > 180) {
			//Fixes positive direction turns above 180.
			setSetpointRelative(-360);
		}
		if(getPIDController().getError() < -180) {
			//Fixes negative direction turns above 180.
				setSetpointRelative(360);
		}
	}
	public void stop() {
		robotDrive.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
	}
	
	public double getGyroAngle() {
		//Returns the gyroscope angle. Angle continues upward once it its 360.
		return gyro.getAngle();
	}
	
	public double getNormalizedGyroAngle() {
		return getGyroAngle() % 360.0;
	}
	
	public void testSingleMotor(int motorID) {
		if(motorID == RobotMap.FRONT_LEFT_MOTOR_CAN) {
			leftFront.enableBrakeMode(true);
			leftFront.set(0.5);
		}
		else if(motorID == RobotMap.REAR_LEFT_MOTOR_CAN) {
			leftRear.enableBrakeMode(true);
			leftRear.set(0.5);
		}
		else if(motorID == RobotMap.FRONT_RIGHT_MOTOR_CAN) {
			rightFront.enableBrakeMode(true);
			rightFront.set(0.5);
		}
		else if(motorID == RobotMap.REAR_RIGHT_MOTOR_CAN) {
			rightRear.enableBrakeMode(true);
			rightRear.set(0.5);
		}
	}
	public int[] getDriveEncoderCount() {
		int[] encoderCount;
		encoderCount = new int[4];
		encoderCount[0] = frontLeftEncoder.get();
		encoderCount[1] = rearLeftEncoder.get();
		encoderCount[2] = frontRightEncoder.get();
		encoderCount[3] = rearRightEncoder.get();
		return encoderCount;
	}
	public void printDriveEncoderCount() {
		//TEMPORARY. For testing purposes only.
		int[] encoderCount;
		encoderCount = new int[4];
		encoderCount[0] = frontLeftEncoder.get();
		encoderCount[1] = rearLeftEncoder.get();
		encoderCount[2] = frontRightEncoder.get();
		encoderCount[3] = rearRightEncoder.get();
		//Prints to RIOLOG: [frontLeftEncoderCount rearLeftEncoderCount frontRightEncoderCount rearEncoderCount]
	    for(int a = 0;a < 4; a++) {
	    	System.out.print(encoderCount[a] + " ");
	    }
	} 

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return getNormalizedGyroAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		if (getPIDController().onTarget() ==  false) {
			calcFastestTurn();
			double rot = output/(180*getPIDController().getP());
			robotDrive.mecanumDrive_Cartesian(0, 0, rot, getNormalizedGyroAngle());
		}
	}
}
