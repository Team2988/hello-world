package org.usfirst.frc.team2988.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Class AutonomousCommands.
 */
public class AutonomousCommands extends CommandGroup {

	/**
	 * Instantiates new autonomous commands.
	 * 
	 * @param side
	 */
	public AutonomousCommands(String gamedata, int location) {
		// L/R--switch, L/R--scale -xL
		/*
		 * switch (gamedata.charAt(0)) { // switch statement for the middle.
		 * case 'L': //test if(location == 1) { addSequential(new
		 * AutonomousDrive(0.15, 0.7, 4.0)); // backwards addSequential(new
		 * BoxShooterCommand(true)); }
		 * 
		 * if(location == 2) { addSequential(new AutonomousDrive(.3, 0.7, 4.0));
		 * // slight turn left(backward) while straight addSequential(new
		 * BoxShooterCommand(true)); } break;
		 * 
		 * case 'R': // test if(location == 3) { addSequential(new
		 * AutonomousDrive(0.15, -0.7, 4.0)); // backwards addSequential(new
		 * BoxShooterCommand(true)); }
		 * 
		 * if(location == 2) { addSequential(new AutonomousDrive(-0.3, -0.7,
		 * 4.0)); // slight turn right(backward) while straight
		 * addSequential(new BoxShooterCommand(true)); } break; }
		 */
		// rotation(turn= -==left, +== right), vertical(straight, backward),
		// time of command
		char switchLocation = gamedata.charAt(0); // L or R

		addSequential(new AutonomousDrive(0.10, -0.7, 3.5));// forward
		//addSequential(new AutonomousDrive(0, 0, 0.5));
	//	turns right while going backwards
	/**  doubled time for turn*/
	//	addSequential(new AutonomousDrive(0.76, 0, 3.0));
	//  turns left while going backwards.
		//addSequential(new AutonomousDrive(-0.79, 0, 3.0));
		if (switchLocation == 'L' && location == 1) {
			addSequential(new AutonomousDrive(.76, 0, 3.0));// left
			addSequential(new BoxShooterCommand(true));
		} else if (switchLocation == 'R' && location == 3) {
			addSequential(new AutonomousDrive(-.76, 0, 3.0));// right
			addSequential(new BoxShooterCommand(true));
		} else if (switchLocation == 'L' && location == 3) {
			addSequential(new AutonomousDrive(-.76, 0, 3.0));
			// do not add a shoot command for this command just have it turn to get ready.
		} else if (switchLocation == 'R' && location == 1){
			addSequential(new AutonomousDrive(0.76, 0, 3.0));
			// do not add a shoot command
		}
		
		// addSequential(new BoxShooterCommand(true));
	}
}
