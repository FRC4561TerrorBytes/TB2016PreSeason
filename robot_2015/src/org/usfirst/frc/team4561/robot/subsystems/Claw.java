package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Claw extends Subsystem {
	private DoubleSolenoid piston1 = new DoubleSolenoid(RobotMap.CLAW_PORT_1, RobotMap.CLAW_PORT_2);
	  


	@Override
	protected void initDefaultCommand() {	
	}
	
	public void closeClaw() {
		piston1.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void openClaw() {
		piston1.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stop() {
		piston1.set(DoubleSolenoid.Value.kOff);
	}

}
