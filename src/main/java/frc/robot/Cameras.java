package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.RobotMap;

public class Cameras {

    private UsbCamera frontCamera;
    private UsbCamera rearCamera;

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