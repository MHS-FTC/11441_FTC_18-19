package org.firstinspires.ftc.teamcode.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.SubSystem;

/**
 * Created by byron.nice on 10/15/2018.
 */

public class BallLifter extends SubSystem {

    private DcMotor ballLiftMotor;

    private Servo dump;

    private String ballLiftName;
    private String dumpName;
    private final double BALL_LIFT_SPEED = 1;


    @Override
    public boolean init(HardwareMap hardwareDevices) {
        ballLiftMotor = hardwareDevices.dcMotor.get(ballLiftName);
        dump = hardwareDevices.servo.get(dumpName);
        ballLiftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        return true;
    }

    public void ballRaise() {
        ballLiftMotor.setPower(BALL_LIFT_SPEED);
    }

    public void ballStop() {
        ballLiftMotor.setPower(0);
    }

    public void ballDown() {
        ballLiftMotor.setPower(-BALL_LIFT_SPEED);


    }

    public BallLifter setMotorNames(String ballLift) {
        ballLiftName = ballLift;
        return this;
    }

    public BallLifter setServoNames(String dump) {
        dumpName = dump;
        return this;
    }
}