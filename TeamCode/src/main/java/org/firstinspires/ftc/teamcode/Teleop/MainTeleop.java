package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.Robot.CompRobot;

/**
 * Created by Byron.Nice on 8/25/2018.
 * DESCRIPTION: This program is the main program for teleop. This uses the robot base and adds some
 * other basic functions.
 */


@TeleOp(name = "Teleop")
public class MainTeleop extends OpMode {
    private CompRobot robot = new CompRobot();

    //@Override
    public void init() {
        robot.init(hardwareMap);
        //robot.start();
    }

    //@Override
    public void loop() {
        robot.tick();

        //drive the robot (in order, forward backward, rotate)
        //NOTE: Y direction of joysticks needs to be reversed
        robot.drive.driveMecanum(-gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);

        double extendInput = -gamepad2.left_stick_y;

        if (gamepad1.dpad_up) {
            robot.lift.liftUp();
        }
        else if (gamepad1.dpad_down) {
            robot.lift.liftDown();
        }
        else {
            robot.lift.stopLift();
        }


        if (gamepad1.x) {
            robot.grabber.startSpinner();
        } else if (gamepad1.a) {
            robot.grabber.reverseSpinner();
        } else {
            robot.grabber.stopSpinner();
        }
    }
}