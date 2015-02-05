package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Utilizes a PID loop, with an encoder as the sensor, to
 * move modules vertically along a chain to preset point.
 * Also allows for micro-movements by the drive team.
 */
public class Elevator extends PIDSubsystem {
	private CANTalon elevatorMotor = new CANTalon(RobotMap.ELEVATOR_MOTOR_CAN);
	private Encoder elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_A_CHANNEL, RobotMap.ELEVATOR_ENCODER_B_CHANNEL);
	
	//Elevator Set Height Points (inches)
	private static final double FLOOR = 0;
	private static final double HEIGHT_OF_TOTE = 12;
	private static final double HEIGHT_OF_PLATFORM = 2;
	private static final double OBJECT_ON_GROUND = 8;
	private static final double SCORING_POSITION_1 = HEIGHT_OF_PLATFORM + HEIGHT_OF_TOTE + OBJECT_ON_GROUND; //placing tote on 1 one existing tote
	private static final double SCORING_POSITION_2 = HEIGHT_OF_PLATFORM +(HEIGHT_OF_TOTE*2)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_3 = HEIGHT_OF_PLATFORM +(HEIGHT_OF_TOTE*3)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_4 = HEIGHT_OF_PLATFORM +(HEIGHT_OF_TOTE*4)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_5 = HEIGHT_OF_PLATFORM +(HEIGHT_OF_TOTE*5)+OBJECT_ON_GROUND;
	private static final double MIN_HEIGHT = OBJECT_ON_GROUND - 2;
	private static final double MAX_HEIGHT = SCORING_POSITION_5 + 4;
	private static final double JOG_INCHES = 0.5;
	
	private static final double GEAR_SIZE = 1.5; //inches
	private static final double INCHES_PER_REVOLUTION = Math.PI * 2 * GEAR_SIZE;
	private static final double PULSES_PER_REVOLUTION = 2048;
	
	public enum Position {
		pickUp(OBJECT_ON_GROUND),
		score1(SCORING_POSITION_1),
		score2(SCORING_POSITION_2),
		score3(SCORING_POSITION_3),
		score4(SCORING_POSITION_4),
		score5(SCORING_POSITION_5);
		
		private double target;
		
		Position(double target){
			this.target = target;
		}
	}
	
	public Elevator() {
		super(0.8/MAX_HEIGHT - MIN_HEIGHT, 0.0, 0.0);
		setInputRange(MIN_HEIGHT, MAX_HEIGHT);
		getPIDController().setContinuous(false);
		elevatorMotor.enableBrakeMode(true);
		enable();
		elevatorEncoder.setDistancePerPulse(INCHES_PER_REVOLUTION/PULSES_PER_REVOLUTION);
		// TODO Auto-generated constructor stub
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public void initDefaultCommand() {
		// No default command for the elevator.
	}
	public void moveTo(Position position) {
		setSetpoint(position.target);
	}
	public void jogUp() {
		setSetpoint(getSetpoint() + JOG_INCHES);
	}
	public void jogDown() {
		setSetpoint(getSetpoint() - JOG_INCHES);
	}
	public void stop() {
		setSetpoint(getPosition());
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
		// TODO Auto-generated method stub
		return getElevatorEncoderInches();
	}
	@Override
	protected void usePIDOutput(double output) {
		double elevatorMotorPower = output;
		if(getPIDController().onTarget() == false) {
			elevatorMotor.set(elevatorMotorPower);
		}
		else {
			elevatorMotor.set(0);
		}
		// TODO Auto-generated method stub
	}
}