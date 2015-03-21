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
    	AutoCardinalFieldRelativeDriveWithTape forward = new AutoCardinalFieldRelativeDriveWithTape(1, 28, 180);
    	addSequential(forward);
    	//Back up a bit
    	addSequential(new AutoConditionalBackoff(3, 8, 180, forward));
    	//Strafe to "hook" second-to-easternmost can.
    	addSequential(new AutoCardinalFieldRelativeDrive(4, 35, 180));
    	//Pull can back.
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 22, 180));
    }
}
