package frc.robot.mappings;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * A wrapper class for a {@link JoystickButton JoystickButton} created from a {@link Joystick Joystick} to simplify
 * creating and managing buttons
 */
public class ButtonMapping {
    private final Joystick joystick;
    private final int buttonID;

    /**
     * @param joystick The {@link Joystick Joystick} object to hold the controller for this button
     * @param buttonID The ID of the button
     */
    public ButtonMapping(Joystick joystick, int buttonID) {
        this.joystick = joystick;
        this.buttonID = buttonID;
    }

    /**
     * The {@link Joystick Joystick} object of this button
     */
    public Joystick getJoystick() {
        return joystick;
    }

    /**
     * The integer button id
     */
    public int getButtonID() {
        return buttonID;
    }

    /**
     * A method for returning a {@link JoystickButton JoystickButton} using the wrapper class
     */
    public JoystickButton getButton() {
        return new JoystickButton(joystick, buttonID);
    }

    public boolean getBoolean() {
        return joystick.getRawButton(buttonID);
    }
}
