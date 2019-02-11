package org.usfirst.frc.team2988.robot.commands;

import org.usfirst.frc.team2988.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.command.Command;

public class LArmsInCommand extends Command {
    private boolean done = false;
    private ArmSubsystem armSubsystem;

    public LArmsInCommand() {
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
        armSubsystem.LarmRotate(-.5);
    }

    /**
     * Stops arms when limit switch is pressed or command is cancelled.
     */
    protected boolean isFinished() {
        return (done); // || armSubsystem.inSwitchActivated() 
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
        armSubsystem.LarmRotate(0);
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
