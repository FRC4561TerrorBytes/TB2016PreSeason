package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4561.robot.Robot;

/**
 *
 */
public class RotateTo extends Command {
	//TODO Is this command be possible to do while AutoModeCardinalFieldRelativeDrive is happening?
	double angle;
	
    public RotateTo(double angle) {
        requires(Robot.driveTrain);
        Robot.driveTrain.fullEncoderReset();
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setAbsoluteTolerance(10);
    	Robot.driveTrain.rotateTo(angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.driveTrain.onTarget() ==  true) {
    		        return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setAbsoluteTolerance(2.0);
    	Robot.driveTrain.fullEncoderReset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
