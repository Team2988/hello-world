package org.usfirst.frc.team2988.robot.commands;

import org.usfirst.frc.team2988.robot.DriveType;
import org.usfirst.frc.team2988.robot.RobotMap;
import org.usfirst.frc.team2988.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Controls OI stick input and driving of bot.
 */
public class DriveCommand extends Command {
    private DriveSubsystem drive;
    private Joystick lStick, rStick;
    //private boolean tankOrArcade = RobotMap.TANK;
    private boolean done;

    /**
     * Instantiates a new drive command.
     */
    public DriveCommand() {
        lStick = CommandBase.leftStickGetter();
        rStick = CommandBase.rightStickGetter();
        drive = CommandBase.getDriveSubsystem();
        requires(drive);
    }

    /**
     * Initializes done to false.
     */
    protected void initialize() {
        done = false;
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {

        double lStickY, lStickX, rStickY, rStickX;
        
        lStickY = -lStick.getY(); // left motor for tank and forward/backward for arcade

        lStickX = lStick.getX(); // not used for normal drive methods..

        rStickY = rStick.getY(); // right motor for tank

        rStickX = rStick.getX(); // for omni drive strafe and arcade rotation

        // dead zones for joy sticks
        lStickX = (Math.abs(lStickX) < RobotMap.DEAD_ZONE) ? 0 : lStickX;
        rStickX = (Math.abs(rStickX) < RobotMap.DEAD_ZONE) ? 0 : rStickX;
        rStickY = (Math.abs(rStickY) < RobotMap.DEAD_ZONE) ? 0 : rStickY;
        lStickY = (Math.abs(lStickY) < RobotMap.DEAD_ZONE) ? 0 : lStickY;

        // stick sensitivity, doesn't work
        double rmult = ((1 - rStick.getZ()) < 0.3) ? 0.35 : (1 - rStick.getZ());
        double lmult = ((1 - lStick.getRawAxis(3)) < 0.3) ? 0.35 : (1 - lStick.getRawAxis(3));
        
        // if stick does not have twist it returns -1
        double rTwist = rStick.getTwist();
        double lTwist = lStick.getTwist();
        
        System.out.println("r-3" + rStick.getRawAxis(3));
        
//        lStickX = lStickX * lmult; // has no use for normal drive methods..
        lStickY = lStickY * lmult; // left motor multiplier for tank, straight drive multiplier for arcade

//        rStickX = rStickX * rmult; // rotation multiplier for tank, strafe multiplier for omni
        rStickY = rStickY * rmult; // right motor multiplier for tank

        // makes forward values the same in tank if values of sticks are in dead zone
        if (DriveType.TANK == RobotMap.DRIVE_TYPE
            && Math.abs(lStickY - rStickY) < RobotMap.DEAD_ZONE) {
            lStickY = rStickY;
        }

        // drive command that uses drive type specified in RobotMap
        //IMPORTANT FOR 2019
        drive.drive(lStickY, rStickY, lStickX, rStickX, lTwist, rTwist);
    }

    /**
     * Returns true when done.
     */
    protected boolean isFinished() {
        return done;
    }

    /**
     * Ends the drive subsystem.
     */
    protected void end() {
        drive.drive(0, 0, 0, 0, 0, 0);
    }

    /**
     * Stops movement when there is an error or change..
     */
    public void cancel() {
        done = true;

    }

    protected void interrupted() {
    }
}
