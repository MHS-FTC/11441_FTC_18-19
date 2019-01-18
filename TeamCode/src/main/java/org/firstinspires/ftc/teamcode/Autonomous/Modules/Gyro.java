package org.firstinspires.ftc.teamcode.Autonomous.Modules;

import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;

public class Gyro extends Module {
    private boolean isDone = false;
    private int targetDegrees = 0;
    private GyroSensor gyro;
    private boolean calibrate = true;

    private final double midPower = 0.3;
    private final double maxPower = 0.8;
    private final int MAX_ERROR = 4;//degrees

    @Override
    public void start() {
        gyro = robot.hardwareMap.gyroSensor.get("tiltArover");
        gyro.resetZAxisIntegrator();
        if (calibrate) {
            telemetry.addLine("Calibrating Gyro...");
            gyro.calibrate();
            while (gyro.isCalibrating()) {
                //wait for calibration to finish
                telemetry.addLine("Calibrating Gyro...");
            }
        }
    }

    @Override
    public void tick() {
        int currentHeading = gyro.getHeading();
        if (currentHeading > 180) {
            currentHeading = currentHeading - 360;
        }
        int headingError = targetDegrees - currentHeading;
        double driveSteering = headingError * 0.005;

        telemetry.addLine("Current Heading = " + currentHeading);
        telemetry.addLine("Heading Error: " + headingError);
        telemetry.addLine("Steering Error: " + driveSteering);

        double leftPower, rightPower;
        if (headingError < 0) {                  // Turn Left
            leftPower = -midPower + driveSteering;
            rightPower = midPower - driveSteering;
        } else {                                        // Turn Right
            leftPower = midPower + driveSteering;
            rightPower = -midPower - driveSteering;
        }

        leftPower = Range.clip(leftPower, -maxPower, maxPower);
        rightPower = Range.clip(rightPower, -maxPower, maxPower);

        robot.getDriveSystem().driveTank(leftPower, rightPower);

        telemetry.addLine("Left Motor: " + leftPower + " Right Motor: " + rightPower);

        if (Math.abs(headingError) < MAX_ERROR) {
            isDone = true;
        }

    }

    public int stop() {
        robot.getDriveSystem().driveTank(0, 0);//Stop motors before continuing
        return positionInArray;
    }

    @Override
    public boolean isDone() {
        return isDone;
    }

    public Gyro setTurn(int degrees) {
        targetDegrees = -degrees;
        return this;
    }

    public Gyro setCalibrate(boolean cal) {
        calibrate = cal;
        return this;
    }
}