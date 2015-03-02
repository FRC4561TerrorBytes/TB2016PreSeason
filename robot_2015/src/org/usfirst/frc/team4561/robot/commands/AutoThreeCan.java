package org.usfirst.frc.team4561.robot.commands;

/** 
 * Command to be run during autonomous mode
 * 
 * START: Claw facing eastern guardrail, Extender out 80"(7'8"), center of robot positioned at the 
 * intersection of the horizontal center of the furthest scoring platform of the alliance wall, and the
 * line formed by the second group of two vertical totes in the landfill zone from the eastern guardrail.
 * 
 * END: Claw facing eastern guardrail, Extender out 80"(7'8"), robot positioned in midwest portion
 * of the autozone.
 */
public class AutoThreeCan extends Abstract4561AutomodeGroup {

    public  AutoThreeCan() {
    	//Rotate: extender faces step
    	addSequential(new RotateTo(180.0));
    	//Drive Forward until hit totes
    	addSequential(new AutoCardinalFieldRelativeDrive(1, 28, 180));
    	//Back up a bit
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 8, 180));
    	//Strafe to "hook" easternmost can.
    	addSequential(new AutoCardinalFieldRelativeDrive(2, 25, 180));
    	//Pull first can back.
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 22, 180));
    	//Strafe to gap between first and second bins
    	addSequential(new AutoCardinalFieldRelativeDrive(4, 25, 180));
    	//Drive Forward until hit totes
    	addSequential(new AutoCardinalFieldRelativeDrive(1, 22, 180));
    	//Back up a bit
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 8, 180));
    	//Strafe to second can.
    	addSequential(new AutoCardinalFieldRelativeDrive(4, 25, 180));
    	//Pull second can back
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 22, 180));
    	//Drive Forward until hit totes
    	addSequential(new AutoCardinalFieldRelativeDrive(1, 22, 180));
    	//Back up a bit
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 1.5, 180));
    	//Strafe into gap
    	addSequential(new AutoCardinalFieldRelativeDrive(4, 79.8, 180));
    	//Drive into gap
    	addSequential(new AutoCardinalFieldRelativeDrive(1, 12, 180));
    	//Rotate to "hook" third can
    	addSequential(new RotateTo(135));
    	//Drive back to get can
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 34, 135));
    	//Drive to autozone
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 48.5, 135));
    	//Rotate to fit in autozone
    	addSequential(new RotateTo(90.0));
    }
    @Override
	public double getStartAngle() {
		// Starts with the front of the robot facing the right wall.
		return 90.0;
	}
}