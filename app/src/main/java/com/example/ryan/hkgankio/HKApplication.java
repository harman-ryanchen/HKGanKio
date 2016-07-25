package com.example.ryan.hkgankio;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by ryan on 4/23/16.
 */
public class HKApplication extends Application{

    public static Context AppContext = null;
    @Override
    public void onCreate() {
        super.onCreate();
        AppContext = getApplicationContext();
        Fresco.initialize(AppContext);
//        LeakCanary.install(this);
        Logger.d("fast");
    }
}
