package com.example.ryan.hkgankio.designpattern.strategy;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/4/16.
 *
 */
public class StrategyController {

    public void play(IStrategy iStrategy) {
        iStrategy.play();
    }


}


