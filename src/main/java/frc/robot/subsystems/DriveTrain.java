package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class DriveTrain extends Subsystem {

    // TODO Replace this with TalonSRX!
    private final Talon leftMotor = new Talon(RobotMap.LEFT_MOTOR_CANBUS_PORT);
    private final Talon rightMotor = new Talon(RobotMap.RIGHT_MOTOR_CANBUS_PORT);

    public void set(double leftMotorOutput, double rightMotorOutput) {
        // TODO Scaling?
        leftMotor.set(leftMotorOutput);
        rightMotor.set(rightMotorOutput);
    }

    @Override
    protected void initDefaultCommand() {
        this.set(0.0, 0.0);
    }
}