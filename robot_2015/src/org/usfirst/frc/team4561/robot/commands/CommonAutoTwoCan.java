package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CommonAutoTwoCan extends CommandGroup {
    
    public  CommonAutoTwoCan() {
    	
    	//Strafe to gap between first and second bins
    	addSequential(new AutoCardinalFieldRelativeDrive(2, 30, 180));
    	//Drive Forward until hit totes
    	AutoCardinalFieldRelativeDriveWithTape forward = new AutoCardinalFieldRelativeDriveWithTape(1, 22, 180);
    	addSequential(forward);
    	//Back up a bit
    	addSequential(new AutoConditionalBackoff(3, 8, 180, forward));
    	//Strafe to second can.
    	addSequential(new AutoCardinalFieldRelativeDrive(2, 30, 180));
    	//Pull second can back
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 22, 180));
    	
    	
    }
}
