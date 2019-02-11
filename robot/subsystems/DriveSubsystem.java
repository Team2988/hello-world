package org.usfirst.frc.team2988.robot.subsystems;

import org.usfirst.frc.team2988.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Controls the driving motors and actions.
 */
public class DriveSubsystem extends Subsystem {

	private DifferentialDrive drive;
	private Encoder leftEncoder, rightEncoder;
	private AnalogGyro gyro;
	// private Ultrasonic rangeFinder;
	private double Kp = 0.3;
	private double ticksperInch = (360 / (4 * Math.PI)); // 360/(diameter*PI) =
															// ticks per inch

	/**
	 * Instantiates the driving motors with the encoders for both wheels.
	 */
	public DriveSubsystem() {

		Talon m_Left = new Talon(RobotMap.LEFT_MOTOR);
		Talon m_Right = new Talon(RobotMap.RIGHT_MOTOR);

		drive = new DifferentialDrive(m_Left, m_Right);
		// make sure to test this
		/*
		 * rangeFinder = new Ultrasonic(1,1);
		 * rangeFinder.setAutomaticMode(true);
		 */
		// initializes sensors
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_A, RobotMap.LEFT_ENCODER_B);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B);
		// gyro = new AnalogGyro(RobotMap.);
		// gyro.setSensitivity(.0125);

		// adds data to LiveWindow
		// SendableBase.setName("Drive Subsystem", "Left Encoder", leftEncoder);
		// LiveWindow.addSensor("Drive Subsystem", "Right Encoder",
		// rightEncoder);
	}

	/**
	 * Drive method for teleop.
	 * 
	 * @param x
	 *            controls left motor for tank drive + controls forward/backward
	 *            movement for arcade drive
	 * @param y
	 *            controls right motor for tank drive + controls rotation for
	 *            arcade drive
	 * @param tankOrArcade
	 *            true=tank false=arcade
	 */
	public void drive(double ly, double ry, double lx, double rx, double lt, double rt) {
		// if bot does not drive, then comment out and call drive type wanted..

		// uses drive type specified
		switch (RobotMap.DRIVE_TYPE) {
		case TANK:
			drive.tankDrive(ry, ly); // right stick y, left stick y
			break;
		case ARCADE:
			drive.arcadeDrive(rx, ly); // right stick x, left stick y
			break;
		case CATERPILLAR:
			caterpillarDrive(ly, rx); // left stick y, right stick x
			break;
		case SINGLE_ARCADE:
			drive.arcadeDrive(rx, ry); // left stick x, left stick y
			break;
		case SINGLE_TWIST_ARCADE:
			drive.arcadeDrive(rt, -ry); // left stick twist, left stick y

		}

		// System.out.println("ly:n" + ry + "\nly: " + ry);
		// System.out.println("LEncoder:" + -leftEncoder.getRaw());
		// System.out.println(" LInches: " + getleftTickDist());
		// System.out.println("REncoder:" + rightEncoder.getRaw());
		// System.out.println(" RInches:" + getrightTickDist());

		log();
	}

	/**
	 * Drives bot in autonomous.
	 * 
	 * @param x
	 *            forward motor value
	 * @param y
	 *            turn motor value
	 */
	public void autoDrive(double x, double y) {
		drive.arcadeDrive(x, y);
		// drive.tankDrive(x, y);
	}

	public void autoStrafe(double x) {
		// strafe.tankDrive(x, x);
	}

	public void caterpillarDrive(double ly, double rx) {
		// this might cause random drive issues

		if (Math.abs(ly) < .1) { // no forward drive, adjust for preference
			// strafe.tankDrive(rx, rx); // strafe when no forward movement
			rx = 0; // no arcade turn
		}
		drive.arcadeDrive(rx, ly);
	}

	/**
	 * @return left encoder reference.
	 */
	public Encoder getLeftEncoder() {
		return leftEncoder; // is reversed input..
	}

	/**
	 * @return right encoder reference.
	 */
	public Encoder getRightEncoder() {
		return rightEncoder;
	}

	/**
	 * @return average distance of left and right encoder raw values
	 */
	public double averageTickCount() {
		return (-leftEncoder.get() + rightEncoder.get()) / 2;
	}

	/**
	 * @return left encoder distance in inches
	 */
	public double getleftTickDist() {
		return Math.abs(leftEncoder.get() / ticksperInch);
	}

	/**
	 * @return right encoder distance in inches
	 */
	public double getrightTickDist() {
		return Math.abs(rightEncoder.get() / ticksperInch);
	}

	/**
	 * @return average distance traveled in inches
	 */
	public double distanceTickTraveled() {
		// returns distance traveled inches
		return averageTickCount() / ticksperInch;
	}

	/**
	 * @return The robots heading in degrees.
	 */

	public double getHeading() {
		return gyro.getAngle();
	}

	/**
	 * Returns the range of the robot to an object in inches.
	 * 
	 * @return range to object in inches
	 */

	// public double getRange() {
	// return rangeFinder.getRangeInches();
	// }

	/**
	 * Resets encoders and gyro.
	 */
	public void reset() {
		// gyro.reset();
		leftEncoder.reset();
		rightEncoder.reset();
	}

	/**
	 * 
	 */
	public void initDefaultCommand() {
	}

	/**
	 * Logs data to SmartDashboard to view data.
	 */
	public void log() {
		SmartDashboard.putNumber("Distance", distanceTickTraveled());
		SmartDashboard.putNumber("Left Distance", getleftTickDist());
		SmartDashboard.putNumber("Right Distance", getrightTickDist());
		SmartDashboard.putNumber("Encoder Right Rate", rightEncoder.getRate());
	}

}
