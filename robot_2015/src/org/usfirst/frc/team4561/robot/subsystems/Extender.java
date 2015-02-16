package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * The long telescoping pole that will pull recycling cans 
 * off the step and over totes, preferably in automode. 
 * Will be fully extended at the start of automode, then reeled in
 * by a button at the will of the drive team.
 */
public class Extender extends Subsystem {
	private static final double REEL_IN_POWER = -0.5;
	private static final double PIT_PREP_POWER = 0.1;

	private Talon motor = new Talon(RobotMap.EXTENDER_MOTOR);

	@Override
	protected void initDefaultCommand() {
	}

	public void reelItIn() {
		motor.set(REEL_IN_POWER);
	}

	public void stop() {
		motor.set(0.0);
	}
	
	public void pitPrepIn() {
		motor.set(-PIT_PREP_POWER);
	}
	
	public void pitPrepOut() {
		motor.set(PIT_PREP_POWER);
	}
}