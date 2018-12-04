package org.firstinspires.ftc.teamcode.Robot.SubSystems;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.SubSystem;

/**
 * Created by byron.nice on 10/15/2018.
 * Ethan Hampton Was Here! Please Remove This Line Cuz The Capitalization Sucks
 */


@Disabled
public class BallLifter extends SubSystem {

    private DcMotor ballLiftMotor;

    private Servo dumpServo;

    private String ballLiftName;
    private String dumpName;
    private final double BALL_LIFT_SPEED = 1;


    @Override
    public boolean init(HardwareMap hardwareDevices) {
        ballLiftMotor = hardwareDevices.dcMotor.get(ballLiftName);
        dumpServo = hardwareDevices.servo.get(dumpName);
        dumpServo.setPosition(0.05);
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