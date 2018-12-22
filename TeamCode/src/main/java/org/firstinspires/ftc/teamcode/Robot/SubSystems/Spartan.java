package org.firstinspires.ftc.teamcode.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.SubSystem;

public class Spartan extends SubSystem {


    private Servo KickerServo;

    private String KickerName;


    @Override
    public boolean init(HardwareMap hardwareDevices) {
        KickerServo = hardwareDevices.servo.get(KickerName);
        KickerServo.setPosition(0.95);
        return true;
    }

    public void Spartan_Kick(){
        KickerServo.setPosition(0.05);
    }

    public void Spartan_Retreat() {
        KickerServo.setPosition(0.95);
    }


    public Spartan setServoNames(String kicker) {
        KickerName = kicker;
        return this;
    }
}
