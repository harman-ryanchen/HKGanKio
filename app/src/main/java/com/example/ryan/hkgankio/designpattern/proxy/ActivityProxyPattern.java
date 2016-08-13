package com.example.ryan.hkgankio.designpattern.proxy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.mediator.ColleagueDeveloper;
import com.example.ryan.hkgankio.designpattern.mediator.ColleagueTestteam;
import com.example.ryan.hkgankio.designpattern.mediator.ColleagueUI;
import com.example.ryan.hkgankio.designpattern.mediator.MediatorBoss;

/**
 * Created by ryan on 7/25/16.
 * 中介者模式,就是把各种不同的要互相依赖的类整合在一起.
 *
 
 *
 *
 *
 */
public class ActivityProxyPattern extends Activity {
    DeliverProxy deliverProxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy_pattern);
        deliverProxy = new DeliverProxy();
    }

    public void deliver(View view) {
        deliverProxy.orderByUser();
    }

}
