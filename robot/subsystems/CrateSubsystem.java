package org.usfirst.frc.team2988.robot.subsystems;

import org.usfirst.frc.team2988.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;


/**
 * Subsystem that controls arm wheel motors.
 */
public class CrateSubsystem extends Subsystem {
    private Talon armsWheels;

    public void initDefaultCommand() {
    }

    /**
     *
     */
    public CrateSubsystem() {
        // motor of the wheels on the arms
        armsWheels = new Talon(RobotMap.ARMS_WHEELS_MOTOR);
    }

    /**
     * Controls value of motors on arms.
     *
     * @param x value of intake or outtake
     */
    public void suck(double x) {
        armsWheels.set(x);
    }


    /**
     * Logs data to SmartDashboard.
     */
    public void log() {

    }
}
