package org.usfirst.frc.team2145.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team2145.robot.RobotMap;
import org.usfirst.frc.team2145.robot.commands.DriveWithController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;


public class DriveTrain extends Subsystem{
	Talon leftMotor = new Talon(RobotMap.leftMotor);
	Talon rightMotor = new Talon(RobotMap.rightMotor);
	Encoder leftEncoder = new Encoder(0,1);
	Encoder rightEncoder = new Encoder(2,3);
	Gyro gyro = new Gyro(0);
	DigitalInput button = new DigitalInput(4);
	

	double leftMotorSpeed;
	double rightMotorSpeed;
	private double gyroAngle;
	boolean limitSwitch;
	
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithController());
    	
    }
	


	public void robotDrive(double FWD,double RCW){
    	double max = Math.abs(FWD);
    	if (Math.abs(RCW)>max){
    		max = Math.abs(RCW);
    	}
    	double sum = FWD+RCW;
    	double diff = FWD-RCW;
    	if(FWD>=0){
    		if(RCW>=0){
    			leftMotorSpeed = max;
    			rightMotorSpeed = diff;
    		}
    		else{
    			leftMotorSpeed = sum;
    			rightMotorSpeed = max;
    		}
    		
    	}
    	else{
    		leftMotorSpeed = -max;
    		rightMotorSpeed = diff;
    	}
    	
    	double maximum = Math.abs(leftMotorSpeed);

    	if(Math.abs(rightMotorSpeed)>maximum){
    		maximum = Math.abs(rightMotorSpeed);
    	}
    	if(maximum>1){
    		leftMotorSpeed/=maximum;
    		rightMotorSpeed/=maximum;
    	}
    
    	leftMotor.set(leftMotorSpeed);
    	rightMotor.set(-rightMotorSpeed);
    	
    }
    
    
    public double lMotorSpeed(){
    	return leftMotor.get();
    }
    public double rMotorSpeed(){
    	return rightMotor.get();
    }
    public double encoderOutput(){
    	return ((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2);
    	
    	
    }
    public double getRotation(){

    	if (gyro.getAngle() > 360){
    		gyro.reset();
    	}
    	else{
    		if (gyro.getAngle() < -360){
        		gyro.reset();
    		}

    	}
    	gyroAngle = gyro.getAngle();
    	gyroAngle = gyro.getAngle() * 0.5;
    	
    	return gyroAngle;
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
    public void gyroDivision(){
    	
    }
    
    


}
