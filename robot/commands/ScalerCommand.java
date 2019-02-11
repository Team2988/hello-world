package org.usfirst.frc.team2988.robot.commands;

import org.usfirst.frc.team2988.robot.subsystems.ScalerSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The Class ScalerCommand.
 */
public class ScalerCommand extends Command {

	private boolean done = false;
	private ScalerSubsystem scalerSubsystem;

	/**
	 * Instantiates a new scaler command.
	 * @param speed 
	 */
	public ScalerCommand() {
		// Use requires() here to declare subsystem dependencies
		scalerSubsystem = CommandBase.getScalerSubsystem();
		requires(scalerSubsystem);
	}

	/**
	 * 
	 */
	public void initialize() {
		done = false;
	}

	/**
	 * 
	 */
	protected void execute() {
		scalerSubsystem.climb(-1);
	}

	/**
	 * 
	 */
	protected boolean isFinished() {

		return done;
	}

	/**
	 * 
	 */
	protected void end() {
		scalerSubsystem.climb(0);
	}

	/**
	 * 
	 */
	@Override
	public void cancel() {
		done = true;

	}

	/**
	 * 
	 */
	protected void interrupted() {
	}
}
