package com.example.ryan.hkgankio.designpattern.observer;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.ryan.hkgankio.util.ThreadPoolManager;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ryan on 8/8/16.
 */
public class Observable{

    private List<ObserverListener> observerListeners = new ArrayList<>();


    public Observable() {
    }

    /**
     * add the listener to list
     *
     * @param observerListener
     */
    public void addObserverListener(ObserverListener observerListener) {
       if (!observerListeners.contains(observerListener)) {
            observerListeners.add(observerListener);
        }
    }

    public void removeOberserListener(ObserverListener observerListener) {
        observerListeners.remove(observerListener);
    }

    public void rondamNotyfy() {
        ThreadPoolManager.getScheduledPool().scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        notifyObserver((int) (Math.random() * 3));
                        Logger.d("TEST_DESIGN_PATTERN = %");
                    }
                }, 0, 3, TimeUnit.SECONDS
        );
    }


    private void notifyObserver(int notify_type) {
        Logger.d("TEST_DESIGN_PATTERN = %",notify_type);
        switch (notify_type) {
            case 1:
                notifySpeakerAdd();
                break;
            case 2:
                notifySpeakerChange();
                break;
            case 0:
                notifySpeakerRemove();
                break;

            default:
                break;
        }
    }

    /**
     * notify speaker Add
     */
    private void notifySpeakerAdd() {
        for (ObserverListener o : observerListeners) {
            o.onSpeakerAdd();
        }
    }

    /**
     * notify speaker change
     */
    private void notifySpeakerChange() {
        for (ObserverListener o : observerListeners) {
            o.onSpeakerChange();
        }
    }

    /**
     * notify speaker remove
     */
    private void notifySpeakerRemove() {
        for (ObserverListener o : observerListeners) {
            o.onSpeakerRemove();
        }
    }

}
