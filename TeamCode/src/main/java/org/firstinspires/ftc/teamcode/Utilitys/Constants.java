package org.firstinspires.ftc.teamcode.Utilitys;

import org.firstinspires.ftc.teamcode.Autonomous.Modules.EncoderDrive;
import org.firstinspires.ftc.teamcode.TeamDriveTime;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;

/**
 * Created by Byron.Nice on 8/25/2018.
 * DESCRIPTION: These constants are used to simplify programing by keeping them consistent
 * throughout the project. They shorten the code using modules.
 */

public class Constants {
    public static Module forward = new TeamDriveTime().setSpeeds(1,1).setTime(2000);   //Moves forward at full power for 2 sec.
    public static Module turn = new TeamDriveTime().setSpeeds(0.5, 0.9).setTime(2500); //Turns the robot to the left.
    public static double DEFAULT_SPEED = 1;                                                  //Sets default speed to 0.75 power
    public static double WHEEL_CIRCUMFERENCE = 4 * Math.PI;                                     //Gives circumference for wheel to calculate distance.
    public static final double TURN_DISTANCE_90 = 21;                                           // Inches wheel turns in a 90 degree turn.
    public static final String VUFORIA_LICENCE_KEY = "AeC5/bT/////AAABmQO1uzUab0hyuJhIBQOAvJhHHNX0ASWHAXfXxBtkH3P6l30sMIctcnMZon08tDxmpzrxBOprXwaN6YOpPwg4jXvlx8NzxH6sIoErS+7xhtD1xUv27NLDMWBShjkk7vLOjFioSw2u/5SqDg2w9Z3FvRGRJCjQGKTKCoDlvNpLQRpGWg1izC8uwoL9q+2CX/CN0DELxknUZTP2bvn/MN+QxGxLDgWQ/JXqVCdVrR5XLCMNJgfitJlzQQMPCQ8hjRoD8FPgTmbe3XaQQvnbU68wZRiMvgAYs6ftAv0pzgNBmHMHD1nJmjSPAG3+fWRBKSHoXozXuUsGYl4/qY5UeBGEjnXaxMDqyOaNPAaaf8aK20IE";
    public static final double BILDA_MOTOR_TICKS_PER_REV = 146.6;
    //public static double LEAD_SCREW_TPI = 12;
    //public static double LIFT_DISTANCE = LEAD_SCREW_TPI * ;


    public static Module encodeForward(double distance) {                                       //Drives forward, using Encoders, a set imputed distance.
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(distance,distance);
    }


    public static Module encodeBackward(double distance) {                                     //Drives forward, using Encoders, a set imputed distance.
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(-distance,-distance);
    }


    public static Module turnRight90() {                                                       //Turns 90 degrees to the right.
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(TURN_DISTANCE_90, -TURN_DISTANCE_90);
    }


    public static Module turnLeft90() {                                                        //Turns 90 degrees to the Left.
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(-TURN_DISTANCE_90, TURN_DISTANCE_90);
    }

    public static Module turn180() {                                                          //Turns 180 degrees to the Right.
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(TURN_DISTANCE_90*2, -TURN_DISTANCE_90*2);
    }


    public static Module turn(int degrees) {                                                 //Turns "x" amount of degrees to the Right.
        if (degrees > 360 || degrees < -360) {
            return null;
        }
        final double distancePer = TURN_DISTANCE_90 /90;
        double distance = distancePer * degrees;
        return new EncoderDrive().setSpeed(DEFAULT_SPEED).setDistances(distance, -distance);
    }
}
