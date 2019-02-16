package frc.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ShootBall extends Command {

    public ShootBall() {
        requires(Robot.m_shooter);
    }

    protected void initialize() {
        Robot.m_shooter.shoot();
    }

    protected void execute() {
        Robot.m_shooter.shoot();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    protected void interrupted() {
        Robot.m_shooter.stop();
        end();
    }
}