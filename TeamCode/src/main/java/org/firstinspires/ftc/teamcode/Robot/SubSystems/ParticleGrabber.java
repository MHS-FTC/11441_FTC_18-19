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

    private DcMotor spinner;

    private String spinnerName;
    private final double SPINNER_SPEED= 0.5;

    @Override
    public boolean init(HardwareMap hardwareDevices) {
        spinner = hardwareDevices.dcMotor.get(spinnerName);
        return true;
    }

    public void startSpinner() {
        spinner.setPower(SPINNER_SPEED);
    }
    public void stopSpinner() {
        spinner.setPower(0);
    }
    public void reverseSpinner() {
        spinner.setPower(-SPINNER_SPEED);
    }

    public ParticleGrabber setMotorNames(String spinner) {
        spinnerName = spinner;
        return this;
    }

}
