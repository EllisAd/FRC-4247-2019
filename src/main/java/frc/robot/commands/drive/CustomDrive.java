package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Utils;

public class CustomDrive extends Command {

	private static final double FINE_SPEED = 0.5;
	private static final double FAST_SPEED = 0.75;

	public CustomDrive() {
		requires(Robot.m_driveTrain);
	}

	protected void intialize() {

	}

	protected void execute() {
		// TODO Take the joystick values from the commanding controller!

		// Driving forwards for the shooter
        double leftFast = Robot.m_oi.leftController.getLeftJoyY() * FAST_SPEED;
		double rightFast = Robot.m_oi.leftController.getRightJoyY() * FAST_SPEED;
		
		// Driving backwards for the panel grabber
		double leftFine = Robot.m_oi.rightController.getLeftJoyY() * FINE_SPEED;
		double rightFine = Robot.m_oi.rightController.getRightJoyY() * FINE_SPEED;

		// Translate to motor outputs
        double left = Utils.clamp(-(leftFine + leftFast), -1.0, 1.0);
        double right = Utils.clamp(-(rightFine + rightFast), -1.0, 1.0);

		// Send to the drivetrain
        Robot.m_driveTrain.set(left, right);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void interrupt() {
		end();
	}
}
