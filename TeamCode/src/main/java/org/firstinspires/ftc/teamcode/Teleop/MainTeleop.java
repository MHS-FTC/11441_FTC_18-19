package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.teamcode.Robot.CompRobot;

/**
 * Created by Byron.Nice on 8/25/2018.
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
    }

}