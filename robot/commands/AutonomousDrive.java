package org.usfirst.frc.team2988.robot.commands;

import org.usfirst.frc.team2988.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The Class AutonomousDrive.
 */
public class AutonomousDrive extends Command {

	private DriveSubsystem driveSubSystem;
	private double x, y;					// motor values for AutoDrive
	private double time;
	private int distance;
	private boolean timed;
	
	private AutonomousDrive() {
		driveSubSystem = CommandBase.getDriveSubsystem();
	}
	
	public AutonomousDrive(double x, double y) {
		this(); // this() == AutonomousDrive(), this == AutonomousDrive
		this.x = x;
		this.y = y;

		requires(driveSubSystem);
	}

	/**
	 * Instantiates a new autonomous drive with distance.
	 *
	 * @param x
	 *            the forward motor value
	 * @param y
	 *            the turn motor value
	 * @param
	 */
	public AutonomousDrive(double x, double y, int distance) {
		this(x, y);

		timed = false;
		this.distance = distance;
	}

	/**
	 * 
	 * @param x
	 *            the forward motor value
	 * @param y
	 *            the turn motor value
	 * @param time
	 *            seconds to run command
	 */
	public AutonomousDrive(double x, double y, double time) {
		this(x, y);

		timed = true;
		this.time = time;
	}

	/**
	 * Initializes time to run command if applicable.
	 */
	@Override
	protected void initialize() {
		if (timed) {
			setTimeout(time);
		}
	}

	/**
	 * Runs the autonomous drive.
	 */
	@Override
	protected void execute() {
		driveSubSystem.autoDrive(x, y);
		// driveSubSystem.autoStrafe(strafe);
	}

	/**
	 * Stops when time limit is reached or within 3 inches if applicable.
	 */
	@Override
	protected boolean isFinished() {
		boolean finished = false;

		if (timed) {
			finished = isTimedOut();
		} else if (Math.abs(distance - driveSubSystem.distanceTickTraveled()) < 3) {
			finished = true;
		}

		return finished;
	}

	/**
	 * Returns average distance traveled if pulse is enabled.
	 * 
	 * @return distance traveled in inches
	 */
	public double distanceTraveled() {
		return (driveSubSystem.getLeftEncoder().getDistance() + driveSubSystem.getRightEncoder().getDistance()) / 2;
	}

	public boolean distanceCorrect() {
		return (Math.abs(distance - distanceTraveled())) < 3;
	}

	public boolean distanceTick() {
		return (Math.abs(distance - distanceTraveled())) < 3;
	}

	@Override
	protected void end() {
		driveSubSystem.autoDrive(0, 0);
		driveSubSystem.autoStrafe(0.0);
	}

	@Override
	protected void interrupted() {

	}

}
