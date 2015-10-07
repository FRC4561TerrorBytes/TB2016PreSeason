/**
 * 
 */
package org.usfirst.frc.team4561.robot.subsystems;

/**
 * Defines the most basic (non-PID) interface for an elevator subsystem. Both
 * the PID and non-PID elevator subsystems will implement this interface. This
 * will enable easy switching between the two where the user controls for PID
 * are a proper superset of those for non-pid.
 */
public interface IElevator {
	/**
	 * Forces the elevator to move upward unless at the upper limit switch.
	 */
	public void moveUp();

	/**
	 * Forces the elevator to move downward unless at the lower limit switch.
	 */
	public void moveDown();
	
	public void moveUpAnalog(double power);

	/**
	 * Forces the elevator to stop.
	 */
	public void stop();
}
