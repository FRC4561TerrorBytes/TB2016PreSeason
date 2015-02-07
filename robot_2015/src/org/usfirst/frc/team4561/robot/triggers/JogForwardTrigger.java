package org.usfirst.frc.team4561.robot.triggers;

import org.usfirst.frc.team4561.robot.Robot;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *Custom trigger that checks if the robot is in Robot Relative mode and the jog forward button is pressed.
 */
public class JogForwardTrigger extends Trigger {
    
    public boolean get() {
    	//if(Robot.oi == null) return false;
        //return Robot.oi.isRobotRelative()&& Robot.oi.joggingForwardButton.get();
    	return false;
    }
}
