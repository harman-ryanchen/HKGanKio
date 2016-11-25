package com.example.ryan.hkgankio.designpattern.chainofresponsibity;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/4/16.
 */
public abstract class Person {

    protected int loadweith; //此人可以搬多重的西瓜
    private Person superMan;


    /**
     * 初始化每种人可以load的重量和比他壮的人
     *
     * @param loadweith
     * @param superMan
     */
    public Person(int loadweith, Person superMan) {
        this.loadweith = loadweith;
        this.superMan = superMan;
    }

    /**
     * 看看这人能搬起多重的西瓜,如果搬不动就叫别人搬
     *
     * @param watermelon
     */
    public void handLoadRequest(Watermelon watermelon) {

        if (loadweith >= watermelon.getWeight()) {
            reply(watermelon);
        } else {
            if (superMan != null) {
                superMan.handLoadRequest(watermelon);
            } else {
                //啥也没有了
                Logger.e(watermelon.getWeight()+ "斤,抱不起了", "TEST_DESIGN_PATTERN");
            }
        }
    }

    protected abstract void reply(Watermelon watermelon);
}
