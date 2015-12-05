package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4561.robot.commands.SmartDashboardDisplay;


/**
 *
 */
public class SDLogging extends Subsystem {
	
	public enum Key {
		Drive("DB/String 0", "Drive: "),
		Rotation("DB/String 1", "Rotation: "),
		Throttle("DB/String 2", "Throttle: "),
		WheelRPS("DB/String 3", "RPS: "),
		WheelSpeed("DB/String 4", "Speed: ");
		
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
	 }
}

