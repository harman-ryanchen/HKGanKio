package com.example.ryan.hkgankio.designpattern.state;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 7/26/16.
 */
public class StopProcessState implements Istate {
    @Override
    public boolean openDoor() {
        Logger.e("电梯打开来了","TEST_DESIGN_PATTERN");
        return true;
    }

    @Override
    public boolean closeDoor() {
        Logger.e("电梯还在关着呢了","TEST_DESIGN_PATTERN");
        return true;
    }

    @Override
    public boolean process() {
        Logger.e("电梯继续走","TEST_DESIGN_PATTERN");
        return true;
    }

    @Override
    public boolean procesStop() {
        Logger.e("电梯还在停着呢了","TEST_DESIGN_PATTERN");
        return false;
    }
}
