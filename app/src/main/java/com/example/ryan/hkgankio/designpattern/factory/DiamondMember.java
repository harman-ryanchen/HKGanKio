package com.example.ryan.hkgankio.designpattern.factory;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/5/16.
 */
public class DiamondMember implements Member {
    @Override
    public void reCharge() {
        Logger.t(this.getClass().getName());
    }

    @Override
    public void consume() {
        Logger.t(this.getClass().getName());
    }

    public void bathWithPrettyGirl(){
        Logger.e("钻牌跟美女洗澡","TEST_DESIGN_PATTERN");
    }
}
