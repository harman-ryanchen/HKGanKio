package com.example.ryan.hkgankio.designpattern.proxy;

import com.example.ryan.hkgankio.util.ThreadPoolManager;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by ryan on 8/9/16.
 */
public class DeliverProxy extends Restaurant{
    private Restaurant restaurant;

    public DeliverProxy() {

    }
    public void orderByUser(){
        ThreadPoolManager.getScheduledPool().scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        int order = ((int) (Math.random() * 3));
                        Logger.d("TEST_DESIGN_PATTERN = %");
                        if (order==0){
                            restaurant = new QuicklyBird();
                        }else if (order == 1){
                            restaurant = new BaiduDeliver();
                        }else{
                            restaurant = new MeiTuanDeliver();
                        }
                        deliverDish();
                        receiveMoney();
                    }
                }, 0, 3, TimeUnit.SECONDS
        );
    }

    @Override
    void deliverDish() {
        restaurant.deliverDish();
    }

    @Override
    void receiveMoney() {
        restaurant.receiveMoney();
    }
}
