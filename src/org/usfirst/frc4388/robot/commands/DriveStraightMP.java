// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4388.robot.commands;

import org.usfirst.frc4388.robot.subsystems.Drive.DriveControlMode;
import org.usfirst.frc4388.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class DriveStraightMP extends Command {
    private double m_distanceInches;
    private double m_maxVelocityInchesPerSec;
    private boolean m_useGyroLock;
    private boolean m_useAbsolute;
    private double m_desiredAbsoluteAngle;
 
    public DriveStraightMP(double distanceInches, double maxVelocityInchesPerSec, boolean useGyroLock, boolean useAbsolute, double desiredAbsoluteAngle) {
        requires(Robot.drive);
        m_distanceInches = distanceInches;
        m_maxVelocityInchesPerSec = maxVelocityInchesPerSec;
        m_useGyroLock = useGyroLock;
        m_useAbsolute = useAbsolute;
        m_desiredAbsoluteAngle = desiredAbsoluteAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.drive.setStraightMP(m_distanceInches, m_maxVelocityInchesPerSec, m_useGyroLock, m_useAbsolute, m_desiredAbsoluteAngle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return Robot.drive.isFinished(); 
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.drive.setControlMode(DriveControlMode.JOYSTICK);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
