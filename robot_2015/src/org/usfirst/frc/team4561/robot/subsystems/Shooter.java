package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.FlyWheelSpeed;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class Shooter extends PIDSubsystem {
	
	SpeedController shooterMotor;
	
	public DigitalOutput flyWheelLED = new DigitalOutput(RobotMap.FLY_WHEEL_LED);
	public DigitalOutput readyLED = new DigitalOutput(RobotMap.READY_LED);
	
	public static final boolean REVERSE_ENCODER_DIRECTION = true;
	public static final EncodingType ENCODING_TYPE = EncodingType.k1X;
	public Encoder shooterEncoder = new Encoder(RobotMap.SHOOTER_ENCODER_A_CHANNEL,
			RobotMap.SHOOTER_ENCODER_B_CHANNEL, REVERSE_ENCODER_DIRECTION, ENCODING_TYPE);
	private static final double PULSES_PER_REVOLUTION = 2048;
	private static final double WHEEL_RADIUS = 3;
	private static final double WHEEL_CIRCUMFERENCE = 2 * Math.PI * WHEEL_RADIUS;
	private static final double INCHES_PER_PULSE = WHEEL_CIRCUMFERENCE/PULSES_PER_REVOLUTION;
	
	 
    // Initialize your subsystem here
    public Shooter() {
    	super(0,0,0);
    	getPIDController().setPID(0,0,0,0);
    	constructMotorControllers();
    	shooterEncoder.setDistancePerPulse(INCHES_PER_PULSE);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new FlyWheelSpeed());
    }
    
    public void constructMotorControllers() {
		if(RobotMap.SHOOTER_USE_VICTORS) {
			shooterMotor = new Victor(RobotMap.SHOOTER_MOTOR);
		} else {
			shooterMotor = new Talon(RobotMap.SHOOTER_MOTOR);
		}
	}
    
    public void setFlyWheelSpeed(double speed) {
    	shooterMotor.set(speed);
    }
    
    public void stop() {
    	shooterMotor.set(0);
    }
    
    double rps;
    public double getFlyWheelRPS() {
    	
    	rps = shooterEncoder.getRate() / WHEEL_CIRCUMFERENCE;
    	return rps;
    	
    }
    double speed;
    public double getFlyWheelSpeed() {
    	speed = shooterEncoder.getRate();
    	System.out.println(speed);
    	return speed;
    }
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return shooterEncoder.getRate();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
