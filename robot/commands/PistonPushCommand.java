package org.usfirst.frc.team2988.robot.commands;

import org.usfirst.frc.team2988.robot.subsystems.PneumaticSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class PistonPushCommand extends Command {
	private PneumaticSubsystem pneumaticSubsystem;
	
	public PistonPushCommand() {
		pneumaticSubsystem = CommandBase.getPneumaticSubsystem();
		requires(pneumaticSubsystem);
	}
	
	/**
     * Called just before this Command runs the first time.
     */
    public void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {  
    	pneumaticSubsystem.push();
    }

    /**
     * Make this return true when this Command no longer needs to run execute().
     */
    protected boolean isFinished() {
        return true;
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
    	pneumaticSubsystem.push();
    }

    @Override public void cancel() {
    }

    /**
     * Called when another command which requires one or more of the same.
     */
    protected void interrupted() {
    }

}
