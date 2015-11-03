
package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.RobotDrive;


/**
 *
 */
public class DriveTrain extends Subsystem {
    
	Victor frontRight = new Victor(RobotMap.FRONT_RIGHT_VICTOR);
	Victor frontLeft = new Victor(RobotMap.FRONT_LEFT_VICTOR);
	Victor rearRight = new Victor(RobotMap.REAR_RIGHT_VICTOR);
	Victor rearLeft = new Victor(RobotMap.REAR_LEFT_VICTOR);
	
	RobotDrive robotDrive = new RobotDrive(frontLeft, rearLeft, 
											frontRight, rearRight);

    public void initDefaultCommand() {
    	 setDefaultCommand(new ArcadeDrive());
    }

    public void driveArcade(double x, double rot) {
    	robotDrive.arcadeDrive(x, rot);
    }
    
    public void stop() {
    	robotDrive.arcadeDrive(0, 0);
    }
}















