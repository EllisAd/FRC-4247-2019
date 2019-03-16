package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Utils;

public class ArcadeDrive extends Command {

	public ArcadeDrive() {
		requires(Robot.m_driveTrain);
	}

	protected void intialize() {

	}

	protected void execute() {
        double y = Robot.m_oi.getLeftJoyY();
        double x = Robot.m_oi.getLeftJoyX();

        double left = Utils.clamp(-x - y, -1.0, 1.0);
        double right = Utils.clamp(x - y, -1.0, 1.0);

        Robot.m_driveTrain.set(left, right);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void interrupt() {
		end();
	}
}
