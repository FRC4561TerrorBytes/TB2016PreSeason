package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 */
public class ElevatorNonPID extends Subsystem implements IElevator {
	
	private Talon elevatorMotor = new Talon(RobotMap.ELEVATOR_MOTOR);
	private DigitalInput lowerLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_LIMIT_SW_BOTTOM);
	private DigitalInput upperLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_LIMIT_SW_TOP);
	
	public void moveUp() {
		if(upperLimitSwitch.get() == true) {
			elevatorMotor.set(0.5);
		}
		else {
			stop();
		}
	}
	
	public void moveDown() {
		if(lowerLimitSwitch.get() == true) {
			elevatorMotor.set(-0.5);
		}
		else {
			stop();
		}
	}
	
	public void stop() {
		elevatorMotor.set(0);
	}
    
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

