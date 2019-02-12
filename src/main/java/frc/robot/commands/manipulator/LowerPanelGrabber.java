package frc.robot.commands.manipulator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

// TODO Get these to work properly!
public class LowerPanelGrabber extends Command {

    private Timer timer = new Timer();

    public LowerPanelGrabber() {
        requires(Robot.m_panelGrabber);
    }

    protected void initialize() {
        timer.reset();
    }

    protected void execute() {
        Robot.m_panelGrabber.setMotorSpeed(10.0);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    protected void interrupt() {
        end();
    }

}