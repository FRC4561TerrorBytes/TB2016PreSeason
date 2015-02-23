package org.usfirst.frc.team4561.robot.commands;

/**
 * Uses the AutoModeCardinalFieldRelativeDrive command in junction with the
 * RotateTo command to achieve movement.
 */
public class AutoOneCan extends Abstract4561AutomodeGroup {

    public  AutoOneCan() {
    	
    	//Rotate: extender faces step
    	addSequential(new RotateTo(180.0));
    	//Drive Forward until hit totes, back up a bit if didn't see tape
    	addSequential(new AutoCardinalFieldRelativeDrive(1, 28, 180, 8));
    	//Strafe to "hook" easternmost can.
    	addSequential(new AutoCardinalFieldRelativeDrive(2, 25, 180));
    	//Pull can back.
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 22, 180));
    	//Drive to autozone
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 48.5, 180));
    	//Rotate to fit in autozone
    	addSequential(new RotateTo(90));
    }

	@Override
	public double getStartAngle() {
		// Starts with the front of the robot facing the right wall.
		return 90.0;
	}
}
