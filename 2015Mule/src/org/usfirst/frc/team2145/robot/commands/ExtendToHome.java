package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class ExtendToHome extends Command{

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		requires(Robot.extend);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.extend.back();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	

}
