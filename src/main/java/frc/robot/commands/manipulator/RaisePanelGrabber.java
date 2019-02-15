package frc.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RaisePanelGrabber extends Command {

    public RaisePanelGrabber() {
        requires(Robot.m_panelGrabber);
    }

    protected void initialize() {}

    protected void execute() {
        Robot.m_panelGrabber.raise();
    }

    @Override
    protected boolean isFinished() {
        return Robot.m_panelGrabber.isFullyRaised();
    }

    protected void interrupt() {
        Robot.m_panelGrabber.stop();
        end();
    }

}