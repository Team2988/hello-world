package org.usfirst.frc.team2988.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2988.robot.RobotMap;

public class BoxShooterSubsystem extends Subsystem {
    private Talon boxShooter;

    @Override protected void initDefaultCommand() { }

    public BoxShooterSubsystem() {
        boxShooter = new Talon(RobotMap.BOX_MOTOR);
    }

    /**
     * Launches crate with box shooter wheels.
     */
    public void launch(int launchVal) {
        boxShooter.set(launchVal);
    }

    public void log() {

    }
}
