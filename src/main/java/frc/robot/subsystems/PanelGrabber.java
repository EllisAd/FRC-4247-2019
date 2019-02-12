package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class PanelGrabber extends Subsystem {

    private final TalonSRX motor = new TalonSRX(RobotMap.PANEL_GRABBER_CANBUS_PORT);
    // TODO Add limit switches?

    public void setMotorSpeed(double motorSpeed) {
        this.motor.set(ControlMode.PercentOutput, motorSpeed);
    }

    public double getMotorSpeed() {
        return this.motor.getMotorOutputPercent();
    }

    @Override
    protected void initDefaultCommand() {}
}