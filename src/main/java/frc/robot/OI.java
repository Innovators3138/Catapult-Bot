package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.mappings.AxisMapping;
import frc.robot.mappings.ButtonMapping;

public class OI {
    private static OI oi;

    public AxisMapping leftDriveAxis;
    public AxisMapping rightDriveAxis;

    public ButtonMapping launcherLaunchBtn;
    public ButtonMapping driveModeDownBtn;
    public ButtonMapping driveModeUpBtn;
    public ButtonMapping driveToggleReverse;
    public ButtonMapping driveToggleIntake;
    
    private OI() {
        innovatorStation();
    }

    private void innovatorStation() {
        final int leftDriveControllerPort = 0;
        final int rightDriveControllerPort = 1;
        final int controllerPort = 2;
        

        final Joystick leftDriveJoystick = new Joystick(leftDriveControllerPort);
        final Joystick rightDriveJoystick = new Joystick(rightDriveControllerPort);
        
        final Joystick controller = new Joystick(controllerPort);

        launcherLaunchBtn = new ButtonMapping(controller, SwitchPro.btnB);

        leftDriveAxis = new AxisMapping.Builder(leftDriveJoystick, LogitechAttack.axsY).deadzoneValue(0.06).build();
        rightDriveAxis = new AxisMapping.Builder(rightDriveJoystick, LogitechAttack.axsY).deadzoneValue(0.06).build();

        driveModeDownBtn = new ButtonMapping(rightDriveJoystick, LogitechAttack.btn2);
        driveModeUpBtn = new ButtonMapping(rightDriveJoystick, LogitechAttack.btn4);
        driveToggleIntake = new ButtonMapping(rightDriveJoystick, LogitechAttack.btnTRIGGER);
        driveToggleReverse = new ButtonMapping(leftDriveJoystick, LogitechAttack.btnTRIGGER);

    }

    public static OI getInstance() {
        if (oi == null) {
            oi = new OI();
        }
        return oi;
    }

    class SwitchPro {
        //region Buttons
        private static final int btnB = 1;
        private static final int BtnA = 2;
        private static final int btnY = 3;
        private static final int btnX = 4;
        private static final int btnL = 5;
        private static final int btnR = 6;
        private static final int btnZL = 7;
        private static final int btnZR = 8;
        private static final int btnMinus = 9;
        private static final int btnPlus = 10;
        private static final int btnLSTICK = 11;
        private static final int btnRSTICK = 12;
        private static final int btnHOME = 13;
        private static final int btnSCREENSHOT = 14;
        //endregion

        //region Axes
        private static final int axsLX = 0;
        private static final int axsLY = 1;
        private static final int axsRX = 2;
        private static final int axsRY = 3;
        //endregion
    }

    class LogitechAttack {
        //region Buttons
        public static final int btnTRIGGER = 1;
        public static final int btn2 = 2;
        public static final int btn3 = 3;
        public static final int btn4 = 4;
        public static final int btn5 = 5;
        public static final int btn6 = 6;
        public static final int btn7 = 7;
        public static final int btn8 = 8;
        public static final int btn9 = 9;
        public static final int btn10 = 10;
        public static final int btn11 = 11;
        //endregion

        //region Axes
        public static final int axsX = 0;
        public static final int axsY = 1;
        public static final int axsZ = 2;
        //endregion
    }
}
