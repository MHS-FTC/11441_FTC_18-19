package org.firstinspires.ftc.teamcode.Robot;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.RobotBase;
import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.DriveSystemTemplate;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.Arm;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.BallLifter;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.MecanumWheelDrive;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.ParticleGrabber;

/**
 * Created by Byron.Nice on 8/29/2018.
 */

public class CompRobot extends RobotBase {
    public MecanumWheelDrive drive = new MecanumWheelDrive()
            .setMotorNames("leftFront", "rightFront", "leftBack", "rightBack");//Drives the robot
    public ParticleGrabber grabber= new ParticleGrabber()
            .setMotorNames("Spinner");
    public Arm lift= new Arm()
            .setMotorNames("lift");
    public BallLifter lifterBall= new BallLifter()
            .setMotorNames("ballLift");

    public CompRobot() {
        addSubSystem(drive);
        addSubSystem(grabber);
        addSubSystem(lift);
        addSubSystem(lifterBall);

    }
}
