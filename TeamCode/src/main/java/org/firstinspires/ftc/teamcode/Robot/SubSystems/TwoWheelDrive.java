package org.firstinspires.ftc.teamcode.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.DriveSystemTemplate;

public class TwoWheelDrive extends DriveSystemTemplate {

    protected DcMotor leftMotor;
    protected DcMotor rightMotor;

    public static final String ID = "TwoWheelDrive";


    private String LeftMotor;
    private String RightMotor;


    @Override
    public boolean init(HardwareMap hardwareDevices) {
        leftMotor = hardwareDevices.dcMotor.get("leftMotor");
        rightMotor = hardwareDevices.dcMotor.get("rightMotor");
        return true;
    }

    public TwoWheelDrive setMotorNames(String left, String right) {
        LeftMotor = left;
        RightMotor = right;
        return this;
    }


    @Override
    public DcMotor[] getMotors() {
        return new DcMotor[0];
    }

    @Override
    public void driveTank(double leftPower, double rightPower) {
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }

    @Override
    public void driveArcade(double forward, double turn) {
        double left = forward + turn;
        double right = forward - turn;

        driveTank(left, right);
    }

    @Override
    public void driveMecanum(double forward, double turn, double strafe) {
        driveArcade(forward, turn);
    }


    //@Override
    public DcMotor[] getRightSideMotors() {
        return new DcMotor[]{rightMotor};
    }

    //@Override
    public DcMotor[] getLeftSideMotors() {
        return new DcMotor[]{leftMotor};
    }
}
