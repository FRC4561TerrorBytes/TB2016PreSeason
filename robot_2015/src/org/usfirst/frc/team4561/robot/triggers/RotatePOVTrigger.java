package org.usfirst.frc.team4561.robot.triggers;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This is a Custom trigger that gets the value of the rotation Stick Hat, and also checks if the robot is 
 *  in robot relative mode, by checking if the button for robot relative mode is pressed.  
 */
public class RotatePOVTrigger extends Trigger {
    
    public boolean get() {
    	if(Robot.oi == null) return false;
        return Robot.oi.getRotatePOV() != -1 && Robot.oi.isRobotRelative();
    }
}
