package org.usfirst.frc.team4561.robot.commands;


/** 
 * Command to be run during autonomous mode
 * 
 * START: Claw facing eastern guardrail, Extender out 80"(6'8"), center of robot positioned at the 
 * intersection of the horizontal center of the furthest scoring platform of the alliance wall, and the
 * line formed by the second group of two vertical totes in the landfill zone from the eastern guardrail.
 * 
 * END: Claw facing eastern guardrail, Extender out 80"(6'8"), robot positioned just outside the gap of the
 * landfill zone.
 */
public class AutoThreeCanFling extends Abstract4561AutomodeGroup {

    public  AutoThreeCanFling() {
    	
    	//Get first can
    	addSequential(new CommonAutoOneCan());
    	//Get second can
    	addSequential(new CommonAutoTwoCan());
    	//Drive Forward until hit totes, back up a bit if didn't see tape
    	addSequential(new AutoCardinalFieldRelativeDrive(1, 24, 180, 0.5));
    	//Strafe into gap
    	addSequential(new AutoCardinalFieldRelativeDrive(4, 79.8, 180));
    	//Drive into gap
    	addSequential(new AutoCardinalFieldRelativeDrive(1, 12, 180));
    	//Rotate to "hook" third can
    	addSequential(new RotateTo(135));
    	//Drive back and fling to get can
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 12, 90));
    }
    @Override
	public double getStartAngle() {
		// Starts with the front of the robot facing the right wall.
		return 90.0;
	}
}