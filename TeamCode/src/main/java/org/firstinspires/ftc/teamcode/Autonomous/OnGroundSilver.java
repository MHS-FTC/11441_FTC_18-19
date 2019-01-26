package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Autonomous.Modules.AllSeeingEyeTest;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.EncoderDrive;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.Robot.CompRobot;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.Gyro;

import static org.firstinspires.ftc.teamcode.Utilitys.Constants.DEFAULT_SPEED;


@Autonomous
public class OnGroundSilver extends AutonomousBase {
    private CompRobot bot = new CompRobot();
    private final Module[][] steps = new Module[][]{
            {new AllSeeingEyeTest()},
            {
                    new Gyro().setTurn(19).setCalibrate(false),
                    new Gyro().setTurn(0).setCalibrate(false),
                    new Gyro().setTurn(-19).setCalibrate(false),
            },
            {
                    new EncoderDrive().setDistances(-38,-38).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(-35,-35).setSpeed(DEFAULT_SPEED),
                    new EncoderDrive().setDistances(-38,-38).setSpeed(DEFAULT_SPEED),
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

