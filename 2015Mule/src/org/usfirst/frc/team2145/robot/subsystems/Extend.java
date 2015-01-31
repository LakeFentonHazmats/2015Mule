package org.usfirst.frc.team2145.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team2145.robot.Robot;
import org.usfirst.frc.team2145.robot.RobotMap;
import org.usfirst.frc.team2145.robot.commands.ExtendToHome;

import edu.wpi.first.wpilibj.DigitalInput;

public class Extend extends Subsystem{
	Encoder ExtendEncoder = new Encoder (0,0);
	Talon ExtendMotor = new Talon (RobotMap.extendMotor); //Main Arm Motor
	Talon ExtendMotor2 = new Talon (RobotMap.extendMotor2); //Lift Motor on Arm
	DigitalInput button = new DigitalInput(6);
	
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ExtendToHome());
    }
	public void extendToDistance() {
		if (Robot.driveTrain.getswitch() == false ) {
			ExtendMotor.set(.7);	
		}
		else {
			ExtendMotor.set(0);
		}
	}
	
	/*public void up () {
		ExtendMotor2.set(.5);
	}
	*/
	
	public void back () {
		ExtendMotor.set(-.7);
	}
	public double extendEncoder(){
		return ExtendEncoder.getDistance();
	}
	
}
