package org.firstinspires.ftc.teamcode.Autonomous.Modules;

import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;

/**
 * Created by Byron.Nice on 8/30/2018.
 */

public class Wait extends Module {
    private double startTime;
    private long waitTime = 31000;

    public Wait setWaitTime(long waitTime) {
        this.waitTime = waitTime;
        return this;
    }

    @Override
    public void start() {
        startTime = robot.getTimeMilliseconds();
    }

    @Override
    public void tick() {
    }//Just here because it is required

    @Override
    public boolean isDone() {
        return (startTime + waitTime) < robot.getTimeMilliseconds();
    }

    @Override
    public String[] requiredSubSystems() {
        return new String[0];
    }
}
