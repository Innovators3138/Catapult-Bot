// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.*;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.LaunchCommand;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Globals;
import frc.robot.Constants;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final LauncherSubsystem launcherSubsystem = new LauncherSubsystem();

  private final LaunchCommand launcherStartCommand = new LaunchCommand(launcherSubsystem, LauncherSubsystem.Mode.FIRE);
  private final LaunchCommand launcherStopCommand = new LaunchCommand(launcherSubsystem, LauncherSubsystem.Mode.OFF);
  private final WaitCommand waitCommand = new WaitCommand(Constants.fireDelayTime);

  public class LaunchCube extends SequentialCommandGroup {
    public LaunchCube(LauncherSubsystem launcher) {
      addCommands(
        new LaunchCommand(launcherSubsystem, LauncherSubsystem.Mode.FIRE),
        new WaitCommand(Constants.fireDelayTime),
        new LaunchCommand(launcherSubsystem, LauncherSubsystem.Mode.OFF)
      );
    }
  }

  private final LaunchCube launchCube = new LaunchCube(launcherSubsystem);
  public RobotContainer() {
    configureButtonBindings();
  }

  
  private void configureButtonBindings() {
    OI oi = OI.getInstance();
    oi.launcherLaunchBtn.getButton().onTrue(launchCube);
  }
}