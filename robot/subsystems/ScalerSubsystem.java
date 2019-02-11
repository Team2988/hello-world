package org.usfirst.frc.team2988.robot.subsystems;

import org.usfirst.frc.team2988.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * Controls the scaler motor and actions.
 */
public class ScalerSubsystem extends Subsystem {
    private Talon scaler;
    private Encoder scalerEncoder;

    /**
     *
     */
    public void initDefaultCommand() {

    }

    /**
     * Instantiates the talon to the scalerMotor and encoder connected to
     * scaler.
     */
    public ScalerSubsystem() {
        scaler = new Talon(RobotMap.SCALER_MOTOR);
        // scalerEncoder = new Encoder(RobotMap.SCALER_ENCODER_A, RobotMap.SCALER_ENCODER_B);
    }

    /**
     * Uses scaling motor.
     *
     * @param x value for motor
     */
    public void climb(double x) {
        scaler.set(x);
    }

    /**
     * @return scaler encoder reference
     */
    public Encoder getScalerEncoder() {
        return scalerEncoder;
    }

    /**
     *
     */
    public void log() {
        // SmartDashboard.putNumber("Scaler Distance",
        // scalerEncoder.getDistance());
    }
}
