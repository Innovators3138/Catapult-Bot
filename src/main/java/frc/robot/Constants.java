// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  //CAN IDs
  public static final int pneumaticControlCanID = 0;
  public static final int leftFrontDriveMotorPort = 1;
  public static final int leftBackDriveMotorPort = 2;
  public static final int rightFrontDriveMotorPort = 3;
  public static final int rightBackDriveMotorPort = 4;


  public static final double DeadzoneDefault = 0.03;

  //Solenoid Configuration IDs
  public static final int launcherSolenoidChannel = 0;
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final double fireDelayTime = 0.1;

  public static DriveMode SlowMode = new DriveMode.Builder("SlowMode")
  .maxLinAccel(0.025)
  .maxRotAccel(0.025)
  .linearMult(0.4)
  .rotMult(0.1)
  .build();
//Standard Mode copy: public static DriveMode StdMode = new DriveMode("Standard", false, 0.025, 0.025, 0.8, 0.28, false, true);
public static DriveMode StdMode = new DriveMode.Builder("StandardMode")
  .maxLinAccel(0.025)
  .maxRotAccel(0.025)
  .linearMult(0.8)
  .rotMult(0.28)
  .addToList(false)
  .build();
public static DriveMode ExtraMode1 = new DriveMode.Builder("ExtraMode1")
  .maxLinAccel(0.04)
  .maxRotAccel(0.03)
  .linearMult(0.6)
  .rotMult(0.3)
  .addToList(false)
  .build();
//Fast Mode: faster driving
public static DriveMode FastMode = new DriveMode.Builder("FastMode")
  .maxLinAccel(0.06)
  .maxRotAccel(0.04)
  .rotMult(0.35)
  .build();
//Reversed: same as Standard, but the back of the robot is now the front
public static DriveMode Reversed = new DriveMode.Builder("Reversed")
  .maxLinAccel(StdMode.getMaxLinAccel())
  .maxRotAccel(StdMode.getMaxRotAccel())
  .linearMult(StdMode.getLinearMult())
  .rotMult(StdMode.getRotMult())
  .invertLin()
  .addToList(false)
  .build();
//Raw input means no acceleration processing is done, this would be for autonomous routines that handle their own acceleration processing, etc.
public static DriveMode RawInput = new DriveMode.Builder("RawMode").addToList(false).build();

public static final DriveMode DefaultDriveMode = SlowMode;
//endregion
}
