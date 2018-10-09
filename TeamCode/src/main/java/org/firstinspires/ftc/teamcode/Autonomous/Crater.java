package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Autonomous.Modules.EncoderDrive;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.Wait;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.Robot.CompRobot;

import static org.firstinspires.ftc.teamcode.Utilitys.Constants.DEFAULT_SPEED;
import static org.firstinspires.ftc.teamcode.Utilitys.Constants.turn;
import static org.firstinspires.ftc.teamcode.Utilitys.Constants.turnRight90;

/**
 * Created by byron.nice on 10/8/2018.
 */

@Autonomous
public class Crater extends AutonomousBase {
    private CompRobot bot = new CompRobot();
    private Module[][] steps = new Module[][]{
            {},
            {new Wait().setWaitTime(500)},
            {new EncoderDrive().setDistances(-30,-30).setSpeed(DEFAULT_SPEED)},
            {new Wait().setWaitTime(200)},
            {turnRight90()},
            {new EncoderDrive().setDistances(50,50).setSpeed(DEFAULT_SPEED)}
    };

    @Override
    public void init() {

    }
}

