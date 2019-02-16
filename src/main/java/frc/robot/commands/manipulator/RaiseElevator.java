package frc.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.helpers.JoystickReader;

public class RaiseElevator extends Command {

    private final JoystickReader joystickReader;

    public RaiseElevator(JoystickReader joystickReader) {
        requires(Robot.m_elevator);
        this.joystickReader = joystickReader;
    }

    protected void initialize() {
        System.out.println("RaiseElevator initializing");
        Robot.m_elevator.raise(joystickReader.get());
    }

    protected void execute() {
        Robot.m_elevator.raise(joystickReader.get());
    }

    @Override
    protected boolean isFinished() {
        return false;
        // return Robot.m_elevator.isFullyLowered();
    }

    protected void interrupted() {
        Robot.m_elevator.stop();
        end();
    }

}