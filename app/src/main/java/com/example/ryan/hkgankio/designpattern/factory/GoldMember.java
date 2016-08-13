package com.example.ryan.hkgankio.designpattern.factory;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/5/16.
 */
public class GoldMember implements Member {
    @Override
    public void reCharge() {
        Logger.t(this.getClass().getName());
    }

    @Override
    public void consume() {
        Logger.t(this.getClass().getName());
    }

    public void bathWithMan(){
        Logger.e("金牌有人搓背","TEST_DESIGN_PATTERN");
    }
}
