package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * The long telescoping pole that will pull recycling cans 
 * off the step and over totes, preferably in automode. 
 * Will be fully extended at the start of automode, then reeled in
 * by a button at the will of the drive team.
 */
public class Extender extends Subsystem {
	private static final double REEL_IN_POWER = -0.5;

	private CANTalon motor = new CANTalon(RobotMap.EXTENDER_MOTOR_CAN);

	@Override
	protected void initDefaultCommand() {
	}

	public void reelItIn() {
		motor.set(REEL_IN_POWER);
	}

	public void stop() {
		motor.set(0.0);
	}
}