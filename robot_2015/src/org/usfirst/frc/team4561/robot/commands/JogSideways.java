package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.triggers.JogLeftTrigger;
import org.usfirst.frc.team4561.robot.triggers.JogRightTrigger;
import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JogSideways extends Command {
private boolean left;
	
    public JogSideways(boolean left) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.driveTrain);
    	this.left = left;
    	setTimeout(0.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveRobotRelative(left? -0.3:0.3 , 0.0, 0.0);
    			
    }
    	

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
