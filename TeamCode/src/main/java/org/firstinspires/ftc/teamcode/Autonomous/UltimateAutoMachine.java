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

import static org.firstinspires.ftc.teamcode.Utilitys.Constants.DEFAULT_SPEED;
import static org.firstinspires.ftc.teamcode.Utilitys.Constants.turn;


@Autonomous
public class UltimateAutoMachine extends AutonomousBase {
    private CompRobot bot = new CompRobot();
    private final Module[][] steps = new Module[][]{
            {new Wait().setWaitTime(500)},
            {new Lifter()},
            {new Wait().setWaitTime(200)},
            {new EncoderDrive().setDistances(-3,-3).setSpeed(DEFAULT_SPEED)},
            {new DriveTime().setSpeeds(0,0,4).setTime(200)},
            {new Wait().setWaitTime(200)},
            {new EncoderDrive().setDistances(3,3).setSpeed(DEFAULT_SPEED)},
            {turn(-80)},
            {new AllSeeingEyeTest()},
            {
                    turn(-23),
                    turn(0),
                    turn(23),
            },
            {
                    new EncoderDrive().setDistances(-36,-36).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(-50,-50).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(-37,-37).setSpeed(DEFAULT_SPEED),
            },
            {
                    turn(45),
                    turn(-30),
                    turn(-60),

            },
            {
                    new EncoderDrive().setDistances(-27,-27).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(-9.5,-9.5).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(-34.5,-34.5).setSpeed(DEFAULT_SPEED),
            },
            {
                    turn(30),
                    turn(90),
                    turn(90),
            },
            {new Wait().setWaitTime(200)},
            {new CallFunction().setFunction(() -> bot.spartanKicker.Spartan_Kick())},
            {new Wait().setWaitTime(1000)},
            {new CallFunction().setFunction(() -> bot.spartanKicker.Spartan_Retreat())},
            {new Wait().setWaitTime(200)},
            {new EncoderDrive().setDistances(70,70).setSpeed(DEFAULT_SPEED)},
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
