package org.usfirst.frc.team2988.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2988.robot.RobotMap;


/**
 * Subsystem that controls the pneumatic resources.
 */
public class PneumaticSubsystem extends Subsystem {

    private Solenoid pangle, pangle2, plaunch, plaunch2;

    @Override protected void initDefaultCommand() { }

    public PneumaticSubsystem() {
        // pistons ports
        pangle = new Solenoid(RobotMap.ANGLE_PISTON);
        pangle2 = new Solenoid(RobotMap.ANGLE_PISTON + 1);
        //plaunch = new Solenoid(RobotMap.LAUNCH_PISTON);
        //plaunch2 = new Solenoid(RobotMap.LAUNCH_PISTON + 1);

        // ports set to opposite values
        pangle.set(true);
        pangle2.set(false);
        //plaunch.set(true);
        //plaunch2.set(false);
    }

    /**
     * Controls angle of box shooter piston.
     */
    public void angle() {
        // toggles up and down of piston
        pangle2.set(pangle.get());    // piston2 set to value of pison1
        pangle.set(!pangle.get());    // piston1 set to inverse of its value
    }

    /**
     * Pneumatics push the crate into box shooter.
     */
    public void push() {
        // toggles up and down of piston
      //  plaunch.set(!plaunch.get());  // piston2 set to value of pison1
      //  plaunch2.set(plaunch.get());  // piston1 set to inverse of its value
    }

    public void log() {

    }
}
