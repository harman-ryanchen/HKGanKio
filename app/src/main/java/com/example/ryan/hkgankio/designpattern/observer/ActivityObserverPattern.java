package com.example.ryan.hkgankio.designpattern.observer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.util.PostableHandler;
import com.example.ryan.hkgankio.util.ThreadPoolManager;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by ryan on 7/25/16.
 */
public class ActivityObserverPattern extends Activity {

    private TextView notifyshow;
    private ObserverListener observerListener;
    private Observable observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_pattern);
        notifyshow = (TextView) findViewById(R.id.observer_show);
        observable = new Observable();
        rondamNotyfy();
        observerListener = new ObserverListener() {
            @Override
            public void onSpeakerChange() {
            }

            @Override
            public void onSpeakerAdd() {
            }

            @Override
            public void onSpeakerRemove() {
            }
        };
    }
    public void rondamNotyfy() {
        ThreadPoolManager.getScheduledPool().scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        Logger.d("TEST_DESIGN_PATTERN = %",(int) (Math.random() * 3));
                    }
                }, 0, 3, TimeUnit.SECONDS
        );
    }

    public void updateNotify(final String message) {
        Logger.d("TEST_DESIGN_PATTERN = %",message);
        PostableHandler.UI_THREAD.postImmediately(new Runnable() {
            @Override
            public void run() {
                notifyshow.setText(message);
            }
        });

    }

    public void addlistener(View view) {
        observable.addObserverListener(observerListener);
    }

    public void removelistener(View view) {
        observable.removeOberserListener(observerListener);

    }
}
