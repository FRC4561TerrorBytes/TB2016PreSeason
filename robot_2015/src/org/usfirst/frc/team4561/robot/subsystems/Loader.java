package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Takes a Boolean value.  Turns the loader belt on or off.  
 */
public class Loader extends Subsystem {
    
	Victor beltMotor = ;//new(Victor.) //TBD Need to add port to victor
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

