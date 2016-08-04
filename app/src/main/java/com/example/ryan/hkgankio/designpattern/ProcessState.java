package com.example.ryan.hkgankio.designpattern;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 7/25/16.
 */
public class ProcessState implements Istate{
    @Override
    public boolean openDoor() {
        Logger.e("电梯运行中不能打开","TEST_DESIGN_PATTERN");
        return false;
    }

    @Override
    public boolean closeDoor() {
        Logger.e("电梯已经关着门飞起来了","TEST_DESIGN_PATTERN");
        return false;
    }

    @Override
    public boolean process() {
        Logger.e("电梯已经关着门飞起来了","TEST_DESIGN_PATTERN");
        return false;
    }

    @Override
    public boolean procesStop() {
        Logger.e("电梯停下起来了","TEST_DESIGN_PATTERN");
        return true;
    }
//    @Override
//    public void openDoor() {
//        Logger.e("电梯运行中不能打开","TEST_DESIGN_PATTERN");
//    }
//
//    @Override
//    public void closeDoor() {
//        Logger.e("电梯已经关着门飞起来了","TEST_DESIGN_PATTERN");
//    }
//
//    @Override
//    public void process() {
//        Logger.e("电梯已经在运行中","TEST_DESIGN_PATTERN");
//    }
}
