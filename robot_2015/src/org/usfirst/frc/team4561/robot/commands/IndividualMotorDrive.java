package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 */
public class IndividualMotorDrive extends Command {
	
	private int motorID;

    public IndividualMotorDrive(int motorID) {
    	this.motorID = motorID;
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.fullEncoderReset();
    }

    // Called repeatedly when this Command is scheduled to run
    int i = 0;
    protected void execute() {
    	Robot.driveTrain.testSingleMotor(motorID);
    	i++;
    	if(i%10 == 0) {
    		    System.out.println("Inches: " + Robot.driveTrain.getSingleEncoderInches(motorID - 1));
    		    System.out.println("Ticks: " + Robot.driveTrain.getSingleEncoderTicks(motorID - 1));
    	}

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
