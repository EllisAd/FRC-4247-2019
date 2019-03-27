package frc.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LowerPanelGrabber extends Command {

    public LowerPanelGrabber() {
        requires(Robot.m_panelGrabber);
    }

    protected void initialize() {
        Robot.m_panelGrabber.lower();
    }

    protected void execute() {
        Robot.m_panelGrabber.lower();
    }

    @Override
    protected boolean isFinished() {
        return false;
        // return Robot.m_panelGrabber.isFullyLowered();
    }

    protected void interrupted() {
        Robot.m_panelGrabber.stop();
        end();
    }

}