package com.example.ryan.hkgankio.designpattern.decorator;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 8/10/16.
 */
public class EnginCar extends Car{


    @Override
    void run() {
        Logger.d("TEST_DESIGN_PATTERN --->会跑的车");
    }
}
