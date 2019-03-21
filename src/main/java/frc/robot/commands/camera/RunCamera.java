package frc.robot.commands.camera;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunCamera extends Command {

    public RunCamera() {
        requires(Robot.m_cameras);
    }

    protected void initialize() {
        Robot.m_cameras.start(320, 240, 15, 320, 240, 15);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}