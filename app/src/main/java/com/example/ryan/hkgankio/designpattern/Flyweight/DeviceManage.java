package com.example.ryan.hkgankio.designpattern.Flyweight;

import android.util.SparseArray;

import java.util.List;

/**
 * Created by ryan on 8/12/16.
 */
public class DeviceManage {

    private SparseArray<Device> devices = new SparseArray<>();


    public Device obtinDevice(String name, int uuid){
        Device device = devices.get(uuid);
        if (device==null){
            device = new Device(name,uuid);
            devices.put(uuid,device);
        }

        return device;
    }

}
