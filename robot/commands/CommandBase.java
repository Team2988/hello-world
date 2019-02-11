package org.usfirst.frc.team2988.robot.commands;

import org.usfirst.frc.team2988.robot.OI;

import org.usfirst.frc.team2988.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team2988.robot.subsystems.BoxShooterSubsystem;
import org.usfirst.frc.team2988.robot.subsystems.CrateSubsystem;
import org.usfirst.frc.team2988.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team2988.robot.subsystems.PneumaticSubsystem;
import org.usfirst.frc.team2988.robot.subsystems.ScalerSubsystem;

import edu.wpi.first.wpilibj.Joystick;

public class CommandBase {
    private static OI oi;
    private static DriveSubsystem driveSubsystem;
    private static CrateSubsystem crateSubsystem;
    private static ScalerSubsystem scalerSubsystem;

    private static ArmSubsystem armSubsystem;
    private static PneumaticSubsystem pneumaticSubsystem;
    private static BoxShooterSubsystem boxShooterSubsystem;
    private static BoxShooterCommand boxShooterCommand;
    private static PistonPushCommand pistonPushCommand;
    
    
    private static DriveCommand driveCommand;

    private static CrateAngleCommand crateAngleCommand;

    private static CrateLaunchCommand crateLaunchCommand;

    private static CrateSuckCommand crateSuckCommand;
    private static CrateSpitCommand crateSpitCommand;

    private static LArmsInCommand LarmsInCommand;
    private static LArmsOutCommand LarmsOutCommand;
    private static RArmsInCommand RarmsInCommand;
    private static RArmsOutCommand RarmsOutCommand;
    private static ArmsInCommand armsInCommand;
    private static ArmsOutCommand armsOutCommand;
    
    private static ScalerCommand winchCommand;

    /**
     * Initializes all the classes that will be used.
     * Subsystems must be initialized before commands because of the requires in each command.
     */
    public CommandBase() {
        crateSubsystem = new CrateSubsystem();
        crateSuckCommand = new CrateSuckCommand();
        crateSpitCommand = new CrateSpitCommand();

        armSubsystem = new ArmSubsystem();
        LarmsInCommand = new LArmsInCommand();
        LarmsOutCommand = new LArmsOutCommand();
        RarmsInCommand = new RArmsInCommand();
        RarmsOutCommand = new RArmsOutCommand();
        armsInCommand = new ArmsInCommand();
        armsOutCommand = new ArmsOutCommand();
        
        pneumaticSubsystem = new PneumaticSubsystem();
        crateAngleCommand = new CrateAngleCommand();

        boxShooterSubsystem = new BoxShooterSubsystem();
        boxShooterCommand = new BoxShooterCommand();
        pistonPushCommand = new PistonPushCommand();
        crateLaunchCommand = new CrateLaunchCommand();

        scalerSubsystem = new ScalerSubsystem();
        winchCommand = new ScalerCommand();
        
        oi = new OI();
        driveSubsystem = new DriveSubsystem();
        driveCommand = new DriveCommand();
    }

    public static OI oiGetter() {
        return oi;
    }

    public static Joystick leftStickGetter() {
        return oi.leftStick;
    }

    public static Joystick rightStickGetter() {
        return oi.rightStick;
    }

    public static DriveSubsystem getDriveSubsystem() {
        return driveSubsystem;
    }

    public static CrateSubsystem getCrateSubsystem() {
        return crateSubsystem;
    }

    public static ScalerSubsystem getScalerSubsystem() {
        return scalerSubsystem;
    }

    public static PistonPushCommand getPistonPushCommand() {
        return pistonPushCommand;
    }
    
    public static BoxShooterCommand getBoxShooterCommand() {
        return boxShooterCommand;
    }
    
    public static ArmSubsystem getArmSubsystem() {
        return armSubsystem;
    }

    public static PneumaticSubsystem getPneumaticSubsystem() {
        return pneumaticSubsystem;
    }

    public static BoxShooterSubsystem getBoxShooterSubsystem() {
        return boxShooterSubsystem;
    }

    public static CrateSpitCommand getCrateSpitCommand() {
        return crateSpitCommand;
    }

    public static CrateLaunchCommand getCrateLaunchCommand() {
        return crateLaunchCommand;
    }

    public static CrateAngleCommand getCrateAngleCommand() {
        return crateAngleCommand;
    }

    public static CrateSuckCommand getCrateSuckCommand() {
        return crateSuckCommand;
    }

    public static LArmsInCommand getLArmsInCommand() {
        return LarmsInCommand;
    }

    public static LArmsOutCommand getLArmsOutCommand() {
        return LarmsOutCommand;
    }
    public static RArmsInCommand getRArmsInCommand() {
        return RarmsInCommand;
    }

    public static RArmsOutCommand getRArmsOutCommand() {
        return RarmsOutCommand;
    }
    public static ArmsInCommand getArmsInCommand() {
        return armsInCommand;
    }
    public static ArmsOutCommand getArmsOutCommand() {
    	return armsOutCommand;
    }
//changed from getCrateArmsCommand etc
    public static ScalerCommand getScalerCommand() {
        return winchCommand;
    }

    public static DriveCommand getDriveCommand() {
        return driveCommand;
    }
}
