package com.example.ryan.hkgankio.designpattern.chainofresponsibity;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/4/16.
 */
public class Child extends Person{


    /**
     * 初始化每种人可以load的重量和比他壮的人
     *

     */
    public Child() {
        super(50, new Man());
    }

    @Override
    protected void reply(Watermelon watermelon) {
        Logger.e("Child : 才 "+watermelon.getWeight()+"斤,老子抱得起来", "TEST_DESIGN_PATTERN");
    }
}
