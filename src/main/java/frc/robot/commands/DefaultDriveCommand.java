// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.mappings.AxisMapping;
import frc.robot.subsystems.DriveSubsystem;

/** An example command that uses an example subsystem. */
public class DefaultDriveCommand extends CommandBase
{
    private final DriveSubsystem subsystem;
    private final AxisMapping leftDriveAxis;
    private final AxisMapping rightDriveAxis;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public DefaultDriveCommand(DriveSubsystem subsystem,
                               AxisMapping leftDriveAxis, AxisMapping rightDriveAxis)
    {
        this.subsystem = subsystem;
        this.leftDriveAxis = leftDriveAxis;
        this.rightDriveAxis = rightDriveAxis;
        addRequirements(subsystem);
    }
    
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
    
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        subsystem.drive(leftDriveAxis.getValue(), rightDriveAxis.getValue());
    }
    
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
    
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
