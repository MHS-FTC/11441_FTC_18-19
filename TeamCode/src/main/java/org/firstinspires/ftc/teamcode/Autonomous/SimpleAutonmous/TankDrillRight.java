package org.firstinspires.ftc.teamcode.Autonomous.SimpleAutonmous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Autonomous.Modules.Wait;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.Robot.CompRobot;

import static org.firstinspires.ftc.teamcode.Utilitys.Constants.*;


/**
 * Created by Byron.Nice on 8/30/2018.
 * DISCRIPTION: Robot drives in a 12" x 12" square. Moves forward, right turn, farward, left turn,
 * backward, left turn, the forward to it's original position.
 */

@Disabled
@Autonomous
public class TankDrillRight extends AutonomousBase {
    private CompRobot bot = new CompRobot();
    private Module[][] steps = new Module[][]{
            {encodeForward(12)}, //Drives forward 12 inches
            {new Wait().setWaitTime(200)}, //Waits for .2 Secs.
            {turnRight90()}, //Turns to the right 90 degrees.
            {encodeForward(12)}, //Drives forward 12 inches
            {new Wait().setWaitTime(200)}, //Waits for .2 Secs.
            {turnLeft90()}, //Turns to the Left 90 degrees.
            {encodeBackward(12)}, //Drives backward 12 inches
            {new Wait().setWaitTime(200)}, //Waits for .2 Secs.
            {turnLeft90()}, //Turns to the Left 90 degrees.
            {encodeForward(12)}, //Drives forward 12 inches
            {new Wait().setWaitTime(200)},//Waits for .2 Secs.
            {turnRight90()}, //Turns to the right 90 degrees.

    };

    @Override
    public void init() {
        init(hardwareMap, bot, steps);
    }
}