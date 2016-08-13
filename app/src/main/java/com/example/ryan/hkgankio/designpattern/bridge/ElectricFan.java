package com.example.ryan.hkgankio.designpattern.bridge;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 8/12/16.
 */
public class ElectricFan extends Appliance {

    private int level = 0;
    @Override
    public void setUpLevel(int level){
        if (!isOpen) {
            Logger.e("TEST_DESIGN_PATTERN fan has turn off,can`t setup volume");
            return;
        }
        this.level = level;
        Logger.e("TEST_DESIGN_PATTERN fan volume = %s",level);
    }

    @Override
    void setUpVolume(int volume) {
        Logger.e("TEST_DESIGN_PATTERN it is a Fan, can`t setup volume");
    }

    @Override
    void setSwitch(boolean set) {
        isOpen = set;
        Logger.e("TEST_DESIGN_PATTERN Fan setSwitch = %s",isOpen);
    }
}
