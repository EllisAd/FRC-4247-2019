package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Utils;

public class ArcadeDrive extends Command {

	private static final double FINE_X_AMOUNT = 0.5;
	private static final double FINE_Y_AMOUNT = 0.5;

	private static final double FAST_X_AMOUNT = 0.75;
	private static final double FAST_Y_AMOUNT = 0.5;

	public ArcadeDrive() {
		requires(Robot.m_driveTrain);
	}

	protected void intialize() {

	}

	protected void execute() {
		// TODO Take the joystick values from the commanding controller!

		// Driving forwards for the shooter
        double y = Robot.m_oi.leftController.getLeftJoyY() * FAST_Y_AMOUNT;
		double x = Robot.m_oi.leftController.getLeftJoyX() * FAST_X_AMOUNT;
		
		// Driving backwards for the panel grabber
		double yFine = Robot.m_oi.leftController.getRightJoyY() * FINE_Y_AMOUNT;
		double xFine = Robot.m_oi.leftController.getRightJoyX() * FINE_X_AMOUNT;

		// Translate to motor outputs
        double left = Utils.clamp(x + xFine - y + yFine, -1.0, 1.0);
        double right = Utils.clamp(-x - xFine - y + yFine, -1.0, 1.0);

        Robot.m_driveTrain.set(left, right);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void interrupt() {
		end();
	}
}
