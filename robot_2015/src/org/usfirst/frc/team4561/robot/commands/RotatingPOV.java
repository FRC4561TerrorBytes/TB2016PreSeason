package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class RotatingPOV extends Command {

	private static final int ROTATE_RIGHT_LOWER_BOUND = 45;
	private static final int ROTATE_RIGHT_UPPER_BOUND = 135;
	private static final int ROTATE_LEFT_LOWER_BOUND = 225;
	private static final int ROTATE_LEFT_UPPER_BOUND = 315;

	public RotatingPOV() {
		requires(Robot.driveTrain);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		int currentMovement = Robot.oi.getRotatePOV();
		if ((currentMovement >= ROTATE_LEFT_LOWER_BOUND)
				&& (currentMovement <= ROTATE_LEFT_UPPER_BOUND)) {
			Robot.driveTrain.driveRotationRelative(-5.0);
		} else if ((currentMovement >= ROTATE_RIGHT_LOWER_BOUND)
				&& (currentMovement <= ROTATE_RIGHT_UPPER_BOUND)) {
			Robot.driveTrain.driveRotationRelative(5.0);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
