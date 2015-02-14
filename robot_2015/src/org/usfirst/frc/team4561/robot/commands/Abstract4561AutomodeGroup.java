/**
 * 
 */
package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Base class for team 4561 automodes.
 */
public abstract class Abstract4561AutomodeGroup extends CommandGroup {

	/**
	 * 
	 */
	public Abstract4561AutomodeGroup() {
		super();
	}

	/**
	 * Each automode must implement this to report its starting angle relative
	 * to 0 being up field toward the step.
	 * 
	 * @return the start angle
	 */
	public abstract double getStartAngle();

}
