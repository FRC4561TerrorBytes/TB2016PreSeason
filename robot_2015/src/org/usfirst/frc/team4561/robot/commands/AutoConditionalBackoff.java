package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;

import org.usfirst.frc.team4561.robot.Robot;

/**
 *
 */
public class AutoConditionalBackoff extends PIDCommand {

	private static final double INCHES_FOR_FULL_POWER = 12;
	private static final double MIN_ABSOLUTE_POWER = 0.1;
	private double maintainedRot;
	private double sensorStoppedInches;
	private double notSensorStoppedInches;
	private ISensorStoppableDriveCommand sensorStoppableCommand;
	
    public AutoConditionalBackoff(double sensorStoppedInches, double notSensorStoppedInches, double maintainedRot, ISensorStoppableDriveCommand sensorStoppableCommand) {
    	super(0.3/INCHES_FOR_FULL_POWER, 0, 0);
    	requires(Robot.driveTrain);
    	getPIDController().setOutputRange(-0.8, 0.8);
        Robot.driveTrain.fullEncoderReset();
        getPIDController().setAbsoluteTolerance(1);
        this.sensorStoppedInches = sensorStoppedInches;
        this.notSensorStoppedInches = notSensorStoppedInches;
        this.maintainedRot = maintainedRot;
        this.sensorStoppableCommand = sensorStoppableCommand;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(this.sensorStoppableCommand.didSensorStop()) {
    		setSetpoint(sensorStoppedInches);
    	}
    	else {
    		setSetpoint(notSensorStoppedInches);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(getPIDController().onTarget()) {
        	return true;
        }
        else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.fullEncoderReset();
    	Robot.driveTrain.resetSeenTape();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {
		return Robot.driveTrain.getAbsAverageEncoderInches();
	}

	@Override
	protected void usePIDOutput(double output) {
		double motorPower = output;
		if (Math.abs(output) < MIN_ABSOLUTE_POWER) {
			if (output > 0)
				motorPower = MIN_ABSOLUTE_POWER;
			else
				motorPower = -MIN_ABSOLUTE_POWER;
		}
		// Assumed direction of 3 (aka south)
		Robot.driveTrain.driveFieldRelative(0, motorPower, maintainedRot);
		
	}
}
