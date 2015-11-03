package org.usfirst.frc.team4561.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team4561.robot.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private static final double DRIVE_DEAD_ZONE = 0.15;
    private static final double ROT_DEAD_ZONE = 0.15;
    private static final double DRIVE_STICK_REDUCTION = 0;
    private static final double ROT_STICK_REDUCTION = 0;
    
    private boolean isTouringMode = false;
    private static final double TOURING_MODE_DRIVE_MULTIPLIER = 0.6;
    private static final double TOURING_MODE_ROT_MULTIPLIER = 0.6;
    
    Joystick driveStick = new Joystick(RobotMap.DRIVE_STICK);
    Joystick rotStick = new Joystick(RobotMap.ROT_STICK);
    double driveValue;
    public double getDrive() {
        driveValue = driveStick.getY();
        if(Math.abs(driveValue) < DRIVE_DEAD_ZONE) {
            driveValue = 0;
        }
        if(driveValue > 0) {
            driveValue = driveValue - DRIVE_STICK_REDUCTION;
        }
        if(driveValue < 0) {
            driveValue = driveValue + DRIVE_STICK_REDUCTION;
        }
        return driveValue;
    }
    
    double rotValue;
    public double getRot() {
        rotValue = rotStick.getX();
        if(Math.abs(rotValue) < ROT_DEAD_ZONE) {
            rotValue = 0;
        }
        if(rotValue > 0) {
            rotValue = rotValue - ROT_STICK_REDUCTION;
        }
        if(rotValue < 0) {
            rotValue = rotValue + ROT_STICK_REDUCTION;
        }
        return rotValue;
    }
    
    public boolean isTouringMode() {
        return isTouringMode;
    }
    public void setTouringMode(boolean on) {
        isTouringMode = on;
    }
    public double getTouringDrivePower() {
        return TOURING_MODE_DRIVE_MULTIPLIER;
    }
    public double getTouringRotPower() {
        return TOURING_MODE_ROT_MULTIPLIER;
    }
}

