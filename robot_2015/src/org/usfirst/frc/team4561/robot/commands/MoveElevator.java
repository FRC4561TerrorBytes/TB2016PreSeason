//package org.usfirst.frc.team4561.robot.commands;
//
//import org.usfirst.frc.team4561.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//
//public class MoveElevator extends Command {
//	//TODO Remove this entire command?
//	private double motorSpeed;
//
//    public MoveElevator(double motorSpeed) {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    	this.motorSpeed = motorSpeed;
//    	requires(Robot.elevator);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	Robot.elevator.testMoveElevator(motorSpeed);
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//    	// Only schedule this command as whileHeld
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	Robot.elevator.stop();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	end();
//    }
//}
