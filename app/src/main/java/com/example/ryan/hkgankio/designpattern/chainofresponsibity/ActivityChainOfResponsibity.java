package com.example.ryan.hkgankio.designpattern.chainofresponsibity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;

/**
 * Created by studio02 on 8/4/16.
 */
public class ActivityChainOfResponsibity extends Activity{

    private Client client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chainofresponsibity_pattern);
        client = new Client();
    }
    public void loadweight(View view) {
        client.loadWatermelon();
    }
}
