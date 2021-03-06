package frc.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeBall extends Command {

    public IntakeBall() {
        requires(Robot.m_shooter);
    }

    protected void initialize() {
        Robot.m_shooter.intake();
    }

    protected void execute() {
        Robot.m_shooter.intake();
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