
package org.usfirst.frc.team2988.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import org.usfirst.frc.team2988.robot.commands.AutonomousCommands;
//import org.usfirst.frc.team2988.robot.commands.AutonomousCommands;
import org.usfirst.frc.team2988.robot.commands.CommandBase;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public NetworkTable nt;
	public static CommandBase commandBase;
	Robot robot;
	private int botLoc;

	public static Command autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// nt.getSubTable("SmartDashboard");
		commandBase = new CommandBase();
		robot = this;

		// starts video capture for both cameras
		CameraServer server = CameraServer.getInstance();
		//server.startAutomaticCapture("cam1", 1);
		server.startAutomaticCapture("cam0", 0);

		//int location = DriverStation.getInstance().getLocation();
		//String gamedata = DriverStation.getInstance().getGameSpecificMessage();
		
		//Alliance Color = DriverStation.getInstance().getAlliance();

		botLoc = 3; // location of bot
		
		// creates an auto chooser in smart dashboard
		autoChooser = new SendableChooser<>();
		//autoChooser.addObject("Left", new AutonomousCommand());
		//autoChooser.addObject("Right", );
		// AutonomousCommands(g,location));
		// autoChooser.addDefault("Straight forward auto", new AutonomousCommands("", 0));
		//SmartDashboard.putData("Autonomous chooser", autoChooser);

		SmartDashboard.putData(CommandBase.getDriveSubsystem());
		SmartDashboard.putData(CommandBase.getCrateSubsystem());
		// SmartDashboard.putData(CommandBase.getScalerSubsystem());
	}

	public void disabledInit() {
		CommandBase.getDriveCommand().cancel();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		CommandBase.getDriveSubsystem().reset();
		String gamedata = DriverStation.getInstance().getGameSpecificMessage();
		autonomousCommand = new AutonomousCommands(gamedata, botLoc);
		
		//autonomousCommand = autoChooser.getSelected();

		// autonomousCommand = new AutonomousCommands();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	public void teleopInit() {
		CommandBase.getDriveSubsystem().reset();

		// cancels autonomous
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		CommandBase.getDriveCommand().start();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
	}

	public void testInit() {
	}

	public void log() {

		CommandBase.getDriveSubsystem().log();
		CommandBase.getCrateSubsystem().log();
	}

}