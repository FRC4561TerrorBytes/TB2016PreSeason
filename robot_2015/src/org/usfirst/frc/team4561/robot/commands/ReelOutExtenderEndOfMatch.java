package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

public class ReelOutExtenderEndOfMatch extends ReelInExtenderUnlimited {

	public static final double EXTENDER_REEL_OUT_SEC = 3.0;

	/**
	 * Uses ReelInExtenderUnnlimited and allows the extender 
	 * to stop reeling after a certain period of time.
	 */
	public ReelOutExtenderEndOfMatch() {
		super();
		setTimeout(EXTENDER_REEL_OUT_SEC);
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.extender.pitPrepOut();
	}

	public boolean isFinished() {
		return isTimedOut();
	}

}
