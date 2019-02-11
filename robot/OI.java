package org.usfirst.frc.team2988.robot;

import org.usfirst.frc.team2988.robot.commands.CommandBase;
//import org.usfirst.frc.team2988.robot.commands.CrateLaunchCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OI extends CommandGroup {
	public Joystick leftStick;
	public Joystick rightStick;

	public OI() {
		leftStick = new Joystick(RobotMap.LEFT_STICK);
		rightStick = new Joystick(RobotMap.RIGHT_STICK);

		// angles box shooter
		Button crateAngleButton = new JoystickButton(leftStick, 1);
		crateAngleButton.toggleWhenPressed(CommandBase.getCrateAngleCommand());

		// arm wheels suck in crate
		Button crateSuckButton = new JoystickButton(rightStick, 1);
		crateSuckButton.whileHeld(CommandBase.getCrateSuckCommand());

		// arm wheels spit out crate
		Button crateSpitButton = new JoystickButton(rightStick, 5);
		crateSpitButton.whileHeld(CommandBase.getCrateSpitCommand());

		// arms rotate inward(grab crate)
		Button crateLArmInButton = new JoystickButton(rightStick, 7);
		crateLArmInButton.whileHeld(CommandBase.getLArmsInCommand());

		// arms rotate outward(push crate)
		Button crateLArmOutButton = new JoystickButton(rightStick, 6);
		crateLArmOutButton.whileHeld(CommandBase.getLArmsOutCommand());
	
		Button crateRArmInButton = new JoystickButton(rightStick, 10);
		crateRArmInButton.whileHeld(CommandBase.getRArmsInCommand());

		Button crateRArmOutButton = new JoystickButton(rightStick, 11);
		crateRArmOutButton.whileHeld(CommandBase.getRArmsOutCommand());
		
		Button crateArmInButton = new JoystickButton(rightStick, 2);
		crateArmInButton.whileHeld(CommandBase.getArmsInCommand());
		
		Button crateArmOutButton = new JoystickButton(rightStick, 3);
		crateArmOutButton.whileHeld(CommandBase.getArmsOutCommand());
		
		
		// piston pushes crate into box shooter
		// Button crateLaunchButton = new JoystickButton(rightStick, 11);
		// crateLaunchButton.whileHeld(CommandBase.getCrateLaunchCommand()); //
		// test
		// crateLaunchButton.toggleWhenPressed(new CrateLaunchCommand());

		// Button pistonPushButton = new JoystickButton(rightStick, 8);
		// pistonPushButton.toggleWhenPressed(CommandBase.getPistonPushCommand());

		Button boxShooterButton = new JoystickButton(rightStick, 4);
		boxShooterButton.whileHeld(CommandBase.getBoxShooterCommand());

		// scaling
		Button winchButton = new JoystickButton(leftStick, 3);
		winchButton.whileHeld(CommandBase.getScalerCommand());
	}
}
