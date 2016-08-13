package com.example.ryan.hkgankio.designpattern.mediator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.observer.Observable;
import com.example.ryan.hkgankio.designpattern.observer.ObserverListener;
import com.example.ryan.hkgankio.util.PostableHandler;
import com.example.ryan.hkgankio.util.ThreadPoolManager;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by ryan on 7/25/16.
 * 中介者模式,就是把各种不同的要互相依赖的类整合在一起.
 *
 
 *
 *
 *
 */
public class ActivityMeditorPattern extends Activity {
    MediatorBoss mediatorBoss;
    ColleagueUI colleagueUI;
    ColleagueTestteam colleagueTestteam;
    ColleagueDeveloper colleagueDeveloper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditor_pattern);
        mediatorBoss = new MediatorBoss();

        colleagueUI = new ColleagueUI(mediatorBoss);
        colleagueTestteam = new ColleagueTestteam(mediatorBoss);
        colleagueDeveloper = new ColleagueDeveloper(mediatorBoss);

        mediatorBoss.setColleagueDeveloper(colleagueDeveloper);
        mediatorBoss.setColleagueTestteam(colleagueTestteam);
        mediatorBoss.setColleagueUI(colleagueUI);


    }

    public void workjob(View view) {
        colleagueUI.workJob();
    }

}
