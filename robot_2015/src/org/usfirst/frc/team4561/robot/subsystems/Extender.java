package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

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