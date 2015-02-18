package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Claw extends Subsystem {
	
//	private Solenoid piston = new Solenoid(RobotMap.CLAW_PORT_CAN, RobotMap.CLAW_PORT);
//
//	@Override
//	protected void initDefaultCommand() {	
//	}
//	
//	public void closeClaw() {
//		piston.set(true);
//		
//	}
//	
//	public void openClaw() {
//		piston.set(false);
//	}
	
	private DoubleSolenoid piston = new DoubleSolenoid(RobotMap.CLAW_CAN, RobotMap.CLAW_PORT_1, RobotMap.CLAW_PORT_2);
	  


	@Override
	protected void initDefaultCommand() {	
	}
	
	public void closeClaw() {
		piston.set(DoubleSolenoid.Value.kForward);
	}
	
	public void openClaw() {
		piston.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stop() {
		piston.set(DoubleSolenoid.Value.kOff);
	}

}
