package org.usfirst.frc4388.robot.commands.auton;


import org.usfirst.frc4388.robot.commands.DriveGyroReset;
import org.usfirst.frc4388.robot.commands.DriveSpeedShift;
import org.usfirst.frc4388.robot.commands.DriveStraightBasic;

import org.usfirst.frc4388.robot.commands.DriveTurnBasic;
import org.usfirst.frc4388.robot.commands.ElevatorBasic;

import org.usfirst.frc4388.robot.commands.IntakePosition;
import org.usfirst.frc4388.robot.commands.IntakeSetSpeed;
import org.usfirst.frc4388.robot.subsystems.Carriage;

import org.usfirst.frc4388.utility.MPSoftwarePIDController.MPSoftwareTurnType;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Cube2Right extends CommandGroup {
    
    public Cube2Right() {
    	addSequential(new DriveGyroReset());
    	addSequential(new DriveSpeedShift(true));
    	addSequential(new IntakePosition(true));
    	
    	
    	addSequential(new DriveStraightBasic(-140, 50, true, true, 0));
    	addSequential(new ElevatorBasic(30));
    	addSequential(new WaitCommand(.2));
    	addSequential(new DriveTurnBasic(true, 87, 150, MPSoftwareTurnType.TANK));
    	addSequential(new ElevatorBasic(30));
    	addSequential(new DriveStraightBasic(8, 50, true, true, 0));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	//addSequential(new WaitCommand(.1));
    	addSequential(new IntakePosition(false));
    	addSequential(new WaitCommand(.4));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	addSequential(new DriveStraightBasic(-10, 50, true, true, 0));
    	addSequential(new DriveTurnBasic(true, 40, 150, MPSoftwareTurnType.TANK));
    	addSequential(new DriveStraightBasic(-30, 50, true, true, 0));
    	addSequential(new DriveTurnBasic(true, -10, 150, MPSoftwareTurnType.TANK));
     	addSequential(new IntakeSetSpeed(Carriage.CUBE_INTAKE_SPEED));
    	addSequential(new DriveStraightBasic(30, 50, true, true, 0));
    	addSequential(new IntakePosition(true));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	addSequential(new DriveStraightBasic(-30, 50, true, true, 0));
    	addSequential(new DriveTurnBasic(true, 30, 150, MPSoftwareTurnType.TANK));
    	addSequential(new ElevatorBasic(70));
    	addSequential(new DriveStraightBasic(-20, 20, true, true, 0));
    	addSequential(new DriveTurnBasic(true, 87, 150, MPSoftwareTurnType.TANK));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	//addSequential(new WaitCommand(.1));
    	addSequential(new IntakePosition(false));
    	addSequential(new WaitCommand(.5));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	
    	
    	
    	addSequential(new DriveSpeedShift(false));

    	      
    }
}
