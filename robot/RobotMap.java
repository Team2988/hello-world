package org.usfirst.frc.team2988.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
//Swapped 0 and 4
	// ports for joy sticks
	public static final int LEFT_STICK = 0;
	public static final int RIGHT_STICK = 4;

	// dead zone allowance for joy sticks
	public static final double DEAD_ZONE = 0.05;

	// motor ports
	public static final int RIGHT_MOTOR = 2;
	public static final int BACK_MOTOR = 1;
	public static final int LEFT_MOTOR = 0;

	public static final int ARMS_LEFT_MOTOR = 3;
	public static final int ARMS_WHEELS_MOTOR = 4;
	public static final int BOX_MOTOR = 5;
	public static final int SCALER_MOTOR = 6;
	public static final int ARMS_RIGHT_MOTOR = 7;

	// drive type on initial run time
	public static final DriveType DRIVE_TYPE = DriveType.SINGLE_TWIST_ARCADE;

	// Pistons, requires 2 ports for solenoids
	//public static final int LAUNCH_PISTON = 0; // and 1
	public static final int ANGLE_PISTON = 4; // and 5

	// limit switches, uses DIO port
	 public static final int ARMS_LEFT_LIMIT_SWITCH = 5;
	 public static final int ARMS_RIGHT_LIMIT_SWITCH = 6;
	// public static final int RANGE_FINDER = 3;

	// left motor encoder values
	public static final int LEFT_ENCODER_A = 0;
	public static final int LEFT_ENCODER_B = 1;

	// right motor encoder values
	public static final int RIGHT_ENCODER_A = 2;
	public static final int RIGHT_ENCODER_B = 3;

	// scaler motor encoder values
	// public static final int SCALER_ENCODER_A = 4;
	// public static final int SCALER_ENCODER_B = 5;

	// public static final int COMPRESSOR = -1;
	// public static final int GYRO = 0;
}
