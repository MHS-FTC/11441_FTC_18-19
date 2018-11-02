package org.firstinspires.ftc.teamcode.Robot.SubSystems;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.SubSystem;

/**
 * Created by byron.nice on 9/22/2018.
 */



public class ParticleGrabber extends SubSystem {

    private DcMotor collectorLiftMotor;
    private Servo spinnerServo;

    private String spinnerName;
    private String collectorLiftName;

    private final double COLLECTOR_LIFT_SPEED = 0.5;


    @Override
    public boolean init(HardwareMap hardwareDevices) {
        spinnerServo = hardwareDevices.servo.get(spinnerName);
        collectorLiftMotor = hardwareDevices.dcMotor.get(collectorLiftName);
        return true;
    }

    public void collectorLiftUp() {
        collectorLiftMotor.setPower(COLLECTOR_LIFT_SPEED);
    }

    public void collectorLiftDown() {
        collectorLiftMotor.setPower(-COLLECTOR_LIFT_SPEED);
    }

    public void collectorLiftStop() {
        collectorLiftMotor.setPower(0);
    }


    public void intake() {
        double position = spinnerServo.getPosition()+0.005;
        spinnerServo.setPosition(position);
    }
    public void spit() {
        double position = spinnerServo.getPosition()-0.005;
        spinnerServo.setPosition(position);
    }

    public void stop() {
        double stop = spinnerServo.getPosition();
        spinnerServo.setPosition(stop);
    }

    public ParticleGrabber setServoNames(String spinner) {
        spinnerName = spinner;
        return this;
    }

    public ParticleGrabber setMotorNames(String collectorLift) {
        collectorLiftName = collectorLift;
        return this;
    }

}
