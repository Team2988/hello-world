package org.usfirst.frc.team2988.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
//replace with correct syntax and it will work
import org.usfirst.frc.team2988.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;

/**
 * Subsystem that controls the resources for the arm motors.
 */
public class ArmSubsystem extends Subsystem {
	private Talon armL;
	private Talon armR;
	//private Talon arms;
	private DigitalInput leftLimitSwitch, rightLimitSwitch;
	private Counter leftLimitCounter, rightLimitCounter;

	@Override
	protected void initDefaultCommand() {
	}

	public ArmSubsystem() {
	//	armL = new Talon(RobotMap.ARMS_LEFT_MOTOR);
		armR = new Talon(RobotMap.ARMS_RIGHT_MOTOR);
        armL = new Talon(RobotMap.ARMS_LEFT_MOTOR);
	
        // limit switches for arm movement
		leftLimitSwitch = new DigitalInput(RobotMap.ARMS_LEFT_LIMIT_SWITCH);
		rightLimitSwitch = new DigitalInput(RobotMap.ARMS_RIGHT_LIMIT_SWITCH);

		// value counter for limit switch
		leftLimitCounter = new Counter(leftLimitSwitch);
		rightLimitCounter = new Counter(rightLimitSwitch);

		// resets counters
		initializeCounter();
	}

	/**
	 * Resets the value for the limit switches.
	 */
	public void initializeCounter() {
		leftLimitCounter.reset();
		rightLimitCounter.reset();
	}

	
	public boolean leftSwitch() {
		return !leftLimitSwitch.get();

	}
	
	public boolean rightSwitch() {
		return !rightLimitSwitch.get();

	}
	
	/**
	 * Returns if arm "left" limit switch was pushed down.
	 */
	public boolean leftSwitchActivated() {
		// remove ! if switch being open is 0
		return !(leftLimitCounter.get() > 0);
	}

	/**
	 * Returns if arm "right" limit switch was pushed down.
	 */
	public boolean rightSwitchActivated() {
		// remove ! if switch being open is 0
		return !(rightLimitCounter.get() > 0);
	}

	/**
	 * Controls arms rotation.
	 *
	 * @param armVal
	 *            in/out value
	 */
	public void LarmRotate(double armValL) {
		armL.set(armValL);

	}

	public void RarmRotate(double armValR) {

		armR.set(armValR);
	
	}
	
	public void log() {

	}
}
