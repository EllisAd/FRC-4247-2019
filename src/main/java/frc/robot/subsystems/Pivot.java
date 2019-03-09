package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Pivot extends Subsystem {

    private static final double FORWARD_SPEED = 0.85;
    private static final double BACKWARD_SPEED = -0.85;
    private static final double IDLE_SPEED = 0.0;

    private final TalonSRX motor = new TalonSRX(RobotMap.PIVOT_CANBUS_PORT);

    private final DigitalInput forwardSwitch = new DigitalInput(RobotMap.PIVOT_FORWARD_SWITCH_PORT);
    private final DigitalInput backwardSwitch = new DigitalInput(RobotMap.PIVOT_BACKWARD_SWITCH_PORT);

    public Pivot() {
        // this.forwardSwitch.requestInterrupts(handler);
    }

    public void forward() {
        if (!isFullyForward()) {
            this.motor.set(ControlMode.PercentOutput, FORWARD_SPEED);
        } else {
            stop();
        }
    }

    public void backward() {
        if (!isFullyBackward()) {
            this.motor.set(ControlMode.PercentOutput, BACKWARD_SPEED);
        } else {
            stop();
        }
    }
    
	public void stop() {
        this.motor.set(ControlMode.PercentOutput, IDLE_SPEED);
    }
    
    // TODO Set up limit switches!
	public boolean isFullyForward() {
        return false;
		// return forwardSwitch.get();
    }
    
    public boolean isFullyBackward() {
        return false;
        // return backwardSwitch.get();
    }

    @Override
    protected void initDefaultCommand() {}
}