


package org.usfirst.frc4388.robot;

import buttons.XBoxTriggerButton;
import org.usfirst.frc4388.controller.IHandController;
import org.usfirst.frc4388.controller.XboxController;
import org.usfirst.frc4388.robot.commands.*;
import org.usfirst.frc4388.robot.commands.auton.CrossTheBaseLine;
import org.usfirst.frc4388.robot.commands.auton.RightSwitchAuton;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc4388.robot.subsystems.*;
import org.usfirst.frc4388.utility.MPSoftwarePIDController.MPSoftwareTurnType;
import org.usfirst.frc4388.robot.subsystems.Drive;
import org.usfirst.frc4388.utility.MPSoftwarePIDController.MPSoftwareTurnType;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;



public class OI 
{
		private static OI instance;
		
		private XboxController m_driverXbox;
		private XboxController m_operatorXbox;

		private OI() 
		{
		  try 
		  {
			// Driver controller
			m_driverXbox = new XboxController(RobotMap.DRIVER_JOYSTICK_1_USB_ID);
			m_operatorXbox = new XboxController(RobotMap.OPERATOR_JOYSTICK_1_USB_ID);
			
	        XBoxTriggerButton CarriageIntake = new XBoxTriggerButton(m_operatorXbox, XBoxTriggerButton.LEFT_TRIGGER);
	        CarriageIntake.whenPressed(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
	        CarriageIntake.whenReleased(new IntakeSetSpeed(0.0));
	        
	        XBoxTriggerButton CarriageEject = new XBoxTriggerButton(m_operatorXbox, XBoxTriggerButton.RIGHT_TRIGGER);
	        CarriageEject.whenPressed(new IntakeSetSpeed(Carriage.CUBE_INTAKE_SPEED));
	        CarriageEject.whenReleased(new IntakeSetSpeed(0.0));
	        
	        JoystickButton climbUp = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.X_BUTTON);
	        climbUp.whenPressed(new InitiateClimber(true));
	        climbUp.whenReleased(new InitiateClimber(false));
	        
	        JoystickButton shiftUp = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.RIGHT_BUMPER_BUTTON);
	        shiftUp.whenPressed(new DriveSpeedShift(true));
	        shiftUp.whenPressed(new LEDIndicators(true));
	        
	        JoystickButton shiftDown = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.LEFT_BUMPER_BUTTON);
	        shiftDown.whenPressed(new DriveSpeedShift(false));
	        shiftDown.whenPressed(new LEDIndicators(false));
	        
	        
	        //Operator Xbox

	        JoystickButton openIntake = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.LEFT_BUMPER_BUTTON);
	        openIntake.whenPressed(new IntakePosition(true));
	        
	        JoystickButton CloseIntake = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.RIGHT_BUMPER_BUTTON);
	        CloseIntake.whenPressed(new IntakePosition(false));
	     	
	        SmartDashboard.putData("PRE GAME!!!!", new PreGame());
	       
		  } catch (Exception e) {
			  System.err.println("An error occurred in the OI constructor");
		  }
		}
		
		public static OI getInstance() {
			if(instance == null) {
				instance = new OI();
			}
			return instance;
		}

		public IHandController getDriverController() {
			return m_driverXbox;
		}

		public IHandController getOperatorController() 
		{
			return m_operatorXbox;
		}

		public Joystick getOperatorJoystick()
		{
			return m_operatorXbox.getJoyStick();
		}
	}

