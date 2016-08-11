package com.example.ryan.hkgankio.designpattern.visitor;

/**
 * Created by studio02 on 8/11/16.
 */
public abstract class Cargo {

    private String cargoName;

    public Cargo(String cargoName) {
        this.cargoName = cargoName;
    }

    public String getCargoName() {
        return cargoName;
    }

    abstract void consume();
    abstract void produce();
}
