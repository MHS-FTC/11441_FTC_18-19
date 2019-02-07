package org.firstinspires.ftc.teamcode.Robot;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.RobotBase;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.Arm;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.MecanumWheelDrive;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.ParticleGrabber;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.Spartan;

/**
 * Created by Byron.Nice on 8/29/2018.
 */

public class CompRobot extends RobotBase {
    public MecanumWheelDrive drive = new MecanumWheelDrive()
            .setMotorNames("leftFront", "rightFront", "leftBack", "rightBack");//Drives the robot
    public ParticleGrabber grabber = new ParticleGrabber()
            .setMotorNames("CollectorLift","CollectorExtend")
            .setServoNames("intake", "lock");
    public Arm lift= new Arm()
            .setMotorNames("lift");
    public Spartan spartanKicker= new Spartan()
            .setServoNames("kicker");



    public CompRobot() {
        addSubSystem(drive);
        addSubSystem(grabber);
        addSubSystem(lift);
        addSubSystem(spartanKicker);
    }
}
