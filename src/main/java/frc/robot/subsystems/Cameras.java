package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.camera.RunCamera;

public class Cameras extends Subsystem {

    private UsbCamera frontCamera;
    private UsbCamera rearCamera;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new RunCamera());
    }

	public void start(int frontWidth, int frontHeight, int frontFps, int rearWidth, int rearHeight, int rearFps) {
        this.frontCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.FRONT_CAMERA_PORT);
        this.frontCamera.setResolution(frontWidth, frontHeight);
        this.frontCamera.setFPS(frontFps);
        System.out.println("Started camera " + this.frontCamera.getName());

        this.rearCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.REAR_CAMERA_PORT);
        this.rearCamera.setResolution(rearWidth, rearHeight);
        this.rearCamera.setFPS(rearFps);
        System.out.println("Started camera " + this.rearCamera.getName());
	}
}