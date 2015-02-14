package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.subsystems.SDLogging;

import edu.wpi.first.wpilibj.command.Command;

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
		logger.displayData(SDLogging.Key.FieldRealtive,
				Boolean.toString(Robot.driveTrain.isFieldRelative()));
		logger.displayData(SDLogging.Key.DriveX,
				Double.toString(Robot.driveTrain.getCurrentX()));
		logger.displayData(SDLogging.Key.DriveY,
				Double.toString(Robot.driveTrain.getCurrentY()));
		logger.displayData(SDLogging.Key.RotateOutput,
				Double.toString(Robot.driveTrain.getLastRotation()));
		logger.displayData(SDLogging.Key.GyroValue,
				Double.toString(Robot.driveTrain.getLastGyroAngle()));
		logger.displayData(SDLogging.Key.ElevatorPosition,
				Double.toString(Robot.elevator.getPosition()));
		logger.displayData(SDLogging.Key.ElevatorDirection, (Robot.elevator
				.getSetpoint() - Robot.elevator.getPosition()) >= 0 ? "up"
				: "down");
		logger.displayData(SDLogging.Key.ClawState, "???");
		logger.displayData(SDLogging.Key.ExtenderPosition, "???");
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
