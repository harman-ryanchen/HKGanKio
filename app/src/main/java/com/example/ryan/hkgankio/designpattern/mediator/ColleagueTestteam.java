package com.example.ryan.hkgankio.designpattern.mediator;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 8/9/16.
 */
public class ColleagueTestteam implements Colleague{
    private Mediator mediator;

    public ColleagueTestteam(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void workJob() {
        Logger.d("TEST_DESIGN_PATTERN 我是测试的, 功能我测完了,死开发的改改吧");
        mediator.pushJob(this);
    }
}
