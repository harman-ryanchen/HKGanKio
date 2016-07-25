package com.example.ryan.hkgankio.research;

import android.app.Activity;
import android.view.LayoutInflater;

/**
 * Created by ryan on 7/16/16.
 */
public class Singletion {

    private static volatile Singletion singletion = null;

    public static Singletion getInstance(){
        if (singletion==null){
            synchronized (Singletion.class){
                singletion = new Singletion();
            }
        }
        return singletion;
    }

    public void researchLayoutInflater(){
    }
}
