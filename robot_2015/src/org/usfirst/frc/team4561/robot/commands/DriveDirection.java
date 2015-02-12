package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDirection extends Command {
	//TODO Obsolete?
	public double x_v;
	public double y_v;
	public DriveDirection(double x_v, double y_v) {
		this.x_v = x_v;
		this.y_v = y_v;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.isRobotRelative()) {
			Robot.driveTrain.driveRobotRelative(Robot.oi.getDriveX(),
					Robot.oi.getDriveY());
		} else {
			Robot.driveTrain.driveFieldRelative(x_v, y_v, Robot.driveTrain.getNormalizedGyroAngle());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
