package com.example.ryan.hkgankio.designpattern.bridge;

import android.app.Activity;
import android.os.Bundle;

import com.example.ryan.hkgankio.R;

/**
 * Created by studio02 on 8/4/16.
 */
public class ActivityBridgeResponsibity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridge_pattern);
        ElectricFan electricFan = new ElectricFan();

        Television television = new Television();

        SwitchFan fanSwitch = new SwitchFan(electricFan);

        SwitchTv tvSwitch = new SwitchTv(television);

        fanSwitch.setLevel(8);
        tvSwitch.setVolume(0);

        fanSwitch.turnOn();
        tvSwitch.turnOn();

        fanSwitch.setLevel(2);
        tvSwitch.setVolume(5);

        fanSwitch.turnOff();
        tvSwitch.turnOff();
    }
}
