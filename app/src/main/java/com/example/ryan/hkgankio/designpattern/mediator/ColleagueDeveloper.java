package com.example.ryan.hkgankio.designpattern.mediator;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 8/9/16.
 */
public class ColleagueDeveloper implements Colleague{
    private Mediator mediator;

    public ColleagueDeveloper(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void workJob() {
        Logger.d("TEST_DESIGN_PATTERN 我是开发的, 功能我开发完了,死测试的你测吧");
        mediator.pushJob(this);
    }
    public void fixBugs(){
        Logger.d("TEST_DESIGN_PATTERN 我是开发的, 我在改bug");
    }
}
