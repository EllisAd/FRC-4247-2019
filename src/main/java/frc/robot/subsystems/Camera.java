package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.camera.RunCamera;

public class Camera extends Subsystem {

    private UsbCamera camera;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new RunCamera());
    }

	public void start(int width, int height, int fps) {
        this.camera = CameraServer.getInstance().startAutomaticCapture();
        this.camera.setResolution(width, height);
        this.camera.setFPS(fps);
        System.out.println("Started camera " + this.camera.getName());
	}
}