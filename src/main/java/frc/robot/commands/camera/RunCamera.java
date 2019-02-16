package frc.robot.commands.camera;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunCamera extends Command {

    public RunCamera() {
        requires(Robot.m_camera);
    }

    protected void initialize() {
        Robot.m_camera.start(640, 480, 15);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}