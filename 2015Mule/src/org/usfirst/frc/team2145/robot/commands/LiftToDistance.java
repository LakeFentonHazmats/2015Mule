package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftToDistance extends Command{

	@Override
	protected void initialize() {
		Robot.driveTrain.encoderReset();
		
	}

	@Override
	protected void execute() {
		Robot.lift.LiftToDistance();
		
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

	@Override
	protected void end() {
		
		
	}

	@Override
	protected void interrupted() {
		
		
	}

}
