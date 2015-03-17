package org.usfirst.frc.team4561.robot.commands;


/** 
 * Command to be run during autonomous mode
 * 
 * START: Claw facing eastern guardrail, Extender out 80"(6'8"), center of robot positioned at the 
 * intersection of the horizontal center of the furthest scoring platform of the alliance wall, and the
 * line formed by the second group of two vertical totes in the landfill zone from the eastern guardrail.
 * 
 * END: Claw facing western guardrail, Extender out 80"(6'8"), robot positioned in western half
 * of the autozone.
 */
public class AutoFourCan extends Abstract4561AutomodeGroup {
    
    public  AutoFourCan() {

    	//Get first can
    	addSequential(new CommonAutoOneCan());
    	//Get second can
    	addSequential(new CommonAutoTwoCan());
    	//Drive Forward until hit totes
    	AutoCardinalFieldRelativeDriveWithTape forward = new AutoCardinalFieldRelativeDriveWithTape(1, 22, 180);
    	addSequential(forward);
    	//Back up a bit
    	addSequential(new AutoConditionalBackoff(0, 2, 180, forward));
    	//TODO AutoConditionalBackoff will accept a 0 for movement, right?
    	//Precisely strafe between landfill and scoring platform to "hook" third can
    	addSequential(new AutoCardinalFieldRelativeDrive(4, 161, 180));
    	//Pull third can back
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 22, 180));
    	//Drive Forward until hit totes
    	forward = new AutoCardinalFieldRelativeDriveWithTape(1, 28, 180);
    	addSequential(forward);
    	//Back up a bit
    	addSequential(new AutoConditionalBackoff(0, 2, 180, forward));
    	//TODO AutoConditionalBackoff will accept a 0 for movement, right?
    	//Precisely strafe to "hook" the fourth and final can
    	addSequential(new AutoCardinalFieldRelativeDrive(4, 63, 180));
    	//Pull fourth can back
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 22, 180));
    	//Drive backward to autozone
    	addSequential(new AutoCardinalFieldRelativeDrive(3, 48.5, 180));
    	//Rotate to fit in autozone
    	addSequential(new RotateTo(-90.0));
    	
    	// ACHEIVE EPIC WIN   	
    	
    }

	@Override
	public double getStartAngle() {
		return 90.0;
	}
}
