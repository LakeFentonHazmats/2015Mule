package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveForward extends Command {
	 public MoveForward() {
	        // Use requires() here to declare subsystem dependencies
	        requires(Robot.driveTrain);
	    }

	    // Called just before this Command runs the first time
	    protected void initialize() {
	    	Robot.driveTrain.encoderReset();
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    /*	if(Robot.driveTrain.encoderOutput() < 500 ){
	    		Robot.driveTrain.robotDrive(-0.7, -0.15);
	    	}
	    	else{
	    		Robot.driveTrain.robotDrive(0, 0);
	    	}*/
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return false;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    	
	    }
	}


