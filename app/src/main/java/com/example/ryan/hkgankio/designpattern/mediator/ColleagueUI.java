package com.example.ryan.hkgankio.designpattern.mediator;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 8/9/16.
 */
public class ColleagueUI implements Colleague {
    private Mediator mediator;

    public ColleagueUI(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void workJob() {
        Logger.d("TEST_DESIGN_PATTERN 我是UI, 我画完图了,死开发的该你干了");
        mediator.pushJob(this);
    }
}
