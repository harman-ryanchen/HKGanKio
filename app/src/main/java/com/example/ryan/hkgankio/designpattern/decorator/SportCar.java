package com.example.ryan.hkgankio.designpattern.decorator;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 10/1/16.
 */
public class SportCar implements Car{
    private Car car;

    public SportCar(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        car.run();
        speedUp();
    }

    public void speedUp(){
        Logger.d("I am speedUp");
    }

}
