package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SmartDashboardDisplay extends Command {

//	String IS_ROBOT_RELATIVE = "NaN";
//	String X_MOTOR_VALUE = "NaN";
//	String Y_MOTOR_VALUE = "NaN";
//	String ROTATION_MOTOR_VALUE ="NaN";
//	String GYRO_VALUE = "NaN";
//	String ELEVATOR_POSTION ="NaN";
//	String CURRENT_SET_POINT = "NaN";
//	String IS_CLAW_OPEN = "NaN";
//	String IS_EXTENDER_RETRACKED = "NaN";
	
    public SmartDashboardDisplay() {
//    	requires(Robot.sdlogging);    	

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	IS_ROBOT_RELATIVE = 
//    	ELEVATOR_POSTION = "The Elevators is " + Robot.elevator.getElevatorEncoderInches() + "Inches High";
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
    }
}
