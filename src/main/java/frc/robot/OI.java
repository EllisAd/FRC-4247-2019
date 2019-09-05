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
import frc.robot.commands.manipulator.PullPivotBackward;
import frc.robot.commands.manipulator.PushPivotForward;
import frc.robot.commands.manipulator.RaiseElevator;
import frc.robot.commands.manipulator.RaisePanelGrabber;
import frc.robot.commands.manipulator.ShootBall;
import frc.robot.subsystems.helpers.LogitechController;
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


  private final LogitechController leftController = new LogitechController(RobotMap.LEFT_JOYSTICK);
  private final LogitechController rightController = new LogitechController(RobotMap.RIGHT_JOYSTICK);

  //Buttons on Commands
  public OI () {

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

    // Once we have limit switches for this, we can use these hooks
    // buttonB.whileHeld(new LowerPanelGrabber());
    // buttonB.whenReleased(new RaisePanelGrabber());

    // Until then, we manually position the grabber

    leftController.buttonA.whileHeld(new RaisePanelGrabber());
    leftController.buttonB.whileHeld(new LowerPanelGrabber());

    leftController.leftBumper.whileHeld(new ShootBall());
    leftController.rightBumper.whileHeld(new IntakeBall());

    leftController.dpadUp.whileHeld(new PushPivotForward());
    leftController.dpadDown.whileHeld(new PullPivotBackward());

    leftController.rightTrigger.whileHeld(new RaiseElevator(leftController::getRightTrigger));
    leftController.leftTrigger.whileHeld(new LowerElevator(leftController::getLeftTrigger));

    // TODO Add system to bind dependent on whether two controllers are connected!
  }
}
