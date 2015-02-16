package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command tells the extender motor to move slowly for preparing the reel
 * position in pit before a match, and doing so indefinitely. This command does
 * not finish on its own and is expected to be used via a button and whileHeld.
 */
public class ExtenderPitPrep extends Command {
	private boolean inward = true;

	public ExtenderPitPrep(boolean inward) {
		requires(Robot.extender);
		this.inward = inward;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (inward)
			Robot.extender.pitPrepIn();
		else
			Robot.extender.pitPrepOut();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// This command is unlimited and is intended to be used with whileHeld
		// on a button.
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.extender.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
