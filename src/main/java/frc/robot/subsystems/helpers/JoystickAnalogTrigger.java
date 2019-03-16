package frc.robot.subsystems.helpers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

public class JoystickAnalogTrigger extends Button {
    private final GenericHID m_joystick;
    private final int m_axis;
    private final double m_minValue; // 0.1
    private final double m_maxValue; // 1.0

    /**
     * Configures a trigger-able joystick trigger
     * @param joystick
     * @param axis
     * @param minValue
     * @param maxValue
     */
    public JoystickAnalogTrigger(GenericHID joystick,
        int axis,
        double minValue,
        double maxValue) {
        
        m_joystick = joystick;
        m_axis = axis;
        m_minValue = minValue;
        m_maxValue = maxValue;
    }

    @Override
    public boolean get() {
        double value = m_joystick.getRawAxis(m_axis);
        return (value >= m_minValue && value <= m_maxValue);
    }
}