package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.subsystems.Elevator;

/**
 *
 */
public class MovePos extends Command {
	
	private boolean currentDirectionForward = true;
	
    public MovePos() {
        requires((Subsystem) Robot.commonElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentDirectionForward = (Robot.oi.getControllerRightStickY() < 0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(currentDirectionForward) {
    		((Elevator)Robot.commonElevator).upOneScoringPos();
    	} else {
    		((Elevator)Robot.commonElevator).downOneScoringPos();
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
