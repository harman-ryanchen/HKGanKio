package com.example.ryan.hkgankio.designpattern.strategy;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/4/16.
 */
public class BtPlay implements IStrategy{
    @Override
    public void play() {
        Logger.e("play BT", "TEST_DESIGN_PATTERN");
    }
}
