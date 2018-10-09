package org.firstinspires.ftc.teamcode.Robot;


import org.firstinspires.ftc.teamcode.FTC_API.Robot.RobotBase;
import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.DriveSystemTemplate;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.TwoWheelDrive;

/**
 * Created by Byron.Nice on 8/29/2018.
 */

public class SimpleRobot extends RobotBase {
    public TwoWheelDrive drive = new TwoWheelDrive()
            .setMotorNames("Left_Motor", "Right_Motor");

    public SimpleRobot() {
        addSubSystem(drive);
    }

    @Override
    public DriveSystemTemplate getDriveSystem() {
        return drive;
    }
}
