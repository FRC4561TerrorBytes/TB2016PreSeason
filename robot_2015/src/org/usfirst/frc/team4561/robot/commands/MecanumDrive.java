package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;


public class MecanumDrive extends Command {
	private double lastRotationDegrees = Double.MAX_VALUE;
	/**
	 * Gives the drive train the current joystick values.
	 */
	public MecanumDrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {


		if (Robot.oi.isRobotRelative()) {
			Robot.driveTrain.driveRobotRelative(Robot.oi.getDriveX(),
					Robot.oi.getDriveY());
		} else {
			double rotationDegrees = Robot.oi.getRotationDegrees();
			/*
			 * If no rotation stick deflection, we need be careful to get
			 * rotation locking working properly.
			 */
			if (rotationDegrees == Double.MAX_VALUE) {
				/*
				 * If the last time we had deflection, set the target angle to
				 * where we are and do not change it until next deflection.
				 */
				if (lastRotationDegrees != Double.MAX_VALUE) {
					rotationDegrees = Robot.driveTrain.getNormalizedGyroAngle();
					lastRotationDegrees = Double.MAX_VALUE;
					Robot.driveTrain.driveFieldRelative(Robot.oi.getDriveX(),
							Robot.oi.getDriveY(), rotationDegrees);
				} else {
					// Leave the rotation set point as is.
					Robot.driveTrain.driveFieldRelative(Robot.oi.getDriveX(),
							Robot.oi.getDriveY(), Robot.driveTrain.getSetpoint());
				}
			} else {
				// Use the rotation stick value as is.
				Robot.driveTrain.driveFieldRelative(Robot.oi.getDriveX(),
						Robot.oi.getDriveY(), rotationDegrees);
				lastRotationDegrees = rotationDegrees;
			}
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
