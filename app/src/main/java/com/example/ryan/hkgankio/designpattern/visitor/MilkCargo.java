package com.example.ryan.hkgankio.designpattern.visitor;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/11/16.
 */
public class MilkCargo extends Cargo{

    public MilkCargo(String cargoName) {
        super(cargoName);
    }

    @Override
    void consume(Visitor visitor) {
//        Logger.e("TEST_DESIGN_PATTERN 我是 Milk 我被消耗掉了");
        visitor.manage(this);
    }

    @Override
    void produce(Visitor visitor) {
//        Logger.e("TEST_DESIGN_PATTERN 我是 Milk 我被生产出来了");
        visitor.manage(this);
    }
}
