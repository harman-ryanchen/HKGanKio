package com.example.ryan.hkgankio.designpattern.decorator;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 8/10/16.
 */
public class Truck extends CarHasBrand{

    public Truck(Car car) {
        super(car);
    }
    public void loadCargo(){
        Logger.d("TEST_DESIGN_PATTERN --->我是卡车,是要载货的");
    }
}
