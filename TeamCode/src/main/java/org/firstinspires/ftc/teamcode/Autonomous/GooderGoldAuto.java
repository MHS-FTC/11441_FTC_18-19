package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Autonomous.Modules.AllSeeingEyeTest;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.DriveTime;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.EncoderDrive;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.Lifter;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.Wait;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.CallFunction;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.Robot.CompRobot;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.Gyro;

import static org.firstinspires.ftc.teamcode.Utilitys.Constants.DEFAULT_SPEED;
import static org.firstinspires.ftc.teamcode.Utilitys.Constants.turn;


@Autonomous
public class GooderGoldAuto extends AutonomousBase {
    private CompRobot bot = new CompRobot();
    private final Module[][] steps = new Module[][]{
            {new AllSeeingEyeTest()},
            {new Lifter()},
            {new Wait().setWaitTime(100)},
            {new EncoderDrive().setDistances(-3,-3).setSpeed(DEFAULT_SPEED)},
            {new Wait().setWaitTime(100)},
            {new DriveTime().setSpeeds(0,0,4).setTime(200)},
            {new Wait().setWaitTime(100)},
            {new EncoderDrive().setDistances(3,3).setSpeed(DEFAULT_SPEED)},
            {new Wait().setWaitTime(100)},
            {new Gyro().setTurn(83).setCalibrate(true)},

            {
                    new Gyro().setTurn(19).setCalibrate(false),
                    new Gyro().setTurn(0).setCalibrate(false),
                    new Gyro().setTurn(-19).setCalibrate(false),
            },
            {
                    new EncoderDrive().setDistances(-35,-35).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(-50,-50).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(-35,-35).setSpeed(DEFAULT_SPEED),
            },
            {
                    new Gyro().setTurn(110).setCalibrate(false),
                    new Gyro().setTurn(160).setCalibrate(false),
                    new Gyro().setTurn(-135).setCalibrate(false),

            },
            {
                    new EncoderDrive().setDistances(23,23).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(0,0).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(23,23).setSpeed(DEFAULT_SPEED),
            },
            {new CallFunction().setFunction(() -> bot.spartanKicker.Spartan_Kick())},
            {new Wait().setWaitTime(500)},
            {
                    new EncoderDrive().setDistances(-24,-24).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(-24,-24).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(-24,-24).setSpeed(DEFAULT_SPEED),
            },
    };

    @Override
    public void init() {
        init(hardwareMap,bot,steps);
    }

    @Override
    public void tick(){
        telemetry.addLine("Left" + bot.drive.getLeftSideMotors()[0].getCurrentPosition() +";"+bot.drive.getLeftSideMotors()[1].getCurrentPosition());
        telemetry.addLine("Right" + bot.drive.getRightSideMotors()[0].getCurrentPosition() +";"+bot.drive.getRightSideMotors()[1].getCurrentPosition());
    }
}

