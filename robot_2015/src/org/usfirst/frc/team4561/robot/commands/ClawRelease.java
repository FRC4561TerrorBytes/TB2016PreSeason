package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4561.robot.Robot;



public class ClawRelease extends Command {
	
	public ClawRelease() {
		setTimeout(2);
		requires(Robot.claw);
	}

	@Override
	protected void initialize() {
    	
		
	}

	@Override
	protected void execute() {
		Robot.claw.openClaw();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.claw.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

}
