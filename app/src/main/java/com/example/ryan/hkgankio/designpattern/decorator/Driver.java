package com.example.ryan.hkgankio.designpattern.decorator;

/**
 * Created by ryan on 8/10/16.
 */
public class Driver {

    public void driveSportCar(){
        Car enginCar = new EnginCar();
        SportCar sportCar = new SportCar(enginCar);
        sportCar.run();
        sportCar.takeGril();
    }
    public void driveTurck(){
        Car enginCar = new EnginCar();
        Truck sportCar = new Truck(enginCar);
        sportCar.run();
        sportCar.loadCargo();
    }
}
