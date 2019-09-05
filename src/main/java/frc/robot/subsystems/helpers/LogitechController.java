package frc.robot.subsystems.helpers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;

public class LogitechController {

    public final int port;
    private Joystick joystick;

    public final Button buttonA;
    public final Button buttonB;
    public final Button buttonX;
    public final Button buttonY;
    public final Button buttonStart;
    public final Button buttonBack;
    public final Button leftBumper;
    public final Button rightBumper;
    public final Button leftTrigger;
    public final Button rightTrigger;
    public final Button dpadUp;
    public final Button dpadDown;
    public final Button dpadLeft;
    public final Button dpadRight;
    public final Button dpadUpRight;
    public final Button dpadUpLeft;
    public final Button dpadDownRight;
    public final Button dpadDownLeft;

    public LogitechController(int port) {
        this.port = port;
        this.joystick = new Joystick(port);

        buttonA = new JoystickButton(joystick, RobotMap.BUTTON_A);
        buttonB = new JoystickButton(joystick, RobotMap.BUTTON_B);
        buttonX = new JoystickButton(joystick, RobotMap.BUTTON_X);
        buttonY = new JoystickButton(joystick, RobotMap.BUTTON_Y);
        buttonStart = new JoystickButton(joystick, RobotMap.BUTTON_START);
        buttonBack = new JoystickButton(joystick, RobotMap.BUTTON_BACK);
        leftBumper = new JoystickButton(joystick, RobotMap.BUMPER_LEFT);
        rightBumper = new JoystickButton(joystick, RobotMap.BUMPER_RIGHT);
        leftTrigger = new JoystickAnalogTrigger(joystick, RobotMap.TRIGGER_LEFT_PULL, 0.1, 1.0);
        rightTrigger = new JoystickAnalogTrigger(joystick, RobotMap.TRIGGER_RIGHT_PULL, 0.1, 1.0);
        dpadUp = new JoystickPOV(joystick, RobotMap.DPAD, RobotMap.DPAD_UP);
        dpadDown = new JoystickPOV(joystick, RobotMap.DPAD, RobotMap.DPAD_DOWN);
        dpadLeft = new JoystickPOV(joystick, RobotMap.DPAD, RobotMap.DPAD_LEFT);
        dpadRight = new JoystickPOV(joystick, RobotMap.DPAD, RobotMap.DPAD_RIGHT);
        dpadUpLeft = new JoystickPOV(joystick, RobotMap.DPAD, RobotMap.DPAD_UP_LEFT);
        dpadUpRight = new JoystickPOV(joystick, RobotMap.DPAD, RobotMap.DPAD_UP_RIGHT);
        dpadDownLeft = new JoystickPOV(joystick, RobotMap.DPAD, RobotMap.DPAD_DOWN_LEFT);
        dpadDownRight = new JoystickPOV(joystick, RobotMap.DPAD, RobotMap.DPAD_DOWN_RIGHT);
    }

    // Joystick Control
    public double getLeftJoyY() {
      return joystick.getRawAxis(RobotMap.JOYSTICK_LEFT_UP_AXIS);
    }
  
    public double getLeftJoyX() {
      return joystick.getRawAxis(RobotMap.JOYSTICK_LEFT_SIDE_AXIS);
    }
  
    public double getRightJoyY() {
      return joystick.getRawAxis(RobotMap.JOYSTICK_RIGHT_UP_AXIS);
    }
  
    public double getRightJoyX() {
      return joystick.getRawAxis(RobotMap.JOYSTICK_RIGHT_SIDE_AXIS);
    }
  
    public double getLeftTrigger() {
      return joystick.getRawAxis(RobotMap.TRIGGER_LEFT_PULL);
    }
  
    public double getRightTrigger() {
      return joystick.getRawAxis(RobotMap.TRIGGER_RIGHT_PULL);
    }
}