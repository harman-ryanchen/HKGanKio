package com.example.ryan.hkgankio.designpattern.bridge;

/**
 * Created by ryan on 8/12/16.
 */
public abstract class Switch {
    protected Appliance appliance;

    public Switch(Appliance appliance) {
        this.appliance = appliance;
    }

    abstract void turnOff();

    abstract void turnOn();

}
