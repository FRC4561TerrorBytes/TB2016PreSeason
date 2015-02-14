package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */

public class JoggingPOV extends Command {
	
	private static final int FORWARD = 0;
	//private static final int RIGHT_FORWARD = 45;
	private static final int RIGHT = 90;
	//private static final int BACKWARD_RIGHT = 135;
	private static final int BACKWARD = 180;
	//private static final int LEFT_BACKWARD = 225;
	private static final int LEFT = 270;
	//private static final int FORWARD_LEFT = 315;
	
	private int currentDirection = FORWARD;
	
	private AutoCardinalRobotRelativeDrive forwardDrive = new AutoCardinalRobotRelativeDrive(
			1, 0.5);
	private AutoCardinalRobotRelativeDrive rightDrive = new AutoCardinalRobotRelativeDrive(
			2, 0.5);
	private AutoCardinalRobotRelativeDrive backwardDrive = new AutoCardinalRobotRelativeDrive(
			3, -0.5);
	private AutoCardinalRobotRelativeDrive leftDrive = new AutoCardinalRobotRelativeDrive(
			4, -0.5);
	
    public JoggingPOV() {
    	requires(Robot.driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentDirection = Robot.oi.getDrivePOV();
		if (currentDirection == FORWARD) {
			if (forwardDrive.isRunning())
				forwardDrive.bump();
			else
				forwardDrive.start();
		} else if (currentDirection == RIGHT) {
			if (rightDrive.isRunning())
				rightDrive.bump();
			else
				rightDrive.start();
		} else if (currentDirection == BACKWARD) {
			if (backwardDrive.isRunning())
				backwardDrive.bump();
			else
				backwardDrive.start();
		} else if (currentDirection == LEFT) {
			if (leftDrive.isRunning())
				leftDrive.bump();
			else
				leftDrive.start();
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
