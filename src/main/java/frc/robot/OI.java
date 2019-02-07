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
  private final Button rightTrigger = new JoystickButton(joystick, RobotMap.TRIGGER_RIGHT_PULL);
  private final Button leftTrigger = new JoystickButton(joystick, RobotMap.TRIGGER_LEFT_PULL);

  //POV Setup



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

  //Buttons on Commands
  public OI () {
    buttonB.whileHeld(new LowerPanelGrabber());
    buttonB.whenReleased(new RaisePanelGrabber());

    buttonA.whileHeld(new ShootBall());
    leftBumper.whileHeld(new IntakeBall());

    rightTrigger.whileHeld(new RaisePivot());
    leftTrigger.whileHeld(new LowerPivot());

    rightBumper.whileHeld(new OpenClaw());


  }
}
