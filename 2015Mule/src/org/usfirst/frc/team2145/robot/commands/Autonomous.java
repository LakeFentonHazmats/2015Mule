package org.usfirst.frc.team2145.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2145.robot.Robot;

/**
 *
 */
public class Autonomous extends Command {
	
    public Autonomous() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.encoderReset();
    	Robot.driveTrain.gyroReset();
    }

    // Called repeatedly when this Command is scheduled to run
    @SuppressWarnings("deprecation")
	protected void execute() {
    	if (Robot.driveTrain.getswitch() == false) {
    		Robot.driveTrain.MecanumDrive(0, 0, 0);
    	}
    	else{
        	if (Robot.driveTrain.encoderOutput() <300) {
        		Robot.driveTrain.MecanumDrive(0, 0.5, 0);
        	}
        	else { 
        		if (Robot.driveTrain.getRotation() >-90) {
        			Robot.driveTrain.MecanumDrive(0, 0.5, 0);
        			}
        		else { Robot.driveTrain.MecanumDrive(0, 0.5, 0);
        			
        			}
        		}
        	SmartDashboard.putDouble("Encoder", Robot.driveTrain.encoderOutput());
        	SmartDashboard.putDouble("Gyro", Robot.driveTrain.getRotation());

    	}
    	
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
