package org.firstinspires.ftc.teamcode.Utilitys;

/**
 * Created by byron.nice on 9/8/2018.
 */

public enum Direction {
    LEFT, RIGHT, MIDDLE, UP, DOWN, FORWARD, BACKWARDS, UNKNOWN, BOTTOM, TOP;

    public static Direction getOpposite(Direction currentlyPointing) {
        switch (currentlyPointing) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case MIDDLE:
                return UNKNOWN;
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case FORWARD:
                return BACKWARDS;
            case BACKWARDS:
                return FORWARD;
            case UNKNOWN:
                return UNKNOWN;
        }
        return null;
    }
}
