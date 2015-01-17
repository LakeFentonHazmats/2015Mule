package org.usfirst.frc.team2145.robot.commands;
import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithController extends Command{
	public DriveWithController() {
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
    	
    	Robot.driveTrain.robotDrive(Robot.oi.stickY(), Robot.oi.stickX());
    	SmartDashboard.putDouble("Right", Robot.driveTrain.rMotorSpeed());
    	SmartDashboard.putDouble("Left", Robot.driveTrain.lMotorSpeed());
    	SmartDashboard.putDouble("X" , Robot.oi.stickX());
    	SmartDashboard.putDouble("Y" , Robot.oi.stickY());
    	SmartDashboard.putDouble("Encoder", Robot.driveTrain.encoderOutput());
    	SmartDashboard.putDouble("Gyro", Robot.driveTrain.getRotation());
    	
    	
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
