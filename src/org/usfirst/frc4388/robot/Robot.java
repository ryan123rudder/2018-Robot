
// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4388.robot;

//import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.usfirst.frc4388.controller.Robot.OperationMode;
import org.usfirst.frc4388.robot.commands.*;
import org.usfirst.frc4388.robot.commands.auton.*;
import org.usfirst.frc4388.robot.OI;
import org.usfirst.frc4388.robot.subsystems.*;
import org.usfirst.frc4388.utility.ControlLooper;
import org.usfirst.frc4388.robot.subsystems.Drive;
import org.usfirst.frc4388.robot.subsystems.Carriage;
import org.usfirst.frc4388.robot.subsystems.LED;
import org.usfirst.frc4388.robot.subsystems.Drive.DriveControlMode;;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends IterativeRobot 
{

	public static OI oi;
	
	public static final Drive drive = new Drive();

	//public static final Elevator elevator = new Elevator();
    public static final Carriage carriage = new Carriage();
    public static final Elevator elevator = new Elevator();
    
    
    public static final LED led = new LED();

    public static final Climber climber = new Climber();
    public static final Pnumatics pnumatics = new Pnumatics();
    //public static FlashyBlinky flashyBlinky;
    //public static Sensors sensors;

	public static final long periodMS = 10;
	public static final ControlLooper controlLoop = new ControlLooper("Main control loop", periodMS);
	//public static final PowerDistributionPanel pdp = new PowerDistributionPanel();

	//public static final String ElevatorAuton = null;


	public static enum OperationMode { TEST, COMPETITION };
	public static OperationMode operationMode = OperationMode.TEST;

	private SendableChooser<OperationMode> operationModeChooser;
	private SendableChooser<Command> RRautonTaskChooser;
	private SendableChooser<Command> RLautonTaskChooser;
	private SendableChooser<Command> LRautonTaskChooser;
	private SendableChooser<Command> LLautonTaskChooser;

    private Command RRautonomousCommand;
    private Command RLautonomousCommand;
    private Command LRautonomousCommand;
    private Command LLautonomousCommand;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
    	//Printing game data to riolog
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	System.out.println(gameData);
    	CameraServer.getInstance().startAutomaticCapture();
    	CameraServer.getInstance().putVideo("res", 640, 480);
    	
      try {
    	//drive = new Drive();
    	//controlLoop = new ControlLooper("Main control loop", periodMS);
		oi = OI.getInstance();
		//camera.initialize();
		
    	controlLoop.addLoopable(drive);
    	controlLoop.addLoopable(elevator);
  
//		Waypoint[] points = new Waypoint[] {
//                new Waypoint(0, 0, 0),
//                new Waypoint(-95, -9, Pathfinder.d2r(-27))
//        };
//
//        PathGenerator boilerPath = new PathGenerator(points, 0.01, 120, 200.0, 700.0);			

        operationModeChooser = new SendableChooser<OperationMode>();
	    operationModeChooser.addDefault("Test", OperationMode.TEST);
	    operationModeChooser.addObject("Competition", OperationMode.COMPETITION);
		SmartDashboard.putData("Operation Mode", operationModeChooser);
		
		
		
		
		
		RRautonTaskChooser = new SendableChooser<Command>();
		
		RRautonTaskChooser.addDefault("Choose RR Program", new CrossTheBaseLine());
		
		RRautonTaskChooser.addObject("1", new CrossTheBaseLine());
		RRautonTaskChooser.addObject("Left to Right Switch", new LeftStartRightScore());
		
		RRautonTaskChooser.addObject("2", new CrossTheBaseLine());
		RRautonTaskChooser.addObject("Center to Left Switch", new CenterLeft());
		RRautonTaskChooser.addObject("Center to Right Switch", new CenterRight());
		
		RRautonTaskChooser.addObject("3", new CrossTheBaseLine());
		RRautonTaskChooser.addObject("Right to Right Switch", new RightSwitchAuton());
		RRautonTaskChooser.addObject("Right to Left Switch", new RightStartLeftScore());

		
		SmartDashboard.putData("RRAuton Task", RRautonTaskChooser);
		
		
		
		
		
		RLautonTaskChooser = new SendableChooser<Command>();
		
		RLautonTaskChooser.addDefault("Choose RL Program", new CrossTheBaseLine());
		
		RLautonTaskChooser.addObject("1", new CrossTheBaseLine());
		RLautonTaskChooser.addObject("Left to Right Switch", new LeftStartRightScore());
		
		RLautonTaskChooser.addObject("2", new CrossTheBaseLine());
		RLautonTaskChooser.addObject("Center to Left Switch", new CenterLeft());
		RLautonTaskChooser.addObject("Center to Right Switch", new CenterRight());
		
		RLautonTaskChooser.addObject("3", new CrossTheBaseLine());
		RLautonTaskChooser.addObject("Right to Right Switch", new RightSwitchAuton());
		RLautonTaskChooser.addObject("Right to Left Switch", new RightStartLeftScore());

		
		SmartDashboard.putData("RLAuton Task", RLautonTaskChooser);
		
		
		
		
		
		
		LLautonTaskChooser = new SendableChooser<Command>();
		
		LLautonTaskChooser.addDefault("Choose LL Program", new CrossTheBaseLine());
		
		LLautonTaskChooser.addObject("1", new CrossTheBaseLine());
		LLautonTaskChooser.addObject("Left to Right Switch", new LeftStartRightScore());
		
		LLautonTaskChooser.addObject("2", new CrossTheBaseLine());
		LLautonTaskChooser.addObject("Center to Left Switch", new CenterLeft());
		LLautonTaskChooser.addObject("Center to Right Switch", new CenterRight());
		
		LLautonTaskChooser.addObject("3", new CrossTheBaseLine());
		LLautonTaskChooser.addObject("Right to Right Switch", new RightSwitchAuton());
		LLautonTaskChooser.addObject("Right to Left Switch", new RightStartLeftScore());

		
		SmartDashboard.putData("LLAuton Task", LLautonTaskChooser);
		
		
		
		
		
		LRautonTaskChooser = new SendableChooser<Command>();
		
		LRautonTaskChooser.addDefault("Choose LR Program", new CrossTheBaseLine());
		
		LRautonTaskChooser.addObject("1", new CrossTheBaseLine());
		LRautonTaskChooser.addObject("Left to Right Switch", new LeftStartRightScore());
		
		LRautonTaskChooser.addObject("2", new CrossTheBaseLine());
		LRautonTaskChooser.addObject("Center to Left Switch", new CenterLeft());
		LRautonTaskChooser.addObject("Center to Right Switch", new CenterRight());
		
		LRautonTaskChooser.addObject("3", new CrossTheBaseLine());
		LRautonTaskChooser.addObject("Right to Right Switch", new RightSwitchAuton());
		LRautonTaskChooser.addObject("Right to Left Switch", new RightStartLeftScore());

		
		SmartDashboard.putData("LRAuton Task", LRautonTaskChooser);




		
		//ledLights.setAllLightsOn(false);
      } catch (Exception e) {
    		System.err.println("An error occurred in robotInit()");
      }
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		updateStatus();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {    	
    	updateChoosers();
    	
        // Schedule the autonomous command (example)
    	controlLoop.start();
    	drive.endGyroCalibration();
    	drive.resetEncoders();
    	//elevator.resetElevatorEncoder();
    	drive.resetGyro();
    	drive.setIsRed(getAlliance().equals(Alliance.Red));
        
        
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
                {
		  if(gameData.charAt(0) == 'L')
		  {
			  if(gameData.charAt(1) == 'L')
			  {
				  if (LLautonomousCommand != null) LLautonomousCommand.start();
			  } else {
				  if (LRautonomousCommand != null) LRautonomousCommand.start();
			  }
	                }
		  } else {
			  if(gameData.charAt(1) == 'L')
			  {
				  if (RLautonomousCommand != null) RLautonomousCommand.start();
			  } else {
				  if (RRautonomousCommand != null) RRautonomousCommand.start();
			  }
	                }
			
		  }
                
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        //Robot.elevator.setControlMode(DriveControlMode.RAW);
		updateStatus();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (RRautonomousCommand != null) RRautonomousCommand.cancel();
        if (RLautonomousCommand != null) RLautonomousCommand.cancel();
        if (LRautonomousCommand != null) LRautonomousCommand.cancel();
        if (LLautonomousCommand != null) LLautonomousCommand.cancel();
        //MotionProfileCache.getInstance().release();
    	updateChoosers();
        controlLoop.start();
    	drive.resetEncoders();
    	drive.endGyroCalibration();
    	//shooter.setStage1Speed(0);
    	//shooter.setStage2Speed(0);
    	//shooterFeed.setSpeed(0);
    	//zarkerFeed.setSpeed(0);
    	//shooter.setHopperPosition(HopperState.CLOSE);
    	//Robot.elevator.setControlMode(DriveControlMode.JOYSTICK);
        updateStatus();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
		updateStatus();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
		updateStatus();
   }
    
    private void updateChoosers() {
		operationMode = (OperationMode)operationModeChooser.getSelected();
		RRautonomousCommand = (Command)RRautonTaskChooser.getSelected();
		RLautonomousCommand = (Command)RLautonTaskChooser.getSelected();
		LRautonomousCommand = (Command)LRautonTaskChooser.getSelected();
		LLautonomousCommand = (Command)LLautonTaskChooser.getSelected();
    }
    
    public Alliance getAlliance() {
    	return m_ds.getAlliance();
    }
    
    public void updateStatus() {
    	drive.updateStatus(operationMode);
    	elevator.updateStatus(operationMode);
    	//carriage.updateStatus(operationMode);
    	//shooter.updateStatus(operationMode);
    	//shooterFeed.updateStatus(operationMode);
    	//zarkerFeed.updateStatus(operationMode);
    	//camera.updateStatus(operationMode);
   }

}

