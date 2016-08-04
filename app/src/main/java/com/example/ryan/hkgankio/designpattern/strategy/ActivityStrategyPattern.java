package com.example.ryan.hkgankio.designpattern.strategy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.adapt.HarmanSpeakerPlayer;
import com.example.ryan.hkgankio.designpattern.adapt.JBLPauseSpeaker;

/**
 * Created by ryan on 7/25/16.
 * 策略模式,同样的行为,但是实现方法不一样时,就可以用到策略模式.
 * 策略模式主要用来分离算法，根据相同的行为抽象来做不同的具体策略实现。
 * <p/>
 * 通过以上也可以看出策略模式的优缺点：
 * <p/>
 * 优点：
 * <p/>
 * 结构清晰明了、使用简单直观。
 * 耦合度相对而言较低，扩展方便。
 * 操作封装也更为彻底，数据更为安全。
 * 缺点：
 * <p/>
 * 随着策略的增加，子类也会变得繁多。
 */
public class ActivityStrategyPattern extends Activity {


    private StrategyController strategyController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_pattern);
        strategyController = new StrategyController();
    }

    public void playBt(View view) {
        strategyController.play(new BtPlay());
    }

    public void playAux(View view) {
        strategyController.play(new AuxPlay());
    }

    public void playGoogleCast(View view) {
        strategyController.play(new BlackFirePlay());
    }

}
