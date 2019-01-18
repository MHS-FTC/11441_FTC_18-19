package org.firstinspires.ftc.teamcode.Autonomous.SimpleAutonmous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Autonomous.Modules.EncoderDrive;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.Wait;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.Robot.CompRobot;

import static org.firstinspires.ftc.teamcode.Utilitys.Constants.DEFAULT_SPEED;

/**
 * Created by Byron.Nice on 8/30/2018.
 * DESCRIPTION: Robot drives forward 12 inches, waits, then drives backwards 12 inches.
 */

@Disabled
@Autonomous
public class ForwardBack extends AutonomousBase {
    private CompRobot bot = new CompRobot();
    private final Module[][] steps = new Module[][] {
            {new Wait().setWaitTime(1000)}, //Waits and holds for 1 sec.
            {new EncoderDrive().setDistances(12,12).setSpeed(DEFAULT_SPEED)}, //Drives Forward for 12 inches at default speed.
            {new Wait().setWaitTime(1000)}, //Waits and holds for 1 sec.
            {new EncoderDrive().setDistances(-12,-12).setSpeed(DEFAULT_SPEED)} //Drives backward for 12 inches at default speed.
    };



    @Override
    public void init() {
        init(hardwareMap, bot, steps);
    }
}
