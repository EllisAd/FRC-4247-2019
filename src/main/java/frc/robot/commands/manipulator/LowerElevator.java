package frc.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.helpers.JoystickReader;

public class LowerElevator extends Command {

    private final JoystickReader joystickReader;

    public LowerElevator(JoystickReader joystickReader) {
        requires(Robot.m_elevator);
        this.joystickReader = joystickReader;
    }

    protected void initialize() {
        Robot.m_elevator.lower(joystickReader.get());
    }

    protected void execute() {
        Robot.m_elevator.lower(joystickReader.get());
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