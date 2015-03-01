package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4561.robot.Robot;

/**
 *
 */
public class RotatePOVTimed extends Command {
	
	//private static final int FORWARD = 0;
	private static final int RIGHT_FORWARD = 45;
	private static final int RIGHT = 90;
	private static final int BACKWARD_RIGHT = 135;
	//private static final int BACKWARD = 180;
	private static final int LEFT_BACKWARD = 225;
	private static final int LEFT = 270;
	private static final int FORWARD_LEFT = 315;

	int currentDirection;
	
    public RotatePOVTimed(double timeout) {
        requires(Robot.driveTrain);
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentDirection = Robot.oi.getRotatePOV();
    	if(currentDirection == RIGHT || currentDirection == RIGHT_FORWARD || currentDirection == BACKWARD_RIGHT) {
        	Robot.driveTrain.rotateRobotRelativeJog(0.5);
    	}
    	else if(currentDirection == LEFT || currentDirection == FORWARD_LEFT || currentDirection == LEFT_BACKWARD) {
        	Robot.driveTrain.rotateRobotRelativeJog(-0.5);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
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
