package org.usfirst.frc.team4561.robot.commands;

public class AutomodePushItemsToZoneSideways extends Abstract4561AutomodeGroup {

	public AutomodePushItemsToZoneSideways() {
		super();
		addSequential(new AutoCardinalFieldRelativeDrive(1, 200, 90.0));
	}

	@Override
	public double getStartAngle() {
		// Starts facing right
		return 90.0;
	}

}
