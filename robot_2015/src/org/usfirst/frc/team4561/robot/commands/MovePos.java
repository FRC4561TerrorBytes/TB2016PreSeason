package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4561.robot.Robot;

/**
 *
 */
public class MovePos extends Command {

	private static final int FORWARD = 0;
	private static final int FORWARD_RIGHT = 45;
	//private static final int RIGHT = 90;
	private static final int BACKWARD_RIGHT = 135;
	private static final int BACKWARD = 180;
	private static final int BACKWARD_LEFT = 225;
	//private static final int LEFT = 270;
	private static final int FORWARD_LEFT = 315;
	
	private int currentDirection = FORWARD;
	
    public MovePos() {
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentDirection = Robot.oi.getDrivePOV();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(currentDirection == FORWARD || currentDirection == FORWARD_LEFT || currentDirection == FORWARD_RIGHT) {
    		Robot.elevator.upOneScoringPos();
    	}
    	if(currentDirection == BACKWARD || currentDirection == BACKWARD_LEFT || currentDirection == BACKWARD_RIGHT) {
    		Robot.elevator.downOneScoringPos();
    	}
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
