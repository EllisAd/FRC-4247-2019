package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TankDrive extends Command {

	public TankDrive() {
		requires(Robot.m_driveTrain);
	}

	protected void intialize() {

	}

	protected void execute() {
        Robot.m_driveTrain.set(-Robot.m_oi.getLeftJoyY(), 
            -Robot.m_oi.getRightJoyY());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void interrupt() {
		end();
	}
}
