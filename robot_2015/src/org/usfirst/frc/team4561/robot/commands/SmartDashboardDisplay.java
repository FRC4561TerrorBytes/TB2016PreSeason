package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.subsystems.SDLogging;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SmartDashboardDisplay extends Command {

	
	public SmartDashboardDisplay() {
		requires(Robot.sdlogging);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SDLogging logger = Robot.sdlogging;
		logger.displayData(SDLogging.Key.Drive, Double.toString(Robot.oi.getDrive()));
		logger.displayData(SDLogging.Key.Rotation, Double.toString(Robot.oi.getRot()));
		logger.displayData(SDLogging.Key.Throttle, Double.toString(Robot.oi.getDriveThrottle()));
		logger.displayData(SDLogging.Key.WheelRPS, Double.toString(Robot.oi.getFlyWheelRPS()));
		logger.displayData(SDLogging.Key.WheelSpeed, Double.toString(Robot.oi.getFlyWheelSpeed()));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
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
