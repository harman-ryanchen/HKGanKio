package com.example.ryan.hkgankio.designpattern.bridge;

/**
 * Created by ryan on 8/12/16.
 */
public class SwitchFan extends Switch {


    public SwitchFan(Appliance appliance) {
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

    public void setLevel(int level){
        appliance.setUpLevel(level);
    }
}
