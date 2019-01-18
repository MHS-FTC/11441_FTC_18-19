package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.EncoderDrive;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.Wait;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.CallFunction;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.Robot.CompRobot;
import org.firstinspires.ftc.teamcode.Robot.SubSystems.Spartan;

import static org.firstinspires.ftc.teamcode.Utilitys.Constants.DEFAULT_SPEED;
import static org.firstinspires.ftc.teamcode.Utilitys.Constants.turn;
import static org.firstinspires.ftc.teamcode.Utilitys.Constants.turnRight90;

/**
 * Created by logan.shurts on 11/26/2018.
 */

@Disabled
@Autonomous
public class GoldDepotCrater extends AutonomousBase {
    private CompRobot bot = new CompRobot();
    private final Module[][] steps = new Module[][]{
            {new Wait().setWaitTime(500)},
            {turn(90)},
            {new Wait().setWaitTime(200)},
            {new EncoderDrive().setDistances(-55, -55).setSpeed(DEFAULT_SPEED)},
            {new Wait().setWaitTime(200)},
            {new CallFunction().setFunction(() -> bot.spartanKicker.Spartan_Kick())},
            {new Wait().setWaitTime(1000)},
            {new CallFunction().setFunction(() -> bot.spartanKicker.Spartan_Retreat())},
            {turn(-45)},
            {new EncoderDrive().setDistances(110, 110).setSpeed(DEFAULT_SPEED)},
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

