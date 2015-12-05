	
package org.usfirst.frc.team4561.robot;

import org.usfirst.frc.team4561.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4561.robot.subsystems.Loader;
import org.usfirst.frc.team4561.robot.subsystems.SDLogging;
import org.usfirst.frc.team4561.robot.subsystems.Shooter;
import org.usfirst.frc.team4561.robot.commands.ArcadeDrive;
import org.usfirst.frc.team4561.robot.commands.EnterTouringMode;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4561.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static OI oi;
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();
	public static final Loader loader = new Loader();
	public static final SDLogging sdlogging = new SDLogging();
	//Command autonomousCommand; TODO: Fix auto
	
	private static Robot robotSingleton;
	
	public static Robot getInstance() {
		return robotSingleton;
	}
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		
		robotSingleton = this;
		oi = new OI();
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(shooter);
		SmartDashboard.putData(loader);
		System.out.println("Robot Booted.");
	}
	
	public void autonomousInit() {
		// instantiate the command used for the autonomous period
		//autonomousCommand = new ArcadeDrive();
		// schedule the autonomous command (example)
		//autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		//Scheduler.getInstance().run();
	}

	public void teleopInit() {
		//autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
