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
		ROBOTRELATIVE("0"),
		POSTIONOFELEVATOR("1"),
		DIRECTIONOFELEVATOR("2"),
		CLAWOPEN("3"),
		MOTORX("4"),
		MOTORY("5"),
		MOTORROTATE("6"),
		GYROVALUE("7"),
		EXTENDERPOSITION("8");	
		
		private String key;
		
		Key(String key){
			this.key = key;
		}
	}
	public void displayData(Key key,String value){
		SmartDashboard.putString(key.key,value);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new SmartDashboardDisplay());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

