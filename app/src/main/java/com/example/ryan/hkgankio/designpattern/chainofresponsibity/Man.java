package com.example.ryan.hkgankio.designpattern.chainofresponsibity;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/4/16.
 */
public class Man extends Person{
    /**
     * 初始化每种人可以load的重量和比他壮的人
     *

     */
    public Man() {
        super(300, new SuperMan());
    }

    @Override
    protected void reply(Watermelon watermelon) {
        Logger.e("Man :  才 "+watermelon.getWeight()+"斤,老子抱得起来", "TEST_DESIGN_PATTERN");
    }
}
