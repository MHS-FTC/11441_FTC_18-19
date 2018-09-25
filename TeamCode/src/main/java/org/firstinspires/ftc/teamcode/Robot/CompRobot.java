package org.firstinspires.ftc.teamcode.Robot;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.RobotBase;
import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.DriveSystemTemplate;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.MecanumWheelDrive;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.ParticleGrabber;

/**
 * Created by Byron.Nice on 8/29/2018.
 */

public class CompRobot extends RobotBase {
    public MecanumWheelDrive drive = new MecanumWheelDrive()
            .setMotorNames("leftFront", "rightFront", "leftBack", "rightBack");//Drives the robot
    public ParticleGrabber grabber= new ParticleGrabber().setMotorNames("Spinner");

    public CompRobot() {
        addSubSystem(drive);
        addSubSystem(grabber);
    }

    /**
     * @return the implementation of the drive system this robot uses
     */
    @Override
    public DriveSystemTemplate getDriveSystem() {
        return drive;
    }
}
