package com.example.ryan.hkgankio.designpattern.bridge;

/**
 * Created by ryan on 8/12/16.
 */
public abstract class Appliance {

    protected boolean isOpen = false;

    abstract void setSwitch(boolean set);

    abstract void setUpLevel(int level);

    abstract void setUpVolume(int volume);

}
