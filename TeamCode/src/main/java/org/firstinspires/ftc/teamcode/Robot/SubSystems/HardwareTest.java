package org.firstinspires.ftc.teamcode.Robot.SubSystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.SubSystem;

/**
 * Created by byron.nice on 2/02/2019.
 */

/*
public class HardwareTest extends SubSystem {
    private DcMotor testMotor;
    private double speed;
    private double startTime;

    private int driveTime;


    private String testName;



    @Override
    public boolean init(HardwareMap hardwareDevices) {
        testMotor = hardwareDevices.dcMotor.get(testName);

        testMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        testMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        return true;
    }

    @Override
    public void start() {
        startTime = HardwareTest.getTimeMilliseconds();

    }

    @Override
    public void tick() {
        if ((r.getTimeMilliseconds() - startTime) > driveTime) {
            isDone = true;
        }
    }


    public HardwareTest setMotorNames(String testMotor) {
        testName = testMotor;
        return this;
    }

    public DcMotor getMotor(){
        return testMotor;
    }

    public void setMotorSpeed(double s){
        speed = s;
        testMotor.setPower(s);
    }

    public void setMotorTargetPosition(double rotations){
        testMotor.setTargetPosition((int) (rotations * testMotor.getMotorType().getTicksPerRev()));
        testMotor.setPower(speed);
    }

    public void setMotorMode(DcMotor.RunMode mode){
        testMotor.setMode(mode);
    }

    public HardwareTest setTime(int time) {
        driveTime = time;
        return this;
    }

    public void motorPowerTest (){
        {testMotor.setPower(.25);},
        {testMotor.setPower(.5)},
        {testMotor.setPower(.75)},
        {testMotor.setPower (1)};

    }
}
*/