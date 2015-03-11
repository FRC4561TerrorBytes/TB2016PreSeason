package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc.team4561.robot.Robot;

/**
 * 
 */
public class AutoCardinalFieldRelativeDrive extends PIDCommand {
	
// We need this, because otherwise, the motors will run at full power unless the setpoint is below 1 inch away.
	private static final int INCHES_FOR_FULL_POWER = 12;
	
	private static final double MIN_ABSOLUTE_POWER = 0.1;
	
	int direction;
	double maintainedRot;
	double inches;
	boolean hasSeenTape = false;
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
    public AutoCardinalFieldRelativeDrive(int direction, double inches, double maintainedRot) {
    	super(0.3/INCHES_FOR_FULL_POWER, 0, 0);
        requires(Robot.driveTrain);
        getPIDController().setOutputRange(-0.8, 0.8);
        Robot.driveTrain.fullEncoderReset();
        getPIDController().setAbsoluteTolerance(1);
        this.direction = direction;
        this.inches = inches;
        this.maintainedRot = maintainedRot;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setSetpoint(inches);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	hasSeenTape = Robot.driveTrain.hasSeenTape;
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
		//North
		if(direction == 1) {
			Robot.driveTrain.driveFieldRelative(0, -motorPower, maintainedRot);
		}
		//East
		if(direction == 2) {
			Robot.driveTrain.driveFieldRelative(motorPower, 0, maintainedRot);
		}
		//South
		if(direction == 3) {
			Robot.driveTrain.driveFieldRelative(0, motorPower, maintainedRot);
		}
		//West
		if(direction == 4) {
			Robot.driveTrain.driveFieldRelative(-motorPower, 0, maintainedRot);
		}
	}
}
