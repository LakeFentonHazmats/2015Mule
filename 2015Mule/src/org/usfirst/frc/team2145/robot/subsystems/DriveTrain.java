package org.usfirst.frc.team2145.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;

import org.usfirst.frc.team2145.robot.Robot;
import org.usfirst.frc.team2145.robot.RobotMap;
import org.usfirst.frc.team2145.robot.commands.DriveWithController;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;


public class DriveTrain extends Subsystem{
	PowerDistributionPanel pdp = new PowerDistributionPanel();
	TalonSRX frontRightWheel = new TalonSRX(1);
	TalonSRX frontLeftWheel = new TalonSRX(2);
	TalonSRX backRightWheel = new TalonSRX(3);
	TalonSRX backLeftWheel = new TalonSRX(4);
	Encoder leftEncoder = new Encoder(0,1);
	Encoder rightEncoder = new Encoder(2,3);
	Gyro gyro = new Gyro(0);
	DigitalInput button = new DigitalInput(4);
	DigitalInput limit = new DigitalInput(5);
	double current = pdp.getCurrent(1);
	double leftMotorSpeed;
	double rightMotorSpeed;
	private double gyroAngle;
	boolean limitSwitch;
	double hyp;
	double targetAngle;
	double SDGyroAngle;
	boolean limitSwitch2; //switch for 
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithController());
    	
    }
	


	public void MecanumDrive (double X,double Y,double Z) {
		   
		double forward= -Y;
		double right= X;
		double clockwise= Z;
		//Gets Directions; like from Joy Sticks.
		
		double front_left = forward + clockwise + right;
		double front_right = forward - clockwise- right;
		double rear_left = forward + clockwise - right;
		double rear_right = forward - clockwise + right;
		//Kinetic Data for Mech Wheels
		
		double max = Math.abs(front_left);
		if (Math.abs(front_right)>max) max=Math.abs(front_right);
		if (Math.abs(rear_left)>max) max= Math.abs(rear_left);
		if (Math.abs(rear_right)>max) max= Math.abs(rear_right);
		//Determines highest going Motor
		
		if (max>1)
		{front_left/=max; front_right/=max; rear_left/=max; rear_right/=max;}
		//Makes it so none can be above 1
		
		frontRightWheel.set(front_right);
		frontLeftWheel.set(front_left);
		backRightWheel.set(rear_right);
		backLeftWheel.set(rear_left);
		//Sends Data to Talons
	}
	
    public double encoderOutput(){
        double encoderOut; 
        encoderOut = ((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2);
        encoderOut = (encoderOut /(4 * Math.PI));
    	return (encoderOut);
    	
    	
    }
    public double getRotation(){
    	return gyroAngle;
    }
    public double pdpVoltage(){
    	return (current); 
    }
    public boolean getswitch(){
    	limitSwitch = button.get();
    	
    	return (limitSwitch);
    }
    
    public void encoderReset(){
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    public void gyroReset(){
    	gyro.reset();
    }
    
    
    public void triangleAuton(double x, double y){
    	hyp = Math.pow(x, 2) + Math.pow(y, 2);
    	hyp = (hyp/hyp);
    	targetAngle = Math.asin(x/hyp);
    	targetAngle = targetAngle * (180 / Math.PI);
    	if(Robot.driveTrain.getRotation() != targetAngle) {
    		if(targetAngle < gyroAngle){
    			
    		}
    	}
    }
    


}
