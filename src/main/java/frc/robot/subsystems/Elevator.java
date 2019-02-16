package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Utils;

public class Elevator extends Subsystem {

    private static final double MAX_RAISE_SPEED = 1.0;
    private static final double MAX_LOWER_SPEED = -1.0;
    private static final double HOLD_SPEED = 0.0;

    private final TalonSRX motor = new TalonSRX(RobotMap.ELEVATOR_CANBUS_PORT);

    private final DigitalInput raisedSwitch = new DigitalInput(RobotMap.ELEVATOR_HIGH_SWITCH_PORT);
    private final DigitalInput loweredSwitch = new DigitalInput(RobotMap.ELEVATOR_LOW_SWITCH_PORT);

    public void raise(double inputValue) {
        if (!isFullyRaised()) {
            this.motor.set(ControlMode.PercentOutput, this.mapInputToOutput(inputValue));
        } else {
            stop();
        }
    }

    public void lower(double inputValue) {
        if (!isFullyLowered()) {
            this.motor.set(ControlMode.PercentOutput, this.mapInputToOutput(-inputValue));
        } else {
            stop();
        }
    }

    public void stop() {
        this.motor.set(ControlMode.PercentOutput, HOLD_SPEED);
    }

    // Maps input values to outputs
    private double mapInputToOutput(double input) {
        input = Utils.clamp(input, -1.0, 1.0);
        
        if (input > 0.0) {
            return Utils.linearMap(input, 0.0, 1.0, HOLD_SPEED, MAX_RAISE_SPEED);
        } else if (input < 0.0) {
            return Utils.linearMap(input, 0.0, -1.0, HOLD_SPEED, MAX_LOWER_SPEED);
        } else {
            return HOLD_SPEED;
        }
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