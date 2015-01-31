package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.Robot;
import org.usfirst.frc.team2145.robot.RobotMap;
//import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team2145.robot.commands.LiftToHome;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

public class Lift extends Subsystem{
	
	Encoder LiftEncoder = new Encoder(0,0);
	Talon LiftMotor = new Talon (RobotMap.liftMotor);
	//DigitalInput limit = new DigitalInput(0);

	public void initDefaultCommand(){
		setDefaultCommand(new LiftToHome());
	}
	
	public void LiftToHome() {
		if (Robot.driveTrain.getswitch() == false) {
			LiftMotor.set(-0.7);
		}
		else{
			LiftMotor.set(0);
		}
			
	}
	
	public void LiftToDistance() {
		if (LiftEncoder() < 300 ){
			LiftMotor.set(0.7);
		}
		else {
			LiftMotor.set(0);
			
		}
	}

	public double LiftEncoder() {
		// TODO Auto-generated method stub
		return LiftEncoder.getDistance();
	}
	
	
}
