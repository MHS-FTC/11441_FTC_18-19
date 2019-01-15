/*

package org.firstinspires.ftc.teamcode.Autonomous.Modules;

import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;

public class MechGyro extends Module {
    private boolean isDone = false;
    private int targetDegrees = 0;
    private GyroSensor gyro;
    private boolean calibrate = true;
    private int targetStrafe = 0;

    private final double midPower = 0.3;
    private final double maxPower = 0.8;
    private final int MAX_ERROR = 4;//degrees

    @Override
    public void start() {
        gyro = robot.hardwareMap.gyroSensor.get("gyro");
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
        int strafe = targetStrafe;
        double driveSteering = headingError * 0.005;

        telemetry.addLine("Current Heading = " + currentHeading);
        telemetry.addLine("Heading Error: " + headingError);
        telemetry.addLine("Steering Error: " + driveSteering);

        double frontLeft, rearLeft, frontRight, rearRight;
        if (headingError < 0 && strafe > 0) {                  // Turn Left
            ri = -midPower - driveSteering;
            turn = midPower + driveSteering;
            strafe =
        } else {                                        // Turn Right
            forward = midPower + driveSteering;
            turn = -midPower - driveSteering;
        }

        forward = Range.clip(forward, -maxPower, maxPower);
        turn = Range.clip(turn, -maxPower, maxPower);

        robot.getDriveSystem().driveMecanum(forward, turn, strafe);

        telemetry.addLine("Left Motor: " + forward + " Right Motor: " + turn);

        if (Math.abs(headingError) < MAX_ERROR) {
            isDone = true;
        }

    }

    public int stop() {
        robot.getDriveSystem().driveMecanum(0, 0, 0);//Stop motors before continuing
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

    public Gyro setStrafe (int strafeSpeed) {
        targetStrafe = strafeSpeed;
        return this;
    }


    public Gyro setCalibrate(boolean cal) {
        calibrate = cal;
        return this;
    }
}


*/
