package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Utilizes a PID loop, with an encoder as the sensor, to
 * move modules vertically along a chain to preset point.
 * Also allows for micro-movements by the drive team.
 */
public class Elevator extends PIDSubsystem {
	// private Talon elevatorMotor = new Talon(RobotMap.ELEVATOR_MOTOR_CAN);
	private CANTalon elevatorMotor = new CANTalon(RobotMap.ELEVATOR_MOTOR_CAN);
	private Encoder elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_A_CHANNEL, RobotMap.ELEVATOR_ENCODER_B_CHANNEL);
	
	
	private static final double HEIGHT_OF_PLATFORM = 2.0;
	private static final double HEIGHT_OF_TOTE = 12.0;
	
	//Elevator Presets (inches)
	
	//On Ground
	private static final double OBJECT_ON_GROUND = 8.0;
	
	//Human Player Station
	private static final double NOODLE_CHUTE_RC_UPRIGHT = 16.0; //Change
	private static final double NOODLE_CHUTE_RC_SIDEWAYS = 24.0; //Change
	
	//On Totes
	private static final double OBJECT_ON_SINGLE_TOTE = OBJECT_ON_GROUND + HEIGHT_OF_TOTE;

	
	//Scoring Positions (Upright)
	private static final double SCORING_POSITION_1 = HEIGHT_OF_PLATFORM + HEIGHT_OF_TOTE + OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_2 = HEIGHT_OF_PLATFORM +(HEIGHT_OF_TOTE*2.0)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_3 = HEIGHT_OF_PLATFORM +(HEIGHT_OF_TOTE*3.0)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_4 = HEIGHT_OF_PLATFORM +(HEIGHT_OF_TOTE*4.0)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_5 = HEIGHT_OF_PLATFORM +(HEIGHT_OF_TOTE*5.0)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_6 = HEIGHT_OF_PLATFORM +(HEIGHT_OF_TOTE*6.0)+OBJECT_ON_GROUND;

	private static final double MIN_HEIGHT = OBJECT_ON_GROUND - 2.0;
	private static final double MAX_HEIGHT = SCORING_POSITION_5 + 4.0;
	private static final double JOG_INCHES = 0.5;
	
	//Encoder Mounts
	private static final double GEAR_SIZE = 1.5; //inches //TODO Is this the radius or diameter?
	private static final double INCHES_PER_REVOLUTION = Math.PI * 2 * GEAR_SIZE;
	private static final double PULSES_PER_REVOLUTION = 2048;
	
	public enum Position {
		//On Ground
		pickUp(OBJECT_ON_GROUND),
		//Human Player Station
		getLitterUpright(NOODLE_CHUTE_RC_UPRIGHT),
		getLitterSideways(NOODLE_CHUTE_RC_SIDEWAYS),
		//On Totes
		pickUpOffTote(OBJECT_ON_SINGLE_TOTE),
		//Scoring Positions (Upright)
		score1(SCORING_POSITION_1),
		score2(SCORING_POSITION_2),
		score3(SCORING_POSITION_3),
		score4(SCORING_POSITION_4),
		score5(SCORING_POSITION_5),
		score6(SCORING_POSITION_6);
		
		private double target;
		
		Position(double target){
			this.target = target;
		}
	}
	
	public Elevator() {
		super(0.1/MAX_HEIGHT - MIN_HEIGHT, 0.0, 0.0);
		setInputRange(MIN_HEIGHT, MAX_HEIGHT);
		setOutputRange(-0.1, 0.1);
		getPIDController().setContinuous(false);
		setAbsoluteTolerance(0.1);
		elevatorMotor.enableBrakeMode(true);
		enable();
		elevatorEncoder.setDistancePerPulse(INCHES_PER_REVOLUTION/PULSES_PER_REVOLUTION);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public void initDefaultCommand() {
		// No default command for the elevator.
	}
	public void moveTo(Position position) {
		setSetpoint(position.target);
	}
	public void stop() {
		setSetpoint(getPosition());
	}
	public void upOneScoringPos() {
		if(getSetpoint() < SCORING_POSITION_1) {
			setSetpoint(SCORING_POSITION_1);
		}
		else if(getSetpoint() < SCORING_POSITION_2) {
			setSetpoint(SCORING_POSITION_2);
		}
		else if(getSetpoint() < SCORING_POSITION_3) {
			setSetpoint(SCORING_POSITION_3);
		}
		else if(getSetpoint() < SCORING_POSITION_4) {
			setSetpoint(SCORING_POSITION_4);
		}
		else if(getSetpoint() < SCORING_POSITION_5) {
			setSetpoint(SCORING_POSITION_5);
		}
		else {
			setSetpoint(SCORING_POSITION_6);
		}
	}
	
	public void downOneScoringPos() {
		if(getSetpoint() >= SCORING_POSITION_6){
			setSetpoint(SCORING_POSITION_6);
		}
		if(getSetpoint() <= SCORING_POSITION_6 && getSetpoint() > SCORING_POSITION_5) {
			setSetpoint(SCORING_POSITION_5);
		}
		if(getSetpoint() <= SCORING_POSITION_5 && getSetpoint() > SCORING_POSITION_4) {
			setSetpoint(SCORING_POSITION_4);
		}
		if(getSetpoint() <= SCORING_POSITION_4 && getSetpoint() > SCORING_POSITION_3) {
			setSetpoint(SCORING_POSITION_3);
		}
		if(getSetpoint() <= SCORING_POSITION_3 && getSetpoint() > SCORING_POSITION_2) {
			setSetpoint(SCORING_POSITION_2);
		}
		if(getSetpoint() <= SCORING_POSITION_2 && getSetpoint() > SCORING_POSITION_1) {
			setSetpoint(SCORING_POSITION_1);
		}
	}
	public void jogUp() {
		stop();
		setSetpoint(getSetpoint() + JOG_INCHES);
	}
	public void jogDown() {
		stop();
		setSetpoint(getSetpoint() - JOG_INCHES);
	}
	public void testMoveElevator(double motorSpeed) {
			elevatorMotor.enableBrakeMode(true);
			elevatorMotor.set(motorSpeed);
	}
	public double getElevatorEncoderInches() {
		return elevatorEncoder.getDistance();
	}
	
	@Override
	protected double returnPIDInput() {
		return -getElevatorEncoderInches();
	}
	int i = 0;
	@Override
	protected void usePIDOutput(double output) {
		double elevatorMotorPower = output;
		if(getPIDController().onTarget() == false) {
			elevatorMotor.set(elevatorMotorPower);
		}
		else {
			elevatorMotor.set(0);
		}
		i++;
		if(i%10 == 0){
			// System.out.println("Setpoint: " + getSetpoint());
			// System.out.println("Encoder Value: " + getElevatorEncoderInches());
			// System.out.println("Encoder Raw: " + elevatorEncoder.get());
			// System.out.println("Motor Power: " + elevatorMotorPower);
		}
	}
}