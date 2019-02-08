package frc.robot.subsystems.helpers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

public class JoystickPOV extends Button {
    private final GenericHID m_joystick;
    private final int m_povNumber;
    private final int m_povPosition;

    /**
     * Configures a trigger-able POV position for a given POV control on the joystick.
     * 
     * For position, up is 0, right is 90, down is 180, left is 270, and if it's unpressed, it's -1.
     * You do get the 45 degree intervals between those I listed as well.
     * 
     * @param joystick The joystick.
     * @param povNumber The POV number (typically 0).
     * @param povPosition The position to monitor for.
     */
    public JoystickPOV(GenericHID joystick, int povNumber, int povPosition) {
        m_joystick = joystick;
        m_povNumber = povNumber;
        m_povPosition = povPosition;
    }

    @Override
    public boolean get() {
        return m_joystick.getPOV(m_povNumber) == m_povPosition;
    }
}