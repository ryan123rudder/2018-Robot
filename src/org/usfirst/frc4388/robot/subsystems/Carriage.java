
// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4388.robot.subsystems;

import org.usfirst.frc4388.robot.RobotMap;
import org.usfirst.frc4388.robot.commands.*;
import org.usfirst.frc4388.robot.subsystems.Drive.DriveControlMode;
import org.usfirst.frc4388.utility.CANTalonEncoder;
import org.usfirst.frc4388.utility.ControlLoopable;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4388.robot.OI;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;



/**
 *
 */
public class Carriage extends Subsystem {

	private WPI_TalonSRX carriageLeft;
	private WPI_TalonSRX carriageRight;
	public static enum CarriageControlMode { JOYSTICK, MP_STRAIGHT, HOLD, MANUAL};
	public static final double CUBE_INTAKE_SPEED = 0.40;
	public static final double CUBE_EJECT_SPEED = -0.8;
	public static final double CUBE_STOP_SPEED = 0;
	/////^^^^^^^^^ replace this line with the modes we need
	
	
	private boolean isFinished;
	//private CarriageControlMode controlMode = CarriageControlMode.JOYSTICK;
	
	
	
	
	public Carriage() {
		try {
			carriageLeft = new WPI_TalonSRX(RobotMap.CARRIAGE_LEFT_MOTOR_CAN_ID);
			carriageRight = new WPI_TalonSRX(RobotMap.CARRIAGE_RIGHT_MOTOR_CAN_ID);
			carriageRight.setInverted(true);
			carriageLeft.setInverted(true);
			//\][carriageLeft.set(CurrentLimit, value);
			
    carriageRight.set(ControlMode.Follower, carriageLeft.getDeviceID());
		}
		catch (Exception e) {
			System.err.println("An error occurred in the Carriage constructor");
			
			
		}
    }
	
		public void setWheelSpeed(double speed) {
			carriageLeft.set(-speed);
    }

    	
    	
    	


      //  public synchronized void setControlMode(CarriageControlMode controlMode) {
     	//	this.controlMode = controlMode;
    	//	if (controlMode == CarriageControlMode.JOYSTICK) {
    			
    		//	carriageLeft.set(ControlMode.PercentOutput, 0);	//TODO URGENT: make sure not called when robot moving
    		//	carriageRight.set(ControlMode.PercentOutput, 0);	
    	//	}
 //   }

    @Override
    public void periodic() {
    	
    }
    	public void initDefaultCommand() {
    }
}





