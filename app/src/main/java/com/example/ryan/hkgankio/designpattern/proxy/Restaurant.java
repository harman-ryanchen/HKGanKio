package com.example.ryan.hkgankio.designpattern.proxy;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 8/9/16.
 */
public abstract class Restaurant {

    private void cookingDish(){
        Logger.d("TEST_DESIGN_PATTERN = %","cookingDish");
    }
    abstract void deliverDish();
    abstract void receiveMoney();

}
