package org.firstinspires.ftc.teamcode.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.SubSystem;

/**
 * Created by byron.nice on 9/22/2018.
 */



public class ParticleGrabber extends SubSystem {

    private DcMotor collectorLiftMotor;
    private DcMotor collectorExtendMotor;
    private DcMotor intakeMotor;
    private Servo blockServo;



    private String intakeName;
    private String collectorLiftName;
    private String collectorExtendName;
    private String blockName;


    private final double COLLECTOR_EXTEND_SPEED = 0.4;
    private final double COLLECTOR_LIFT_SPEED = 0.6;




    @Override
    public boolean init(HardwareMap hardwareDevices) {
        blockServo = hardwareDevices.servo.get(blockName);
        collectorLiftMotor = hardwareDevices.dcMotor.get(collectorLiftName);
        collectorExtendMotor = hardwareDevices.dcMotor.get(collectorExtendName);
        intakeMotor = hardwareDevices.dcMotor.get(intakeName);
        blockServo.setPosition(0.95);
        return true;
    }

    public void collectorRaise() { collectorLiftMotor.setPower(COLLECTOR_LIFT_SPEED); }

    public void collectorStop() { collectorLiftMotor.setPower(0); }

    public void collectorDown() { collectorLiftMotor.setPower(-COLLECTOR_LIFT_SPEED); }

    public void collectorExtendOut() {
        collectorExtendMotor.setPower(COLLECTOR_EXTEND_SPEED);
    }

    public void collectorExtendIn() { collectorExtendMotor.setPower(-COLLECTOR_EXTEND_SPEED); }

    public void collectorExtendStop() { collectorExtendMotor.setPower(0); }

    public void Intake_In() {intakeMotor.setPower(1);}

    public void Intake_Out() {intakeMotor.setPower(-1);}

    public void Block_Out() {
        blockServo.setPosition(0.05);
    }

    public void Block_In() {
        blockServo.setPosition(0.92);
    }



    public ParticleGrabber setServoNames(String block) {
        blockName = block;
        return this;
    }

    public ParticleGrabber setMotorNames(String collectorLift, String collectorExtend, String intake) {
        collectorLiftName = collectorLift;
        collectorExtendName = collectorExtend;
        intakeName = intake;

        return this;
    }



}
