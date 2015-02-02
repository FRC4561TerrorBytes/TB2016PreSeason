package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.IndividualMotorDrive;
import org.usfirst.frc.team4561.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Elevator extends PIDSubsystem {
	private CANTalon elevator_motor = new CANTalon(RobotMap.ELEVATOR_MOTOR_CAN);
	private Encoder elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_A_CHANNEL, RobotMap.ELEVATOR_ENCODER_B_CHANNEL);
	//Elevator Set Height Points (inches)
	private static final double FLOOR = 0;
	private static final double HEIGHT_OF_TOTE = 12;
	private static final double HEIGHT_OF_PLATFORM = 2;
	private static final double OBJECT_ON_GROUND = 8;
	private static final double RECYCLING_CAN_ON_PLATFORM = 11;
	private static final double TOTE_ON_PLATFORM = 11;
	private static final double SCORING_POSITION_1 = HEIGHT_OF_PLATFORM+HEIGHT_OF_TOTE+OBJECT_ON_GROUND; //placing tote on 1 one existing tote
	private static final double SCORING_POSITION_2 = HEIGHT_OF_PLATFORM+(HEIGHT_OF_TOTE*2)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_3 = HEIGHT_OF_PLATFORM+(HEIGHT_OF_TOTE*3)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_4 = HEIGHT_OF_PLATFORM+(HEIGHT_OF_TOTE*4)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_5 = HEIGHT_OF_PLATFORM+(HEIGHT_OF_TOTE*5)+OBJECT_ON_GROUND;
	private static final double SCORING_POSITION_6 = HEIGHT_OF_PLATFORM+(HEIGHT_OF_TOTE*6)+OBJECT_ON_GROUND;

	public Elevator() {
		super(0.8, 0.0, 0.0);
		// TODO Auto-generated constructor stub
		
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	
	public void testMoveElevator(double motorSpeed) {
			elevator_motor.enableBrakeMode(true);
			elevator_motor.set(motorSpeed);
		
	}
	
	public double getElevatorEncoderCountPID() {
		return elevatorEncoder.pidGet();
	}
	public void setSetpoint(){
		
	}
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return getElevatorEncoderCountPID();
	}
	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}