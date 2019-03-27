package frc.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RaisePanelGrabber extends Command {

    public RaisePanelGrabber() {
        requires(Robot.m_panelGrabber);
    }

    protected void initialize() {
        Robot.m_panelGrabber.raise();
    }

    protected void execute() {
        Robot.m_panelGrabber.raise();
    }

    @Override
    protected boolean isFinished() {
        return false;
        // return Robot.m_panelGrabber.isFullyRaised();
    }

    @Override
    protected void interrupted() {
        Robot.m_panelGrabber.stop();
        end();
    }

}