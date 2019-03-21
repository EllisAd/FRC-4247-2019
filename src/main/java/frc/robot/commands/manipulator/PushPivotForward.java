package frc.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PushPivotForward extends Command {

    public PushPivotForward() {
        requires(Robot.m_pivot);
    }

    protected void initialize() {
        Robot.m_pivot.forward();
    }

    protected void execute() {
        Robot.m_pivot.forward();
    }

    @Override
    protected boolean isFinished() {
        return false;
        // return Robot.m_pivot.isFullyForward();
    }

    protected void interrupted() {
        Robot.m_pivot.stop();
        end();
    }

}