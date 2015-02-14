package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutomodeDoNothing extends Abstract4561AutomodeGroup {

	public AutomodeDoNothing() {
		super();
		addSequential(new WaitCommand(10.0));
	}

	@Override
	public double getStartAngle() {
		// Starts facing straight up field
		return 0.0;
	}

}
