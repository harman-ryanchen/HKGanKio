package com.example.ryan.hkgankio.designpattern.chainofresponsibity;

/**
 * Created by studio02 on 8/4/16.
 */
public class Client {

    public void loadWatermelon() {
        Watermelon watermelon = new Watermelon((int) (Math.random() * 600));

        Person child = new Child();


        child.handLoadRequest(watermelon);
    }

}
