package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Shooter extends Subsystem {

    private static final double SHOOT_SPEED = -1.0;
    private static final double INTAKE_SPEED = 1.0;
    private static final double IDLE_SPEED = 0.0;

    private final TalonSRX shooterLeftMotor = new TalonSRX(RobotMap.SHOOTER_LEFT_CANBUS_PORT);
    private final TalonSRX shooterRightMotor = new TalonSRX(RobotMap.SHOOTER_RIGHT_CANBUS_PORT);
    private final DigitalInput limitSwitch = new DigitalInput(RobotMap.SHOOTER_LIMIT_SWITCH_PORT);

    public void shoot() {
        shooterLeftMotor.set(ControlMode.PercentOutput, SHOOT_SPEED);
        shooterRightMotor.set(ControlMode.PercentOutput, SHOOT_SPEED);
    }

    public void stop() {
        shooterLeftMotor.set(ControlMode.PercentOutput, IDLE_SPEED);
        shooterRightMotor.set(ControlMode.PercentOutput, IDLE_SPEED);
    }

    public void intake() {
        if (isLimitSwitchPressed()) {
            System.out.println("Ball captured");
            shooterLeftMotor.set(ControlMode.PercentOutput, IDLE_SPEED);
            shooterRightMotor.set(ControlMode.PercentOutput, IDLE_SPEED);
        } else {
            System.out.println("Intaking ball");
            shooterLeftMotor.set(ControlMode.PercentOutput, INTAKE_SPEED);
            shooterRightMotor.set(ControlMode.PercentOutput, INTAKE_SPEED);
        }
    }

    public boolean isLimitSwitchPressed() {
        return !limitSwitch.get();
    }

    @Override
    protected void initDefaultCommand() {}
}