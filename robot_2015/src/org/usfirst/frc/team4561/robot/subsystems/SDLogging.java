package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.commands.SmartDashboardDisplay;

/**
 *
 */
public class SDLogging extends Subsystem {
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	 public void initDefaultCommand() {
		 setDefaultCommand(new SmartDashboardDisplay());
	 }
}

