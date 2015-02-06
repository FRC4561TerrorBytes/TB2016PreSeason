package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

/**
 * The main subsystem used for driving. This drive train is configured 
 * to use mechanum wheels and rotate to a heading based on the given 
 * angle from the rotation joystick.
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
	 
	 private double currentX = 0.0;
	 private double currentY = 0.0;
	 private boolean fieldRelative = true;
	 private boolean deltaRotating = false;
	 
	 //Gyroscope
	 private Gyro gyro = null;
	 
	 //Encoders
	 public Encoder frontLeftEncoder = new Encoder(RobotMap.FRONT_LEFT_ENCODER_A_CHANNEL,
			 										RobotMap.FRONT_RIGHT_ENCODER_B_CHANNEL);
	 public Encoder frontRightEncoder = new Encoder(RobotMap.FRONT_LEFT_ENCODER_A_CHANNEL,
													RobotMap.FRONT_RIGHT_ENCODER_B_CHANNEL);
	 public Encoder rearLeftEncoder = new Encoder(RobotMap.FRONT_LEFT_ENCODER_A_CHANNEL,
			 										RobotMap.FRONT_RIGHT_ENCODER_B_CHANNEL);
	 public Encoder rearRightEncoder = new Encoder(RobotMap.FRONT_LEFT_ENCODER_A_CHANNEL,
			 										RobotMap.FRONT_RIGHT_ENCODER_B_CHANNEL);
	
	 public DriveTrain() { 
		super(0.8/180, 0, 0); //TODO add "i" constant
		setInputRange(-180.0, 180.0);
		getPIDController().setContinuous(true);
		setPercentTolerance(3.0);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		gyro.initGyro();
		leftFront.enableBrakeMode(true);
		leftRear.enableBrakeMode(true);
		rightFront.enableBrakeMode(true);
		rightRear.enableBrakeMode(true);
	 }
	
	/**
	 * This should be called after robot warm up and just before the match
	 * starts.
	 */
	public synchronized void initGyro() {
		if (gyro == null) {
			gyro = new Gyro(RobotMap.GYRO_IN);
		}
	}
	 
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new MecanumDrive());
	}

	public void driveRobotRelative(double x_v, double y_v) {
		currentX = x_v;
		currentY = y_v;		
		fieldRelative = false;
		setSetpoint(getNormalizedGyroAngle());
	}

	public void driveFieldRelative(double x_v, double y_v, double rotationDegrees) {
		currentX = x_v;
		currentY = y_v;
		fieldRelative = true;
		setSetpoint(rotationDegrees);
	}

	
	/**
	 * Change the rotation target by the deltaRotation. A negative value moves
	 * the target left (counter clockwise) and a positive value moves the target
	 * right (clockwise).
	 * 
	 * @param deltaRotation
	 */
	public void driveRotationRelative(double deltaRotation) {
		deltaRotating = true;
		double newSetpoint = getSetpoint() + deltaRotation;
		setSetpoint(normalizeAngle(newSetpoint));
	}
	
	public void stop() {
//		currentX = 0.0;
//		currentY = 0.0;
	}
	
	/**
	 * Reset the gyro to 0 heading.
	 */
	public void resetGyro() {
		gyro.reset();
	}
	
	public double getNormalizedGyroAngle() {
		return normalizeAngle(gyro.getAngle());
	}
	
	/**
	 * Converts an angle to the [-180, 180] range.
	 * @param angle
	 * @return
	 */
	private double normalizeAngle(double angle) {
		double norm = angle % 360.0;
		if (Math.abs(norm) > 180.0) {
			norm = (norm < 0) ? norm + 360.0 : norm - 360.0;
		}
		return norm;
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
	
	public double getAverageEncoderInches() {
		double frontLeftEncoderInches = frontLeftEncoder.getDistance();
		double frontRightEncoderInches = frontRightEncoder.getDistance();
		double rearLeftEncoderInches = rearLeftEncoder.getDistance();
		double rearRightEncoderInches = rearRightEncoder.getDistance();
		double encoderInchesSum = frontLeftEncoderInches + frontRightEncoderInches + rearLeftEncoderInches + rearRightEncoderInches;
		double encoderInchesAverage = encoderInchesSum/4;
		return encoderInchesAverage;
	}

	@Override
	protected double returnPIDInput() {
		return getNormalizedGyroAngle();
	}
	int i = 0;
	@Override
	protected void usePIDOutput(double output) {
		double rot = 0.0;
		if (!getPIDController().onTarget()) {
			if (fieldRelative || deltaRotating) {
				rot = output;
			}
		} else {
			deltaRotating = false;
		}
		i++;
		if(i%10 == 0){
			System.out.println("Motor Power: " + rot); // motor power
			System.out.println("NormalizedGyroAngle: " +  getNormalizedGyroAngle()); // print new gyro angle);
			System.out.println("Drive Stick: (" + Robot.oi.getDriveX() + ", " + Robot.oi.getDriveY() + ") "); // drivestick (x, y)
			System.out.println("Rot Stick Degrees: " + Robot.oi.getRotationDegrees()); //rot stick degrees
		}
		robotDrive.mecanumDrive_Cartesian(currentX, currentY, rot, getNormalizedGyroAngle());
	}
}
