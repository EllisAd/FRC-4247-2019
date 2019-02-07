package frc.robot.subsystems.helpers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

public class JoystickPOV extends Button {
    private final GenericHID m_joystick;
    private final int m_povNumber;
    private final int m_povPosition;

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