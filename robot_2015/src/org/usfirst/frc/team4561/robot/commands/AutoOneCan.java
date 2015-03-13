package org.usfirst.frc.team4561.robot.commands;

/**
 * Uses the AutoModeCardinalFieldRelativeDrive command in junction with the
 * RotateTo command to achieve movement.
 */
public class AutoOneCan extends Abstract4561AutomodeGroup {

	
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
    public  AutoOneCan() {
    	//Get first can
    	addSequential(new CommonAutoOneCan());
    	//Drive to autozone
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 48.5, 180));
    	//Rotate to fit in autozone
    	addSequential(new RotateTo(-90.0));
    	//TODO should this end facing west wall?
    }

	@Override
	public double getStartAngle() {
		// Starts with the front of the robot facing the right wall.
		return 90.0;
	}
}
