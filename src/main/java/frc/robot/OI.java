package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.mappings.AxisMapping;
import frc.robot.mappings.ButtonMapping;

public class OI {
    private static OI oi;

    public AxisMapping leftDriveAxis;
    public AxisMapping rightDriveAxis;

    public ButtonMapping launcherLaunchBtn;

    private OI() {
        innovatorStation();
    }

    private void innovatorStation() {
        final int controllerPort = 0;

        final Joystick controller = new Joystick(controllerPort);

        launcherLaunchBtn = new ButtonMapping(controller, SwitchPro.btnB);

        leftDriveAxis = new AxisMapping.Builder(controller, SwitchPro.axsLY).deadzoneValue(0.06).build();
        rightDriveAxis = new AxisMapping.Builder(controller, SwitchPro.axsRY).deadzoneValue(0.06).build();

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
}
