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
	
	
	public void testMoveElevatorUp(double motorSpeed) {
		elevator_motor.set(motorSpeed);
	}
	
	public void testMoveElevatorDown(double motorSpeed) {
		elevator_motor.set(-motorSpeed);
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