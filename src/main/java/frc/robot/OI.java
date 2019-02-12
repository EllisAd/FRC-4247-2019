/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.manipulator.IntakeBall;
import frc.robot.commands.manipulator.LowerElevator;
import frc.robot.commands.manipulator.LowerPanelGrabber;
import frc.robot.commands.manipulator.LowerPivot;
import frc.robot.commands.manipulator.RaiseElevator;
import frc.robot.commands.manipulator.RaisePanelGrabber;
import frc.robot.commands.manipulator.RaisePivot;
import frc.robot.commands.manipulator.ShootBall;
import frc.robot.subsystems.helpers.JoystickAnalogTrigger;
import frc.robot.subsystems.helpers.JoystickPOV;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  //Joystick Setup
  private final Joystick joystick = new Joystick(RobotMap.JOYSTICK);

  //Button Setup
  private final Button buttonX = new JoystickButton(joystick, RobotMap.BUTTON_X);
  private final Button buttonY = new JoystickButton(joystick, RobotMap.BUTTON_Y);
  private final Button buttonA = new JoystickButton(joystick, RobotMap.BUTTON_A);
  private final Button buttonB = new JoystickButton(joystick, RobotMap.BUTTON_B);
  private final Button leftBumper = new JoystickButton(joystick, RobotMap.BUMPER_LEFT);
  private final Button rightBumper = new JoystickButton(joystick, RobotMap.BUMPER_RIGHT);
  private final Button rightTrigger = new JoystickAnalogTrigger(joystick, RobotMap.TRIGGER_RIGHT_PULL, 0.1, 1.0);
  private final Button leftTrigger = new JoystickAnalogTrigger(joystick, RobotMap.TRIGGER_LEFT_PULL, 0.1, 1.0);

  //POV Setup
  private final Button upperPOV = new JoystickPOV(joystick, RobotMap.DPAD, RobotMap.DPAD_UP);
  private final Button lowerPOV = new JoystickPOV(joystick, RobotMap.DPAD, RobotMap.DPAD_DOWN);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  // Joystick Control

  public double getLeftJoyY() {
    return joystick.getRawAxis(RobotMap.JOYSTICK_LEFT_UP_AXIS);
  }

  public double getRightJoyY() {
    return joystick.getRawAxis(RobotMap.JOYSTICK_RIGHT_UP_AXIS);
  }

  public double getLeftTrigger() {
    return joystick.getRawAxis(RobotMap.TRIGGER_LEFT_PULL);
  }

  public double getRightTrigger() {
    return joystick.getRawAxis(RobotMap.TRIGGER_RIGHT_PULL);
  }

  //Buttons on Commands
  public OI () {
    // Once we have limit switches for this, we can use these hooks
    // buttonB.whileHeld(new LowerPanelGrabber());
    // buttonB.whenReleased(new RaisePanelGrabber());

    // Until then, we manually position the grabber
    buttonB.whileHeld(new LowerPanelGrabber());
    buttonA.whileHeld(new RaisePanelGrabber());

    rightBumper.whileHeld(new ShootBall());
    leftBumper.whileHeld(new IntakeBall());

    rightTrigger.whileHeld(new RaisePivot());
    leftTrigger.whileHeld(new LowerPivot());

    upperPOV.whileHeld(new RaiseElevator());
    lowerPOV.whileHeld(new LowerElevator());
  }
}
