/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;



  // Joysticks
  public static int JOYSTICK = 0;

  public static int JOYSTICK_LEFT_SIDE_AXIS = 0;
  public static int JOYSTICK_LEFT_UP_AXIS = 1;
  public static int JOYSTICK_RIGHT_SIDE_AXIS = 4;
  public static int JOYSTICK_RIGHT_UP_AXIS = 5;

  // Buttons
  public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 4;
	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUMPER_RIGHT = 5;
  public static final int BUMPER_LEFT = 6;
  
  //Triggers
  public static int TRIGGER_RIGHT_PULL = 3;
  public static int TRIGGER_LEFT_PULL = 2;
  
  //POVs
  public static final int DPAD = 0;
  public static final int DPAD_UP = 0;
  public static final int DPAD_DOWN = 180;

  // Motor ports
  public static final int LEFT_MOTOR_CANBUS_PORT = 1;
  public static final int RIGHT_MOTOR_CANBUS_PORT = 2;
  public static final int PANEL_GRABBER_CANBUS_PORT = 3;
  public static final int ELEVATOR_CANBUS_PORT = 4;
  public static final int SHOOTER_CANBUS_PORT = 5;
  public static final int PIVOT_CANBUS_PORT = 6;

  // Sensor ports (TODO Add these!)
  public static final int PANEL_GRABBER_HIGH_SWITCH_PORT = 0;
  public static final int PANEL_GRABBER_LOW_SWITCH_PORT = 1;
  public static final int ELEVATOR_HIGH_SWITCH_PORT = 2;
  public static final int ELEVATOR_LOW_SWITCH_PORT = 3;
  public static final int PIVOT_FORWARD_SWITCH_PORT = 4;
  public static final int PIVOT_BACKWARD_SWITCH_PORT = 5;
}
