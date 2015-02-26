package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc.team4561.robot.Robot;

/**
 * 
 */
public class AutoCardinalRobotRelativeDrive extends PIDCommand {
	
	int direction;
	double inches;
	/**
	 * Drive in a certain direction a certain length
	 * To be used only in the AutoMode command
	 * @param direction
	 * 1 = north
	 * 2 = east
	 * 3 = south
	 * 4 = west
	 * @param inches
	 */
    public AutoCardinalRobotRelativeDrive(int direction, double inches) {
    	super(0.8, 0, 0);
        requires(Robot.driveTrain);
        getPIDController().setAbsoluteTolerance(0.1);
        this.direction = direction;
        this.inches = inches;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.fullEncoderReset();
    	setSetpoint(inches);
    }
    
    public void bump() {
    	setSetpoint(getSetpoint() + inches);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(getPIDController().onTarget() == true) {
    		return true;
    	}
    	else{
    		return false;
    	}

    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected double returnPIDInput() {
		if(direction == 2 || direction == 4) {
			return Robot.driveTrain.getSingleEncoderInches(0);
		}
		return Robot.driveTrain.getAbsAverageEncoderInches();
	}

	@Override
	protected void usePIDOutput(double output) {
		double motorPower = output;
		//North
		if(direction == 1) {
			Robot.driveTrain.driveRobotRelative(0, -motorPower);
		}
		//East
		if(direction == 2) {
			Robot.driveTrain.driveRobotRelative(-motorPower, 0);
		}
		//South
		if(direction == 3) {
			Robot.driveTrain.driveRobotRelative(0, motorPower);
		}
		//West
		if(direction == 4) {
			Robot.driveTrain.driveRobotRelative(motorPower, 0);
		}
	}
}
