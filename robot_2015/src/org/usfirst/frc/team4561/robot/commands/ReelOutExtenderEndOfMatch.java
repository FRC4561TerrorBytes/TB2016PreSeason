package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

/**
 * Start this at the beginning of teleop and toward the end it will reel the
 * extender out a bit so that the drive team will be able to get back into the
 * transport configuration.
 */
public class ReelOutExtenderEndOfMatch extends ReelInExtenderUnlimited {

	// There are 135 seconds in teleop.
	private static final double TELEOP_TIME_TO_REEL_OUT = 130.0;
	private static final double EXTENDER_REEL_OUT_SEC = 3.0;

	/**
	 * Uses ReelInExtenderUnnlimited and allows the extender to stop reeling
	 * after a certain period of time.
	 */
	public ReelOutExtenderEndOfMatch() {
		super();
		setTimeout(TELEOP_TIME_TO_REEL_OUT + EXTENDER_REEL_OUT_SEC);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (timeSinceInitialized() > TELEOP_TIME_TO_REEL_OUT)
			Robot.extender.pitPrepOut();
	}

	public boolean isFinished() {
		return isTimedOut();
	}

}
