package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Takes a Boolean value.  Turns the loader belt on or off.  
 */
public class Loader extends Subsystem {
    
	SpeedController beltMotor;
	public DigitalOutput loadedLED = new DigitalOutput(RobotMap.LOADED_LED);
	
	//TODO: Add a digital input on an unknown port that'll be the loaded sensor. Will return a boolean.
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Loader() {
		constructMotorControllers();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	public void constructMotorControllers() {
		if(RobotMap.LOADER_USE_VICTORS) {
			beltMotor = new Victor(RobotMap.BELT_MOTOR);
		} else {
			beltMotor = new Talon(RobotMap.BELT_MOTOR);
		}
	}
	
    /**
     * Takes a double value.  Sets the loader belt speed.  
     */
    public void setBeltSpeed(double speed) {
    	beltMotor.set(speed);
    }
    
    public double getBeltSpeed() {
    	return beltMotor.get();
    }
}
