package org.usfirst.frc.team2988.robot.commands;

import org.usfirst.frc.team2988.robot.subsystems.BoxShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class BoxShooterCommand extends Command{
	private boolean done;
	private boolean isTimed;
    private BoxShooterSubsystem boxShooterSubsystem;

	
    public BoxShooterCommand(){
        boxShooterSubsystem = CommandBase.getBoxShooterSubsystem();
    	requires(boxShooterSubsystem);
    }
    
    public BoxShooterCommand (boolean isTimed) {
    	this();
    	this.isTimed = isTimed;
    }
    
    public void initialize() {
    	done = false;
    	if(isTimed) {
    		setTimeout(1);
    	}
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {  
    	boxShooterSubsystem.launch(-1);
    }

    /**
     * Make this return true when this Command no longer needs to run execute().
     */
    protected boolean isFinished() {
        return done || isTimedOut();
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
    	boxShooterSubsystem.launch(0);
    }

    @Override public void cancel() {
    	done = true;
    }

    /**
     * Called when another command which requires one or more of the same.
     */
    protected void interrupted() {
    }
}
