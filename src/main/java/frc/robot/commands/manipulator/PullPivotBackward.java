package frc.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PullPivotBackward extends Command {

    public PullPivotBackward() {
        requires(Robot.m_pivot);
    }

    protected void initialize() {
        System.out.println("PullPivotBackward initializing");
        Robot.m_pivot.backward();
    }

    protected void execute() {
        Robot.m_pivot.backward();
    }

    @Override
    protected boolean isFinished() {
        return false;
        // return Robot.m_pivot.isFullyBackward();
    }

    protected void interrupted() {
        Robot.m_pivot.stop();
        end();
    }

}