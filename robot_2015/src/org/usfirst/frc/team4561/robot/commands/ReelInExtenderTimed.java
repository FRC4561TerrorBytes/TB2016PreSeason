package org.usfirst.frc.team4561.robot.commands;

public class ReelInExtenderTimed extends ReelInExtenderUnlimited {

	private static final double EXTENDER_REEL_IN_SEC = 3.0;

	/**
	 * Uses ReelInExtenderUnnlimited and allows the extender 
	 * to stop reeling after a certain period of time.
	 */
	public ReelInExtenderTimed() {
		super();
		setTimeout(EXTENDER_REEL_IN_SEC);
	}

	public boolean isFinished() {
		return isTimedOut();
	}

}
