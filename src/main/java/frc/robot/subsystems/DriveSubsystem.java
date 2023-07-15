package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.DriveMode;
import frc.robot.Globals;

public class DriveSubsystem extends SubsystemBase
{
    private final WPI_TalonSRX leftFront = new WPI_TalonSRX(Constants.leftFrontDriveMotorPort);
    private final WPI_TalonSRX rightFront = new WPI_TalonSRX(Constants.rightFrontDriveMotorPort);
    private final WPI_TalonSRX leftBack = new WPI_TalonSRX(Constants.leftBackDriveMotorPort);
    private final WPI_TalonSRX rightBack = new WPI_TalonSRX(Constants.rightBackDriveMotorPort);

    //the groups make controlling the drive easier
    private final MotorControllerGroup leftMotors = new MotorControllerGroup(leftFront, leftBack);
    private final MotorControllerGroup rightMotors = new MotorControllerGroup(rightFront, rightBack);
    private final DifferentialDrive driveBase = new DifferentialDrive(leftMotors, rightMotors);

    //variables for the previous speeds during the execution loop
    private double prevLeftSpeed = 0;
    private double prevRightSpeed = 0;
    private double prevTurnSpeed = 0;
    private DriveMode currentDriveMode = Constants.DefaultDriveMode;
    private DriveMode lastDriveSpeed = Constants.DefaultDriveMode;

    /** Creates a new ExampleSubsystem. */
    public DriveSubsystem() {
        leftFront.setInverted(true);
        leftBack.setInverted(true);
        SmartDashboard.putString("Drive Mode", currentDriveMode.getName());
        driveBase.setSafetyEnabled(false);
    }

    public void drive(double leftDriveValue, double rightDriveValue) {
        double leftSpeed = leftDriveValue;
        double rightSpeed = rightDriveValue;
        if(currentDriveMode.isInvertLin()) {
            leftSpeed *= -1;
            rightSpeed *= -1;
            if(Globals.TankDrive) {
                double temp = leftSpeed;
                leftSpeed = rightSpeed;
                rightSpeed = temp;
            }
        }

        if(currentDriveMode.isRawMode()) {
            prevLeftSpeed = leftSpeed;
            prevRightSpeed = rightSpeed;
        } else if(Globals.TankDrive){
            double newLeftSpeed = leftSpeed * currentDriveMode.getLinearMult();
            double newRightSpeed = rightSpeed * currentDriveMode.getLinearMult();
            double maxAccel = currentDriveMode.getMaxLinAccel();

            prevLeftSpeed = MathUtil.clamp(newLeftSpeed, prevLeftSpeed - maxAccel, prevLeftSpeed + maxAccel);
            prevRightSpeed = MathUtil.clamp(newRightSpeed, prevRightSpeed - maxAccel, prevRightSpeed + maxAccel);
            driveBase.tankDrive(prevLeftSpeed, prevRightSpeed, false);
        } else {
            double newLeftSpeed = leftSpeed * currentDriveMode.getLinearMult();
            double newTurnSpeed = currentDriveMode.getRotMult();
            double maxLinAccel = currentDriveMode.getMaxLinAccel();
            double maxRotAccel = currentDriveMode.getMaxRotAccel();

            prevLeftSpeed = MathUtil.clamp(newLeftSpeed, prevLeftSpeed - maxLinAccel, prevLeftSpeed + maxLinAccel);
            prevTurnSpeed = MathUtil.clamp(newTurnSpeed, prevTurnSpeed - maxRotAccel, prevTurnSpeed + maxRotAccel);
            driveBase.curvatureDrive(prevLeftSpeed, prevTurnSpeed, true);
        }
    }

    public void changeMode(final boolean increase) {
        if(currentDriveMode.index == -1) {
            currentDriveMode = DriveMode.driveModes.get(0);
        }
        if (increase) {
            currentDriveMode = DriveMode.driveModes.get(currentDriveMode.index % DriveMode.driveModes.size());
        }
        else {
            if(1 == currentDriveMode.index)
            {
                currentDriveMode = DriveMode.driveModes.get(DriveMode.driveModes.size() - 1);
            }
            else
            {
                currentDriveMode = DriveMode.driveModes.get(currentDriveMode.index - 2);
            }
        }
        SmartDashboard.putNumber("Drive Mode", (100.0 / DriveMode.driveModes.size()) * currentDriveMode.index);
    }

    public void setDriveMode(DriveMode newDriveMode) {
        lastDriveSpeed = this.currentDriveMode;
        this.currentDriveMode = newDriveMode;
        SmartDashboard.putString("Drive Mode", this.currentDriveMode.getName());
    }

    public void setLastDriveMode() {
        this.currentDriveMode = lastDriveSpeed;
        SmartDashboard.putString("Drive Mode", this.currentDriveMode.getName());
    }
}
