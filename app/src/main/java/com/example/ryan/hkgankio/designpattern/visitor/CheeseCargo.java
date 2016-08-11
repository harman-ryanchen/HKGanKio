package com.example.ryan.hkgankio.designpattern.visitor;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/11/16.
 */
public class CheeseCargo extends Cargo{

    public CheeseCargo(String cargoName) {
        super(cargoName);
    }

    @Override
    void consume() {
        Logger.e("TEST_DESIGN_PATTERN 我是Cheese我被消耗掉了");
    }

    @Override
    void produce() {
        Logger.e("TEST_DESIGN_PATTERN 我是Cheese我被生产出来了");
    }
}
