package com.example.ryan.hkgankio.designpattern.decorator;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 8/10/16.
 */
public class SportCar extends CarHasBrand {
    public SportCar(Car car) {
        super(car);
    }
    public void takeGril(){
        Logger.d("TEST_DESIGN_PATTERN --->我是跑车,是要载美女的");
    }
}
