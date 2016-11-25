package com.example.ryan.hkgankio.designpattern.chainofresponsibity;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/4/16.
 */
public class SuperMan extends Person {

    public SuperMan() {
        super(500, null);
    }

    @Override
    protected void reply(Watermelon watermelon) {
        Logger.e("SuperMan :  才 " + watermelon.getWeight() + "斤,老子抱得起来", "TEST_DESIGN_PATTERN");
    }
}
