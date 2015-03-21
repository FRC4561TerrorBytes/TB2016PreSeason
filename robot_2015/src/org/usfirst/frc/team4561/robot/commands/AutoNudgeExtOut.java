package org.usfirst.frc.team4561.robot.commands;

/**
 * To be run in autonomous mode
 * START: Same as can autos
 * END: Translated to inside the autozone
 */
public class AutoNudgeExtOut extends Abstract4561AutomodeGroup {
    
    public  AutoNudgeExtOut() {
        addSequential(new AutoCardinalFieldRelativeDrive(3, 48, 90));
        addSequential(new ClawGrab());
    }

	@Override
	public double getStartAngle() {
		return 90;
	}
}
