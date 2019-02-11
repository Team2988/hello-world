package org.usfirst.frc.team2988.robot.commands;

import org.usfirst.frc.team2988.robot.subsystems.CrateSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class CrateSuckCommand extends Command {
	private boolean done;
	private CrateSubsystem crateSubsystem;

	public CrateSuckCommand() {
		crateSubsystem = CommandBase.getCrateSubsystem();
		requires(crateSubsystem);
	}

	/**
	 * Called just before this Command runs the first time.
	 */
	public void initialize() {
		done = false;
	}
	
	/**
	 * Called repeatedly when this Command is scheduled to run.
	 */
	protected void execute() {
		crateSubsystem.suck(1);
	}
	
	/**
	 * Make this return true when this Command no longer needs to run execute().
	 */
	protected boolean isFinished() {
		return done;
	}

	/**
	 * Called once after isFinished returns true. 
	 */
	protected void end() {
		crateSubsystem.suck(0);
	}

	@Override
	public void cancel() {
		done = true;
	}

	/**
	 * Called when another command which requires one or more of the same.
	 */
	protected void interrupted() {
	}
}
