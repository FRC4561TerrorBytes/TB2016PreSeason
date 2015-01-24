package org.usfirst.frc.team4561.robot.triggers;

import org.usfirst.frc.team4561.robot.Robot;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This is a custom trigger that checks if the robot is in robot relative mode and the jog right button is pressed.  
 */
public class JogRightTrigger extends Trigger {
    
    public boolean get() {
        return Robot.oi.isRobotRelative()&& Robot.oi.joggingRightButton.get();
    }
}
