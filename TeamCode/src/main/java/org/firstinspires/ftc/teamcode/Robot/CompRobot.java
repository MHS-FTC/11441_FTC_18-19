package org.firstinspires.ftc.teamcode.Robot;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.RobotBase;
import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.DriveSystemTemplate;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.MecanumWheelDrive;

/**
 * Created by Byron.Nice on 8/29/2018.
 */

public class CompRobot extends RobotBase {
    public MecanumWheelDrive drive = new MecanumWheelDrive()
            .setMotorNames("leftFront", "rightFront", "leftBack", "rightBack");//Drives the robot

    public CompRobot() {
        addSubSystem(drive);

    }

    /**
     * @return the implementation of the drive system this robot uses
     */
    @Override
    public DriveSystemTemplate getDriveSystem() {
        return drive;
    }
}
