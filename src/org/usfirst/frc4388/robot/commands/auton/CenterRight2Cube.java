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

public class CenterRight2Cube extends CommandGroup {
    
    public CenterRight2Cube() 
    {
    	addSequential(new DriveGyroReset());
    	addSequential(new IntakePosition(true));
    	addSequential(new DriveSpeedShift(true));
    	
    	addSequential(new DriveStraightBasic(-15, 30, true, true, 0));
    	addSequential(new DriveTurnBasic(true, -115, 150, MPSoftwareTurnType.TANK));
    	addSequential(new WaitCommand(.2));
    	addSequential(new DriveStraightBasic(80, 45, true, true, 0));
    	addSequential(new ElevatorBasic(25));
    	addSequential(new DriveTurnBasic(true, -35, 150, MPSoftwareTurnType.TANK));
    	addSequential(new DriveStraightBasic(15, 45, true, true, 0));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	//addSequential(new WaitCommand(.1));
    	addSequential(new IntakePosition(false));
    	addSequential(new WaitCommand(.2));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	addSequential(new DriveStraightBasic(-25, 45, true, true, 0));
      	addSequential(new ElevatorBasic(10));
    	addSequential(new WaitCommand(.2));
      	addSequential(new ElevatorBasic(2));
      	addSequential(new DriveTurnBasic(true, 90, 150, MPSoftwareTurnType.TANK));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_INTAKE_SPEED));
    	addSequential(new DriveStraightBasic(20, 45, true, true, 0));
    	addSequential(new IntakePosition(true));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	addSequential(new DriveStraightBasic(-20, 45, true, true, 0));
    	
    	addSequential(new ElevatorBasic(25));
      	addSequential(new DriveTurnBasic(true, -90, 150, MPSoftwareTurnType.TANK));
    	addSequential(new DriveStraightBasic(10, 45, true, true, 0));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	//addSequential(new WaitCommand(.1));
    	addSequential(new IntakePosition(false));
    	addSequential(new WaitCommand(.2));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	addSequential(new DriveStraightBasic(-20, 45, true, true, 0));
    	
    	addSequential(new DriveSpeedShift(false));
    	
    }
}
