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
		FieldRealtive("DB/String 0", "Field Relative: "),
		DriveX("DB/String 1", "Drive X: "),
		DriveY("DB/String 2", "Drive Y: "),
		RotateOutput("DB/String 3", "Rotate: "),
		GyroValue("DB/String 4", "Gyro: "),
		ElevatorPosition("DB/String 5", "Elevator pos: "),
		ElevatorDirection("DB/String 6", "Elevator dir: "),
		ClawState("DB/String 7", "Claw is "),
		ExtenderPosition("DB/String 8", "Extender is ");	
		
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

