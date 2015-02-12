package org.usfirst.frc.team4561.robot.triggers;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class JogPOVTrigger extends Trigger {
	
	private boolean lastSeenAsActive = false;
    
    public boolean get() {
    	boolean fire = false;
		if ((Robot.oi != null) && (Robot.oi.isRobotRelative())) {
			boolean nowActive = Robot.oi.getDrivePOV() != -1;
			if (lastSeenAsActive) {
				if (!nowActive)
					lastSeenAsActive = false;
			} else {
				if (nowActive) {
					fire = true;
					lastSeenAsActive = true;
				}
			}
		}
		return fire;
    }
}
