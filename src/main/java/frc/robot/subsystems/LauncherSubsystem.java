// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Globals;

public class LauncherSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final Compressor pneumaticControl = new Compressor(Constants.pneumaticControlCanID, PneumaticsModuleType.CTREPCM);
  final private Solenoid launcherCylinder = new Solenoid(Constants.pneumaticControlCanID, PneumaticsModuleType.CTREPCM, Constants.launcherSolenoidChannel);

  public enum Mode {
    FIRE,
    OFF
  }

  public LauncherSubsystem() {
  }

  public void launch(Mode mode) {
    switch (mode) {
      case FIRE:
        launcherCylinder.set(true);
        SmartDashboard.putString("Launcher Status: ", "Launching!");
        break;
      case OFF:
        launcherCylinder.set(false);
        SmartDashboard.putString("Launcher Status: ", "Stopping!");
        break;
    }
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
