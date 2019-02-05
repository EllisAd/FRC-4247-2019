package frc.robot.subsystems.helpers;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

public class WormGearHelper {

    public enum DriveInput {
        IDLE,
        EXTEND,
        RETRACT
    }

    public enum DriveOutput {
        IDLE,
        EXTENDING,
        FULLY_EXTENDED,
        RETRACTING,
        FULLY_RETRACTED
    }

    // TODO Do we want to track velocity, or position?
    private double m_idleVelocity = 0;
    private double m_extendVelocity = 0.5;
    private double m_retractVelocity = -0.5;

    private TalonSRX m_motor;
    private DigitalInput m_lowLimitSwitch;
    private DigitalInput m_highLimitSwitch;

    public WormGearHelper(int motorCanbusPort, int lowLimitSwitch, int highLimitSwitch) {
        m_motor = new TalonSRX(motorCanbusPort);
        m_lowLimitSwitch = new DigitalInput(lowLimitSwitch);
        m_highLimitSwitch = new DigitalInput(highLimitSwitch);
    }

    public void setVelocities(double extend, double retract, double idle) {
        m_extendVelocity = extend;
        m_retractVelocity = retract;
        m_idleVelocity = idle;
    }

    public DriveOutput driveMotor(DriveInput input) {
        switch (input) {
            case EXTEND:
                if (!m_highLimitSwitch.get()) {
                    m_motor.set(ControlMode.Velocity, m_extendVelocity);
                    return DriveOutput.EXTENDING;
                } else {
                    m_motor.set(ControlMode.Velocity, m_idleVelocity);
                    return DriveOutput.FULLY_EXTENDED;
                }
            case RETRACT:
                if (!m_lowLimitSwitch.get()) {
                    m_motor.set(ControlMode.Velocity, m_retractVelocity);
                    return DriveOutput.RETRACTING;
                } else {
                    m_motor.set(ControlMode.Velocity, m_idleVelocity);
                    return DriveOutput.FULLY_RETRACTED;
                }
            case IDLE:
            default:
                m_motor.set(ControlMode.Velocity, m_idleVelocity);
                if (m_highLimitSwitch.get()) {
                    return DriveOutput.FULLY_EXTENDED;
                } else if (m_lowLimitSwitch.get()) {
                    return DriveOutput.FULLY_RETRACTED;
                } else {
                    return DriveOutput.IDLE;
                }
        }
    }

    public void stopMotor() {
        m_motor.set(ControlMode.PercentOutput, 0);
    }
}