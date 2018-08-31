package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Autonomous.Modules.EncoderDrive;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;

/**
 * Created by Byron.Nice on 8/25/2018.
 * DESCRIPTION: These constants are used to simplify programing by keeping them consistent
 * throughout the project. They shorten the code using modules.
 */

public class Constants {
    public static Module forward = new ByronSucks().setSpeeds(1,1).setTime(2000); //Moves forward at full power for 2 sec.
    public static Module turn = new ByronSucks().setSpeeds(0.5, 0.9).setTime(2500); //Turns the robot to the left.
    public static double DEFAULT_SPEED = 0.75; //Sets default speed to 0.75 power
    public static double WHEEL_CIRCUMFERENCE = 4 * Math.PI; //Gives circumference for wheel to calculate distance.
    public static final double TURN_DISTANCE_90 = 17;// Inches wheel turns in a 90 degree turn.


    public static Module encodeForward(double distance) {  //Drives forward, using Encoders, a set imputed distance.
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(distance,distance);
    }


    public static Module encodeBackward(double distance) { //Drives forward, using Encoders, a set imputed distance.
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(-distance,-distance);
    }


    public static Module turnRight90() { //Turns 90 degrees to the right.
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(TURN_DISTANCE_90, -TURN_DISTANCE_90);
    }


    public static Module turnLeft90() { //Turns 90 degrees to the Left.
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(-TURN_DISTANCE_90, TURN_DISTANCE_90);
    }

    public static Module turn180() { //Turns 180 degrees to the Right.
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(TURN_DISTANCE_90*2, -TURN_DISTANCE_90*2);
    }


    public static Module turn(int degrees) { //Turns "x" amount of degrees to the Right.
        if (degrees > 360 || degrees < -360) {
            return null;
        }
        final double distancePer = TURN_DISTANCE_90 /90;
        double distance = distancePer * degrees;
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(distance, -distance);
    }
}
