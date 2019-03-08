package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Utils;
import frc.robot.commands.drive.TankDrive;

public class DriveTrain extends Subsystem {

    private final TalonSRX leftMotor = new TalonSRX(RobotMap.LEFT_MOTOR_CANBUS_PORT);
    private final TalonSRX rightMotor = new TalonSRX(RobotMap.RIGHT_MOTOR_CANBUS_PORT);

    // Ramping factor, in percent output per update (20ms)
    private final double MIN_DELTA = 0.05;

    private double prevLeftOutput = 0.0;
    private double prevRightOutput = 0.0;

    public void set(double leftMotorOutput, double rightMotorOutput) {
        double adjustedLeftOutput = Utils.rateLimit(prevLeftOutput, leftMotorOutput, MIN_DELTA);

        leftMotor.set(ControlMode.PercentOutput, leftMotorOutput);
        rightMotor.set(ControlMode.PercentOutput, -rightMotorOutput);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
}