package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.commands.SmartDashboardDisplay;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 */
public class SDLogging extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public enum Key {
		FieldRealtive("String 0", "Field Relative: "),
		DriveX("String 1", "Drive X: "),
		DriveY("String 2", "Drive Y: "),
		RotateOutput("String 3", "Rotate: "),
		GyroValue("String 4", "Gyro: "),
		ElevatorPosition("String 5", "Elevator pos: "),
		ElevatorDirection("String 6", "Elevator dir: "),
		ClawState("String 7", "Claw is "),
		ExtenderPosition("String 8", "Extender is ");	
		
		private String key;
		private String label;
		
		Key(String key, String label){
			this.key = key;
			this.label = label;
		}
	}
	public void displayData(Key key,String value){
		SmartDashboard.putString(key.key,key.label + value);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new SmartDashboardDisplay());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

