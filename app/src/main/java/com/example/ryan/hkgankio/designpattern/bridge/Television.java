package com.example.ryan.hkgankio.designpattern.bridge;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 8/12/16.
 */
public class Television extends Appliance{

    private int volume = 0;

    @Override
    public void setSwitch(boolean set) {
        isOpen = set;
        Logger.e("TEST_DESIGN_PATTERN TV setSwitch = %s",isOpen);
    }

    @Override
    void setUpLevel(int level) {
        Logger.e("TEST_DESIGN_PATTERN it is a TV, can`t setup level");
    }
    @Override
    public void setUpVolume(int volume){
        if (!isOpen) {
            Logger.e("TEST_DESIGN_PATTERN TV has turn off,can`t setup volume");
            return;
        }
        this.volume = volume;
        Logger.e("TEST_DESIGN_PATTERN TV volume = %s",volume);
    }
}
