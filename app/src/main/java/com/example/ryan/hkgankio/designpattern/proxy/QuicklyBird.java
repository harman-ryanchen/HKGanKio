package com.example.ryan.hkgankio.designpattern.proxy;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 8/9/16.
 */
public class QuicklyBird extends Restaurant{
    @Override
    void deliverDish() {
        Logger.d("TEST_DESIGN_PATTERN = %","QuicklyBird");
    }

    @Override
    void receiveMoney() {
        Logger.d("TEST_DESIGN_PATTERN = %","QuicklyBird");
    }
}
