package org.usfirst.frc.team4561.robot.commands;


/** 
 * Command to be run during autonomous mode
 * 
 * START: Claw facing eastern guardrail, Extender out 80"(6'8"), center of robot positioned at the 
 * intersection of the horizontal center of the furthest scoring platform of the alliance wall, and the
 * line formed by the second group of two vertical totes in the landfill zone from the eastern guardrail.
 * 
 * END: Claw facing eastern guardrail, Extender out 80"(6'8"), robot positioned in eastern half
 * of the autozone.
 */
public class AutoTwoCanFling extends Abstract4561AutomodeGroup {

    public  AutoTwoCanFling() {

    	addSequential(new CommonAutoOneCan());
    	//Strafe to gap between first and second bins
    	addSequential(new AutoCardinalFieldRelativeDrive(4, 25, 180));
    	//Drive Forward until hit totes, back up a bit if didn't see tape
    	addSequential(new AutoCardinalFieldRelativeDrive(1, 22, 180, 8));
    	//Strafe to second can
    	addSequential(new AutoCardinalFieldRelativeDrive(4, 25, 180));
    	//Pull second can back
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 22, 180));
    	//Drive to autozone while flinging
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 48.5, 90));
    }
    @Override
	public double getStartAngle() {
		// Starts with the front of the robot facing the right wall.
		return 90.0;
	}
}