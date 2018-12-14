package org.firstinspires.ftc.teamcode.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.SubSystem;

public class Spartan extends SubSystem {


    private Servo spartanKickerServo;

    private String spartanKickerName;



    @Override
    public boolean init(HardwareMap hardwareDevices) {
        spartanKickerServo = hardwareDevices.servo.get(spartanKickerName);
        spartanKickerServo.setPosition(0.05);
        return true;
    }

    public Spartan setServoNames(String kicker) {
        spartanKickerName = kicker;
        return this;
    }
}
