package com.example.ryan.hkgankio.designpattern.visitor;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/11/16.
 */
public class Receiver extends Visitor {
    public Receiver(String visitorName) {
        super(visitorName);
    }

    @Override
    void manage(Cargo cargo) {
        Logger.e("TEST_DESIGN_PATTERN 我是入货的,货物是 = %s", cargo.getCargoName());
    }

}
