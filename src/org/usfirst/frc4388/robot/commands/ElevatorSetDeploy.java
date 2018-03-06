package org.usfirst.frc4388.robot.commands;

import org.usfirst.frc4388.robot.Robot;
import org.usfirst.frc4388.robot.commands.IntakeSetPosition.IntakePosition;
import org.usfirst.frc4388.robot.subsystems.ElevatorAuton;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorSetDeploy extends Command {

	private IntakePosition position;
	private double timeout;
	private double secondTimeout;
	private boolean isDeploy = false;
	private boolean secondTimerSet = false;
	
	// Constructor with speed
    public ElevatorSetDeploy(double timeout, double secondTimeout, IntakePosition position) {
    	this.position = position;
    	this.timeout = timeout;
    	this.secondTimeout = secondTimeout;
   }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isDeploy = false;
    	secondTimerSet = false;
    	if (position == IntakePosition.CUBE_INTAKE) {
        	this.setTimeout(timeout);
    		Robot.elevatorAuton.setRaiseSpeed(ElevatorAuton.LOWER_ELEVATOR_SPEED);
    		isDeploy = true;
    	}
    	else if (position == IntakePosition.CUBE_DEPLOY) {
        	this.setTimeout(timeout);
    		Robot.elevatorAuton.setRaiseSpeed(ElevatorAuton.RAISE_ELEVATOR_SPEED);
    		isDeploy = true;
    	}
    	else {
        	this.setTimeout(0);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (isDeploy == false) {
        	return true;
        }
        
        if (isTimedOut()) {
        	return true;
        }
         
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (isDeploy == true) {
    		Robot.elevatorAuton.setRaiseSpeed(0);
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
