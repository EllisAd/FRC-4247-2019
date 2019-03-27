package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Utils;

public class Elevator extends Subsystem {

    private static final double MAX_RAISE_SPEED = 0.4;
    private static final double MAX_LOWER_SPEED = -0.4;
    private static final double HOLD_SPEED = 0.0;

    private static final double DELTA_RATE_LIMIT = 0.02;

    private final TalonSRX leftMotor = new TalonSRX(RobotMap.ELEVATOR_LEFT_CANBUS_PORT);
    private final TalonSRX rightMotor = new TalonSRX(RobotMap.ELEVATOR_RIGHT_CANBUS_PORT);

    private final DigitalInput raisedSwitch = new DigitalInput(RobotMap.ELEVATOR_HIGH_SWITCH_PORT);
    private final DigitalInput loweredSwitch = new DigitalInput(RobotMap.ELEVATOR_LOW_SWITCH_PORT);

    private double lastOutputValue = 0.0;

    public void raise(double inputValue) {
        if (!isFullyRaised()) {
            double output = this.mapInputToOutput(inputValue);
            this.leftMotor.set(ControlMode.PercentOutput, output);
            this.rightMotor.set(ControlMode.PercentOutput, output);
        } else {
            stop();
        }
    }

    public void lower(double inputValue) {
        if (!isFullyLowered()) {
            double output = this.mapInputToOutput(-inputValue);
            this.leftMotor.set(ControlMode.PercentOutput, output);
            this.rightMotor.set(ControlMode.PercentOutput, output);
        } else {
            stop();
        }
    }

    public void stop() {
        this.leftMotor.set(ControlMode.PercentOutput, HOLD_SPEED);
        this.rightMotor.set(ControlMode.PercentOutput, HOLD_SPEED);
        lastOutputValue = HOLD_SPEED;
    }

    // Maps input values to outputs
    private double mapInputToOutput(double input) {
        input = Utils.clamp(input, -1.0, 1.0);

        // Calculate target output
        double target = HOLD_SPEED;
        if (input > 0.0) {
            target = Utils.linearMap(input, 0.0, 1.0, HOLD_SPEED, MAX_RAISE_SPEED);
        } else if (input < 0.0) {
            target = Utils.linearMap(input, 0.0, -1.0, HOLD_SPEED, MAX_LOWER_SPEED);
        }

        // Apply rate-limiting and save the previous value
        double newOutputValue = Utils.rateLimit(lastOutputValue, target, DELTA_RATE_LIMIT);
        lastOutputValue = newOutputValue;
        return newOutputValue;
    }

    // TODO Set up limit switches!
	public boolean isFullyRaised() {
        return false;
		// return !raisedSwitch.get();
    }
    
    public boolean isFullyLowered() {
        return false;
        // return !loweredSwitch.get();
    }

    @Override
    protected void initDefaultCommand() {}
}