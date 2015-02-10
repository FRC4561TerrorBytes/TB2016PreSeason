//package org.usfirst.frc.team4561.robot.commands;
//
//import org.usfirst.frc.team4561.robot.Robot;
//import edu.wpi.first.wpilibj.command.PIDCommand;
//
///**
// *
// */
//public class AutoModeDrive extends PIDCommand {
//
//	private static final double WHEEL_RADIUS = 4.0; //inches 
//	private static final double INCHES_PER_REVOLUTION = 2 * Math.PI * WHEEL_RADIUS;
//	private static final double PULSES_PER_REVOLUTION = 2048;
//	double inches;
//	/**
//	 * Moves the robot in a cardinal direction for a certain amount of time.
//	 * @param direction
//	 * 1 = north
//	 * 2 = east
//	 * 3 = south
//	 * 4 = west
//	 * @param inches
//	 */
//    public AutoModeDrive(double direction, double inches) {
//    	super(0.3, 0, 0);
//    	this.inches = inches;
//    	requires(Robot.driveTrain);
//    	getPIDController().setContinuous(false);
//    	Robot.driveTrain.frontLeftEncoder.setDistancePerPulse(INCHES_PER_REVOLUTION/PULSES_PER_REVOLUTION);
//    	setSetpoint(0);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	setSetpointRelative(inches);
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
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
//    }
//
//	@Override
//	protected double returnPIDInput() {
//		// TODO Auto-generated method stub
//		return Robot.driveTrain.getAverageEncoderInches();
//	}
//
//	@Override
//	protected void usePIDOutput(double output) {
//		// TODO Auto-generated method stub
//		
//	}
//}
