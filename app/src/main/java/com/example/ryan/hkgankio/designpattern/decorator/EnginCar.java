package com.example.ryan.hkgankio.designpattern.decorator;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 10/1/16.
 */
public class EnginCar implements Car{
    @Override
    public void run() {
        Logger.d("I am Engin I can Run");
    }
}
