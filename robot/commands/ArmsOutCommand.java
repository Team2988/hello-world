package org.usfirst.frc.team2988.robot.commands;

import org.usfirst.frc.team2988.robot.subsystems.ArmSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ArmsOutCommand extends CommandGroup {
/*	public ArmsOutCommand() {
		addParallel(new LArmsOutCommand());
		addParallel(new RArmsOutCommand());
	}
*/
	private boolean done = false;
	private ArmSubsystem armSubsystem;

	public ArmsOutCommand() {
		armSubsystem = CommandBase.getArmSubsystem();
		requires(armSubsystem);
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
		armSubsystem.RarmRotate((armSubsystem.rightSwitch()) ? 0 : -.6);
		armSubsystem.LarmRotate((armSubsystem.leftSwitch()) ? 0 : .6);
	}

	/**
	 * Stops arms when limit switch is pressed or command is cancelled.
	 */
	protected boolean isFinished() {
		return done;
		
	}

	/**
	 * Called once after isFinished returns true.
	 */
	protected void end() {
		armSubsystem.RarmRotate(0);
		armSubsystem.LarmRotate(0);
	}

	@Override
	public void cancel() {
		done = true;
	}

	/**
	 * Called when another command which requires one or more of the same.
	 */
	protected void interrupted() {
	}}
