package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.WaitCommand;


/**
 *
 */
public class AutoGripCan extends Abstract4561AutomodeGroup {
    
    public  AutoGripCan() {
        addSequential(new ClawGrab());
        addSequential(new MoveElevatorNonPIDTimed(1, true));
        addSequential(new AutoCardinalFieldRelativeDrive(1, 95, 180));
        addSequential(new RotateTo(90));
    }

	@Override
	public double getStartAngle() {
		// TODO Auto-generated method stub
		return 180;
	}
}
