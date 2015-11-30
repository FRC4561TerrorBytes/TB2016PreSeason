
package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;


/**
 *
 */
public class DriveTrain extends Subsystem {
	
	SpeedController frontRight;
	SpeedController frontLeft;
	SpeedController rearRight;
	SpeedController rearLeft;

	RobotDrive robotDrive;
	
	public DriveTrain() {
		constructMotorControllers();
	}
	
	public void initDefaultCommand() {
		 setDefaultCommand(new ArcadeDrive());
	}
	
	public void constructMotorControllers() {
		if(RobotMap.DRIVETRAIN_USE_VICTORS) {
			frontRight = new Victor(RobotMap.FRONT_RIGHT_CONTROLLER);
			frontLeft = new Victor(RobotMap.FRONT_LEFT_CONTROLLER);
			rearRight = new Victor(RobotMap.REAR_RIGHT_CONTROLLER);
			rearLeft = new Victor(RobotMap.REAR_LEFT_CONTROLLER);
			
			robotDrive = new RobotDrive(frontLeft, rearLeft, 
													frontRight, rearRight);
		} else {
			frontRight = new Talon(RobotMap.FRONT_RIGHT_CONTROLLER);
			frontLeft = new Talon(RobotMap.FRONT_LEFT_CONTROLLER);
			rearRight = new Talon(RobotMap.REAR_RIGHT_CONTROLLER);
			rearLeft = new Talon(RobotMap.REAR_LEFT_CONTROLLER);
			
			robotDrive = new RobotDrive(frontLeft, rearLeft, 
													frontRight, rearRight);
		}
	}

	public void driveArcade(double x, double rot) {
		robotDrive.arcadeDrive(x, rot);
	}
	
	public void stop() {
		robotDrive.arcadeDrive(0, 0);
	}
}















