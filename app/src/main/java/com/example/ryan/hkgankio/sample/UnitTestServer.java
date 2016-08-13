package com.example.ryan.hkgankio.sample;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 7/21/16.
 */
public class UnitTestServer extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public UnitTestServer(String name) {
        super(name);
    }

    @Override
    public void onHandleIntent(Intent intent) {
        Logger.e("UNITTEXT_RYAN = %s , number = %s",intent.getAction(),87);
        SharedPreferences.Editor editor = this.getSharedPreferences(
                "example", Context.MODE_PRIVATE).edit();
        editor.putString("SAMPLE_DATA", "sample data");
        editor.apply();
    }
}
