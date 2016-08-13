package com.example.ryan.hkgankio.designpattern.bridge;

/**
 * Created by ryan on 8/12/16.
 */
public class SwitchTv extends Switch {
    public SwitchTv(Appliance appliance) {
        super(appliance);
    }

    @Override
    public void turnOff() {
        appliance.setSwitch(false);
    }

    @Override
    public void turnOn() {
        appliance.setSwitch(true);
    }

    public void setVolume(int volume) {
        appliance.setUpVolume(volume);
    }
}
