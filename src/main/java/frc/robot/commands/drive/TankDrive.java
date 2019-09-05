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
		// TODO Make this pull from the commanding controller!
        Robot.m_driveTrain.set(-Robot.m_oi.leftController.getLeftJoyY(), 
            -Robot.m_oi.rightController.getRightJoyY());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void interrupt() {
		end();
	}
}
