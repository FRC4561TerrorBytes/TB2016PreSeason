package org.usfirst.frc.team4561.robot.triggers;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * Custom trigger that checks if the robot is in Robot Relative mode and the jog
 * backwards button is pressed.
 */
public class InitializeGyroTrigger extends Trigger {

	public boolean get() {
		if (Robot.oi == null)
			return false;
		return Robot.getInstance().isDisabled()
				&& Robot.oi.initGyroButton.get();
	}
}