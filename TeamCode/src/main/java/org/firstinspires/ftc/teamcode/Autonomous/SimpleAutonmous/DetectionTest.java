package org.firstinspires.ftc.teamcode.Autonomous.SimpleAutonmous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Autonomous.Modules.AllSeeingEyeTest;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.EncoderDrive;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.Robot.CompRobot;

import static org.firstinspires.ftc.teamcode.Utilitys.Constants.DEFAULT_SPEED;

/**
 * Created by Byron.Nice on 1/25/2019.
 * DESCRIPTION: Robot drives forward 12 inches.
 */

@Autonomous(name = "DetectionTest")
public class DetectionTest extends AutonomousBase {
    private CompRobot bot = new CompRobot();
    private final Module [][] steps = new Module[][] {
            { new AllSeeingEyeTest()},
    };



    @Override
    public void init() {
        init(hardwareMap, bot, steps);
    }

    @Override
    public void tick(){
        telemetry.addLine("Left" + bot.drive.getLeftSideMotors()[0].getCurrentPosition() +";"+bot.drive.getLeftSideMotors()[1].getCurrentPosition());
        telemetry.addLine("Right" + bot.drive.getRightSideMotors()[0].getCurrentPosition() +";"+bot.drive.getRightSideMotors()[1].getCurrentPosition());
    }
}
