package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 * This is a command that slightly moves the robot in a certain direction if the robot is in robot relative mode.
 * This command uses the hat on the drive stick and all directions trigger the code.  It uses a custom
 * trigger as well.  
 */

public class JoggingPOV extends Command {
	
	private static final int FORWARD = 0;
	private static final int FORWARD_LEFT = 1;
	private static final int LEFT = 2;
	private static final int LEFT_BACKWARD = 3;
	private static final int BACKWARD = 4;
	private static final int BACKWARD_RIGHT = 5;
	private static final int RIGHT = 6;
	private static final int RIGHT_FORWARD = 7;
	private int currentDirection = FORWARD;
	
    public JoggingPOV() {
    	requires(Robot.driveTrain);

    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentDirection = Robot.oi.getDrivePOV();
    	System.out.println("POV =" + currentDirection);
    	setTimeout(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (currentDirection == FORWARD){
    		Robot.driveTrain.driveRobotRelative(0.0,0.3);
    	}
    	else if(currentDirection == FORWARD_LEFT){
    		Robot.driveTrain.driveRobotRelative(0.3,0.3);
    	}
    	else if(currentDirection == LEFT){
    		Robot.driveTrain.driveRobotRelative(0.3,0.0);
    	}
    	else if(currentDirection == LEFT_BACKWARD){
    		Robot.driveTrain.driveRobotRelative(0.3,-0.3);
    	}
    	else if(currentDirection ==BACKWARD){
    		Robot.driveTrain.driveRobotRelative(0.0,-0.3);
    	}
    	else if(currentDirection == BACKWARD_RIGHT){
    		Robot.driveTrain.driveRobotRelative(-0.3,-0.3);
    	}
    	else if(currentDirection == RIGHT){
    		Robot.driveTrain.driveRobotRelative(-0.3,0.0);
    	}
    	else if(currentDirection == RIGHT_FORWARD){
    		Robot.driveTrain.driveRobotRelative(-0.3,0.3);
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
