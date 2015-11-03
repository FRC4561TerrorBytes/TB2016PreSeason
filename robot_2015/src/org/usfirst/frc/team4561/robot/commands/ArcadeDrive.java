package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4561.robot.Robot;

/**
 *
 */
public class ArcadeDrive extends Command {
	
	public ArcadeDrive() {
		requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveArcade(Robot.oi.getDrive(), 
    					 			 Robot.oi.getRot());
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
