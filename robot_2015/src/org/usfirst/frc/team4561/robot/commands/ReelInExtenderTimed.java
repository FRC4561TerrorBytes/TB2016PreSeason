/**
 * 
 */
package org.usfirst.frc.team4561.robot.commands;

/**
 *
 */
public class ReelInExtenderTimed extends ReelInExtenderUnlimited {

	private static final double EXTENDER_REEL_IN_SEC = 3.0;

	/**
	 * 
	 */
	public ReelInExtenderTimed() {
		super();
		setTimeout(EXTENDER_REEL_IN_SEC);
	}

	public boolean isFinished() {
		return isTimedOut();
	}

}
