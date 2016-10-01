package com.example.ryan.hkgankio.designpattern.decorator;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 10/1/16.
 */
public class Speaker implements Car{
    private Car car;


    public Speaker(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        car.run();
        playMusic();
    }

    public void playMusic() {
        Logger.d("I am a Speaker  I can play Music");
    }
}
