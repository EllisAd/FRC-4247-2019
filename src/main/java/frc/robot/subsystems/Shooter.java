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

    private final TalonSRX shooterMotor = new TalonSRX(RobotMap.SHOOTER_CANBUS_PORT);
    private final DigitalInput limitSwitch = new DigitalInput(RobotMap.SHOOTER_LIMIT_SWITCH_PORT);

    public void shoot() {
        shooterMotor.set(ControlMode.PercentOutput, SHOOT_SPEED);
    }

    public void stop() {
        shooterMotor.set(ControlMode.PercentOutput, IDLE_SPEED);
    }

    public void intake() {
        if (isLimitSwitchPressed()) {
            System.out.println("Ball captured");
            shooterMotor.set(ControlMode.PercentOutput, IDLE_SPEED);
        } else {
            System.out.println("Intaking ball");
            shooterMotor.set(ControlMode.PercentOutput, INTAKE_SPEED);
        }
    }

    public boolean isLimitSwitchPressed() {
        return !limitSwitch.get();
    }

    @Override
    protected void initDefaultCommand() {}
}