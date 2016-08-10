package com.example.ryan.hkgankio.designpattern.decorator;

/**
 * Created by ryan on 8/10/16.
 */
public abstract class CarHasBrand extends EnginCar{
    private Car car;

    public CarHasBrand(Car car) {
        this.car = car;
    }

    @Override
    void run() {
        car.run();
    }
}
