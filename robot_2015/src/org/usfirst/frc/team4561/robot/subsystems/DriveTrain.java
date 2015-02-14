package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	 public CANTalon leftFront = new CANTalon(RobotMap.FRONT_LEFT_MOTOR_CAN);
	 public CANTalon leftRear = new CANTalon(RobotMap.REAR_LEFT_MOTOR_CAN);
	 public CANTalon rightFront = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR_CAN);
	 public CANTalon rightRear = new CANTalon(RobotMap.REAR_RIGHT_MOTOR_CAN);
	 
	 private RobotDrive robotDrive = new RobotDrive(leftFront, leftRear,
			rightFront, rightRear);
	 
	 private double currentX = 0.0;
	 private double currentY = 0.0;
	 private double lastRotation = 0.0;
	 private boolean fieldRelative = true;
	 private boolean deltaRotating = false;
	 private double lastGyroAngle = 0.0;
	 
	 //Gyroscope
	 private SerialPort gyro = new SerialPort(38400, Port.kMXP);
	 
		/*
		 * Reverse Drive Train encoder direction i.e. REVERSE_DIRECTION = True, then forward =
		 * "+", backward = "-"
		 */
		public static final boolean REVERSE_DIRECTION = true;
		/*
		 * Encoder count multiplier ENCODING_TYPE = EncodingType.k1X, count is
		 * normal ENCODING_TYPE = EncodingType.k2X, count is multiplied by 2
		 * ENCODING_TYPE = EncodingType.k4X, count is multiplied by 4
		 */
		public static final EncodingType ENCODING_TYPE = EncodingType.k1X;
	 
	 //Encoders
	 public Encoder frontLeftEncoder = new Encoder(RobotMap.FRONT_LEFT_ENCODER_A_CHANNEL,
			 										RobotMap.FRONT_LEFT_ENCODER_B_CHANNEL, REVERSE_DIRECTION);
	 public Encoder frontRightEncoder = new Encoder(RobotMap.FRONT_RIGHT_ENCODER_A_CHANNEL,
													RobotMap.FRONT_RIGHT_ENCODER_B_CHANNEL, REVERSE_DIRECTION);
	 public Encoder rearLeftEncoder = new Encoder(RobotMap.REAR_LEFT_ENCODER_A_CHANNEL,
			 										RobotMap.REAR_LEFT_ENCODER_B_CHANNEL, REVERSE_DIRECTION);
	 public Encoder rearRightEncoder = new Encoder(RobotMap.REAR_RIGHT_ENCODER_A_CHANNEL,
			 										RobotMap.REAR_RIGHT_ENCODER_B_CHANNEL, REVERSE_DIRECTION);
	 
	 
	private static final double INCHES_PER_REVOLUTION = Math.PI * 2 * 4;
	private static final double PULSES_PER_REVOLUTION = 2048;
	private static final double INCHES_PER_PULSE = INCHES_PER_REVOLUTION/PULSES_PER_REVOLUTION;
	

	public DriveTrain() {
		super(1.6/180.0, 0, 0); //TODO add "i" constant
		setInputRange(-180.0, 180.0);
		setOutputRange(-0.5, 0.5);
		getPIDController().setContinuous(true);
		setPercentTolerance(0.5);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		leftFront.enableBrakeMode(true);
		leftRear.enableBrakeMode(true);
		rightFront.enableBrakeMode(true);
		rightRear.enableBrakeMode(true);
		frontLeftEncoder.setDistancePerPulse(INCHES_PER_PULSE);
		frontRightEncoder.setDistancePerPulse(INCHES_PER_PULSE);
		rearLeftEncoder.setDistancePerPulse(INCHES_PER_PULSE);
		rearRightEncoder.setDistancePerPulse(INCHES_PER_PULSE);
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
	
	public void rotateTo(double angle) {
		setSetpoint(angle);
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
	
	public double getAngle() {
		gyro.writeString("#f");
		String yawPitchRoll = gyro.readString();
		if(yawPitchRoll == null || yawPitchRoll.isEmpty()) {
			return lastGyroAngle;
		}
		else {
			
			double doubleYaw = lastGyroAngle;
			try {
				yawPitchRoll = yawPitchRoll.substring(yawPitchRoll.indexOf('=') + 1);
				String stringYaw = yawPitchRoll.substring(0, yawPitchRoll.indexOf(','));
				doubleYaw = Double.parseDouble(stringYaw);
			}
			catch(NumberFormatException nfe) {
			}
			catch(StringIndexOutOfBoundsException sioobe) {
			}

			// System.out.println(doubleYaw);
			lastGyroAngle = doubleYaw;
			return doubleYaw;
		}

	}
	
	public double getNormalizedGyroAngle() {
		return normalizeAngle(getAngle());
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
			rightFront.set(-0.5);
		}
		else if(motorID == RobotMap.REAR_RIGHT_MOTOR_CAN) {
			rightRear.enableBrakeMode(true);
			rightRear.set(-0.5);
		}
	}
	/**
	 * Gets the value in inches of a single encoder.
	 * @param id
	 * @return
	 */
	public double getSingleEncoderInches(int id) {
		double[] encoderInches;
		encoderInches = new double[4];
		encoderInches[0] = frontLeftEncoder.getDistance();
		encoderInches[1]= frontRightEncoder.getDistance();
		encoderInches[2]= rearLeftEncoder.getDistance();
		encoderInches[3]= rearRightEncoder.getDistance();
		return encoderInches[id];
	}
	/**
	 * Gets the value in ticks of a single encoder.
	 * @param id
	 * @return
	 */
	public double getSingleEncoderTicks(int id) {
		double[] encoderInches;
		encoderInches = new double[4];
		encoderInches[0] = frontLeftEncoder.get();
		encoderInches[1]= frontRightEncoder.get();
		encoderInches[2]= rearLeftEncoder.get();
		encoderInches[3]= rearRightEncoder.get();
		return encoderInches[id];
	}
	 /**
	  * @return An array of doubles of the inches each encoder has moved in the format 
	  * [frontLeft, frontRight, rearLeft, rearRight]
	  */
	public double[] getEncoderInches() {
		double[] encoderInches;
		encoderInches = new double[4];
		encoderInches[0] = frontLeftEncoder.getDistance();
		encoderInches[1]= frontRightEncoder.getDistance();
		encoderInches[2]= rearLeftEncoder.getDistance();
		encoderInches[3]= rearRightEncoder.getDistance();
		return encoderInches;
	}
	 /**
	  * @return An array of doubles of the ticks each encoder has moved in the format 
	  * [frontLeft, frontRight, rearLeft, rearRight]
	  */
	public double[] getEncoderTicks() {
		double[] encoderInches;
		encoderInches = new double[4];
		encoderInches[0] = frontLeftEncoder.get();
		encoderInches[1]= frontRightEncoder.get();
		encoderInches[2]= rearLeftEncoder.get();
		encoderInches[3]= rearRightEncoder.get();
		return encoderInches;
	}
	
	
	public double getAbsAverageEncoderInches() {
		
		double frontLeftEncoderInches = Math.abs(frontLeftEncoder.getDistance());
		double frontRightEncoderInches = Math.abs(frontLeftEncoder.getDistance());
		double rearLeftEncoderInches = Math.abs(frontLeftEncoder.getDistance());
		double rearRightEncoderInches = Math.abs(frontLeftEncoder.getDistance());
		
		double encoderSumInches = frontLeftEncoderInches //+ frontRightEncoderInches 
									+ rearLeftEncoderInches; // + rearRightEncoderInches; TODO right encoders fried
		double encoderAverageInches = encoderSumInches /2; // / 4;
		
		return encoderAverageInches;
	}
	

	
	public void fullEncoderReset() {
		frontLeftEncoder.reset();
		frontRightEncoder.reset();
		rearLeftEncoder.reset();
		rearRightEncoder.reset();
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
//		i++;
//		if(i%10 == 0){
//			System.out.println("Rot Power: " + rot); // motor power
//			System.out.println("NormalizedGyroAngle: " +  getNormalizedGyroAngle()); // print new gyro angle);
//			System.out.println("Raw gyro angle: " + gyro.getAngle());
//			System.out.println("Drive Stick: (" + Robot.oi.getDriveX() + ", " + Robot.oi.getDriveY() + ") "); // drivestick (x, y)
//			System.out.println("Rot Stick Degrees: " + Robot.oi.getRotationDegrees()); //rot stick degrees
//		}
		lastRotation = rot;
		robotDrive.mecanumDrive_Cartesian(currentX, currentY, rot, getNormalizedGyroAngle());
	}

	public double getCurrentX() {
		return currentX;
	}

	public double getCurrentY() {
		return currentY;
	}
	
	public double getLastRotation() {
		return lastRotation;
	}

	public boolean isFieldRelative() {
		return fieldRelative;
	}

	public double getLastGyroAngle() {
		return lastGyroAngle;
	}
}
