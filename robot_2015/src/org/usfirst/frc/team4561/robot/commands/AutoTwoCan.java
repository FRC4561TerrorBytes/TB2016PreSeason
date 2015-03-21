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
public class AutoTwoCan extends Abstract4561AutomodeGroup {

    public  AutoTwoCan() {
    	//Get first can
    	addSequential(new CommonAutoOneCan());
    	//Get second can
    	addSequential(new CommonAutoTwoCan());
    	//Drive to autozone
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 20, 180));
    	//Rotate to fit in autozone
    	addSequential(new RotateTo(90.0));
    }
    @Override
	public double getStartAngle() {
		// Starts with the front of the robot facing the right wall.
		return 90.0;
	}
}