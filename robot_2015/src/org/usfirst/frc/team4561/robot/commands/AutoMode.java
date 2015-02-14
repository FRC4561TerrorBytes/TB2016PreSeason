package org.usfirst.frc.team4561.robot.commands;

/**
 * Uses the AutoModeCardinalFieldRelativeDrive command in junction with the
 * RotateTo command to achieve movement.
 */
public class AutoMode extends Abstract4561AutomodeGroup {
    
    public  AutoMode() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	// Proof-of-Concept AutoMode:
    	// Starts on the edge of the Auto Zone
    	// Would rotate 90 degrees to face forward, and then drive forward
    	// 5 feet to be in the Auto Zone.
    	
    	addSequential(new RotateTo(0.0));
    	//Possible bug: because RotateTo stops as soon as it's called, AutoModeCardinalFieldRelativeDrive may
    	//run at the same time. 
    	addSequential(new AutoCardinalFieldRelativeDrive(1, 60));
    	
    }

	@Override
	public double getStartAngle() {
		// Starts with the front of the robot facing the right wall.
		return 90.0;
	}
}
