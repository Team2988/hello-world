package org.usfirst.frc.team2988.robot.commands;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team2988.robot.subsystems.BoxShooterSubsystem;
import org.usfirst.frc.team2988.robot.subsystems.PneumaticSubsystem;

/**
 *
 */
public class CrateLaunchCommand extends CommandGroup {

    public CrateLaunchCommand() {
      addSequential(new PistonPushCommand());
      addSequential(new BoxShooterCommand(true));
    }

  
}
