package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot.SimpleRobot;

/**
 * Created by Byron.Nice on 9/7/2018.
 * DESCRIPTION: This program is for our show bot. It is just a basic tank drive system.
 */

public class ShowBotTeleop extends OpMode {
    private SimpleRobot robot = new SimpleRobot();


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
        robot.drive.driveTank(-gamepad1.left_stick_y, gamepad1.right_stick_y);

    }

}