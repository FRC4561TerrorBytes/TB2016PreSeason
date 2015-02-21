//package org.usfirst.frc.team4561.robot.commands;
//
//import edu.wpi.first.wpilibj.command.Command;
//import org.usfirst.frc.team4561.robot.Robot;
//
///**
// *
// */
//public class MovePos extends Command {
//	
//	private boolean currentDirectionForward = true;
//	
//    public MovePos() {
//        requires(Robot.elevator);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	currentDirection = (Robot.oi.getControllerRightStickY() < 0.0);
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	if(currentDirection) {
//    		Robot.elevator.upOneScoringPos();
//    	} else {
//    		Robot.elevator.downOneScoringPos();
//    	}
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return true;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	end();
//    }
//}
