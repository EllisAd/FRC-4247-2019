package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class PanelGrabber extends Subsystem {

    private static final double LOWER_SPEED = -0.5;
    private static final double RAISE_SPEED = 0.6;
    private static final double IDLE_SPEED = 0.0;

    private final TalonSRX motor = new TalonSRX(RobotMap.PANEL_GRABBER_CANBUS_PORT);

    private final DigitalInput raisedSwitch = new DigitalInput(RobotMap.PANEL_GRABBER_HIGH_SWITCH_PORT);
    private final DigitalInput loweredSwitch = new DigitalInput(RobotMap.PANEL_GRABBER_LOW_SWITCH_PORT);

    public void raise() {
        if (!isFullyRaised()) {
            this.motor.set(ControlMode.PercentOutput, RAISE_SPEED);
        } else {
            stop();
        }
    }

    public void lower() {
        if (!isFullyLowered()) {
            this.motor.set(ControlMode.PercentOutput, LOWER_SPEED);
        } else {
            stop();
        }
    }
    
	public void stop() {
        this.motor.set(ControlMode.PercentOutput, IDLE_SPEED);
    }
    
    // TODO Set up limit switches!
	public boolean isFullyRaised() {
        return false;
		// return raisedSwitch.get();
    }
    
    public boolean isFullyLowered() {
        return false;
        // return loweredSwitch.get();
    }

    @Override
    protected void initDefaultCommand() {}
}