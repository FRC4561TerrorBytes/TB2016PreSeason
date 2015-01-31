package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The command does not finish on its own and is expected to be used via
 * whileHeld on a button.
 */
public class ReelInExtenderUnlimited extends Command {

	public ReelInExtenderUnlimited() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.extender);
		requires(Robot.driveTrain); // TODO remove
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.extender.reelItIn();
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
