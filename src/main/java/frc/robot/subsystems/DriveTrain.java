package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.drive.TankDrive;

public class DriveTrain extends Subsystem {

    private final TalonSRX leftMotor = new TalonSRX(RobotMap.LEFT_MOTOR_CANBUS_PORT);
    private final TalonSRX rightMotor = new TalonSRX(RobotMap.RIGHT_MOTOR_CANBUS_PORT);

    public void set(double leftMotorOutput, double rightMotorOutput) {
        leftMotor.set(ControlMode.PercentOutput, leftMotorOutput);
        rightMotor.set(ControlMode.PercentOutput, -rightMotorOutput);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
}