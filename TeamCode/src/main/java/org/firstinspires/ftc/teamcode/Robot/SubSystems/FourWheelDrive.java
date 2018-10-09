package org.firstinspires.ftc.teamcode.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.DriveSystemTemplate;

/**
 * Created by Byron.Nice on 8/30/2018.
 */

public class FourWheelDrive extends DriveSystemTemplate {

    protected DcMotor leftFrontMotor;
    protected DcMotor rightFrontMotor;
    protected DcMotor leftBackMotor;
    protected DcMotor rightBackMotor;

    public static final String ID = "FourWheelDrive";

    private String leftFrontMotorName;
    private String RightFrontMotorName;
    private String leftBackMotorName;
    private String RightBackMotorName;

    @Override
    public boolean init(HardwareMap hardwareDevices) {
        leftFrontMotor = hardwareDevices.dcMotor.get("leftFrontMotor");
        rightFrontMotor = hardwareDevices.dcMotor.get("rightFrontMotor");
        leftBackMotor = hardwareDevices.dcMotor.get("leftBackMotor");
        rightBackMotor = hardwareDevices.dcMotor.get("rightBackMotor");

        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        return true;
    }

    public FourWheelDrive setMotorNames(String leftFront, String rightFront, String leftBack, String rightBack) {
        leftFrontMotorName = leftFront;
        RightFrontMotorName = rightFront;
        leftBackMotorName = leftBack;
        RightBackMotorName = rightBack;
        return this;
    }


    @Override
    public DcMotor[] getMotors() {
        return new DcMotor[0];
    }

    /**
     * @param leftPower  how fast the left motors should go
     * @param rightPower how fast the right motors should go
     */
    public void driveTank(double leftPower, double rightPower) {
        leftFrontMotor.setPower(leftPower);
        leftBackMotor.setPower(leftPower);
        rightFrontMotor.setPower(rightPower);
        rightBackMotor.setPower(rightPower);
    }

    /**
     * TODO: should dead zone joystick to insure we are not burning out motors
     *
     * @param forward how much to go forward and backwards, from -1 to 1, 1 is full forwards
     * @param rotate  how much to rotate, from -1 to 1, 1 is full right
     */
    public void driveArcade(double forward, double rotate) {
        double left = forward + rotate;
        double right = forward - rotate;

        driveTank(left, right);
    }

    @Override
    public void driveMecanum(double forward, double turn, double strafe) {
        driveArcade(forward, turn);
    }

    //@Override
    public DcMotor[] getRightSideMotors() {
        return new DcMotor[]{rightFrontMotor, rightBackMotor};
    }

    //@Override
    public DcMotor[] getLeftSideMotors() {
        return new DcMotor[]{rightFrontMotor, rightBackMotor};
    }

    //@Override

}
