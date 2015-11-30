package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4561.robot.Robot;

/**
 *
 */
public class FeedbackLEDs extends Command {

	boolean readyToFire;
	
    public FeedbackLEDs() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.shooter.getPIDController().onTarget() && !true) { //TODO: Make condition based on loaded sensor
    		Robot.shooter.flyWheelLED.set(true);
    	} else {
    		Robot.shooter.flyWheelLED.set(false);
    	}
    	if(true && !Robot.shooter.getPIDController().onTarget()) { //TODO: Make condition based on loaded sensor
    		Robot.loader.loadedLED.set(true);
    	} else {
    		Robot.loader.loadedLED.set(false);
    	}
    	if(Robot.shooter.getPIDController().onTarget() && true) { // TODO: Make condition based on loaded sensor
    		Robot.shooter.readyLED.set(true);
    	} else {
    		Robot.shooter.readyLED.set(false);
    	}
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
