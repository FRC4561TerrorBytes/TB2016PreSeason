package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Takes a Boolean value.  Turns the loader belt on or off.  
 */
public class Loader extends Subsystem {
    int speed = 42; //placeholder
	Victor beltMotor = new Victor(RobotMap.BELT_MOTOR);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void moveBelt(boolean x){
    	if(x==true){
    		beltMotor.set(speed);//TBD need to add speed
    	}
    	else if(x==false){
    		beltMotor.set(0);
    	}
    }
}

