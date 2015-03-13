/**
 * 
 */
package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

/**
 *
 */
public class AutoCardinalFieldRelativeDriveWithTape extends
		AutoCardinalFieldRelativeDrive implements ISensorStoppableDriveCommand {
	
	private boolean hasSeenTape = false;

	/**
	 * @param direction
	 * @param inches
	 * @param maintainedRot
	 */
	public AutoCardinalFieldRelativeDriveWithTape(int direction, double inches,
			double maintainedRot) {
		super(direction, inches, maintainedRot);
	}

	@Override
	protected void execute() {
		super.execute();
		hasSeenTape = Robot.driveTrain.hasSeenTape;
	}

	@Override
	protected boolean isFinished() {
		return super.isFinished() || hasSeenTape;
	}
	
	/**
	 * Call this after this command has finished.
	 * @return
	 */
	public boolean didSensorStop() {
		return hasSeenTape;
	}

}
