package org.usfirst.frc.team4561.robot;

import org.usfirst.frc.team4561.robot.commands.Abstract4561AutomodeGroup;
import org.usfirst.frc.team4561.robot.commands.AutoMode;
import org.usfirst.frc.team4561.robot.commands.AutomodeDoNothing;
import org.usfirst.frc.team4561.robot.commands.AutomodePushItemToZoneWithOpenClaw;
import org.usfirst.frc.team4561.robot.subsystems.Claw;
import org.usfirst.frc.team4561.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4561.robot.subsystems.Elevator;
import org.usfirst.frc.team4561.robot.subsystems.Extender;
import org.usfirst.frc.team4561.robot.subsystems.SDLogging;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory..
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Elevator elevator = new Elevator();
	public static final Extender extender = new Extender();
	public static final Claw claw = new Claw();
	public static final SDLogging sdlogging = new SDLogging();
	public static OI oi;

	Abstract4561AutomodeGroup autonomousCommand;
	SendableChooser autoChooser;
	
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
		// instantiate the command used for the autonomous period
		autonomousCommand = null;
		
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(extender);
		SmartDashboard.putData(elevator);
		SmartDashboard.putData(claw);
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Do nothing", new AutomodeDoNothing());
		autoChooser.addObject("Push item with claw", new AutomodePushItemToZoneWithOpenClaw());
		autoChooser.addObject("Get RCs", new AutoMode());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = (Abstract4561AutomodeGroup) autoChooser.getSelected();
		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			driveTrain.setStartAngle(autonomousCommand.getStartAngle());
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

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
