package org.usfirst.frc.team4561.robot.commands;

public class AutomodePushItemToZoneWithOpenClaw extends Abstract4561AutomodeGroup {

	public AutomodePushItemToZoneWithOpenClaw() {
		super();
		addSequential(new AutoCardinalFieldRelativeDrive(1, 135.0));
	}

	@Override
	public double getStartAngle() {
		// Starts facing straight up field
		return 0.0;
	}

}
