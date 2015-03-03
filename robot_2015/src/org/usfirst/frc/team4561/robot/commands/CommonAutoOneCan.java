package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This is NOT an automode. It's a group of commands to be referenced in automodes.
 */
public class CommonAutoOneCan extends CommandGroup {
    
    public  CommonAutoOneCan() {
    	//Rotate: extender faces step
    	addSequential(new RotateTo(180.0));
    	//Drive Forward until hit totes
    	addSequential(new AutoCardinalFieldRelativeDrive(1, 28, 180));
    	//Back up a bit
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 8, 180));
    	//Strafe to "hook" easternmost can.
    	addSequential(new AutoCardinalFieldRelativeDrive(2, 25, 180));
    	//Pull can back.
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 22, 180));
    }
}
