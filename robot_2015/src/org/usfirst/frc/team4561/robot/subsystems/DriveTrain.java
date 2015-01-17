package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private Talon leftFront = new Talon(RobotMap.FRONT_LEFT_MOTOR);
	private Talon leftRear = new Talon(RobotMap.REAR_LEFT_MOTOR);
	private Talon rightFront = new Talon(RobotMap.FRONT_RIGHT_MOTOR);
	private Talon rightRear = new Talon(RobotMap.REAR_RIGHT_MOTOR);
	private RobotDrive robotDrive = new RobotDrive(leftFront, leftRear,
			rightFront, rightRear);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new MecanumDrive());

	}

	public void driveRobotRelative(double x_v, double y_v, double rot) {
		robotDrive.mecanumDrive_Cartesian(x_v, y_v, rot, 0.0);
	}

	public void driveFieldRelative(double x_v, double y_v, double rot) {
		robotDrive.mecanumDrive_Cartesian(x_v, y_v, rot, 0.0 /*
															 * Replace with gyro
															 * reading
															 */);
	}

	public void stop() {
		robotDrive.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
	}
}