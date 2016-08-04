package com.example.ryan.hkgankio.designpattern;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 7/25/16.
 */
public class CloseState implements Istate {
    @Override
    public boolean openDoor() {
        Logger.e("电梯打开来了","TEST_DESIGN_PATTERN");
        return true;
    }

    @Override
    public boolean closeDoor() {
        Logger.e("电梯关起来了","TEST_DESIGN_PATTERN");
        return false;
    }

    @Override
    public boolean process() {
        Logger.e("电梯飞起来了","TEST_DESIGN_PATTERN");
        return true;
    }

    @Override
    public boolean procesStop() {
        Logger.e("电梯本来就停着的","TEST_DESIGN_PATTERN");
        return false;
    }
//    @Override
//    public void openDoor() {
//        Logger.e("电梯打开来了","TEST_DESIGN_PATTERN");
//    }
//
//    @Override
//    public void closeDoor() {
//        Logger.e("电梯关起来了","TEST_DESIGN_PATTERN");
//    }
//
//    @Override
//    public void process() {
//        Logger.e("电梯飞起来了","TEST_DESIGN_PATTERN");
//    }
}
