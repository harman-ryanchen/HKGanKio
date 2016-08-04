package com.example.ryan.hkgankio.designpattern.template;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.CloseState;
import com.example.ryan.hkgankio.designpattern.ElevatorController;
import com.example.ryan.hkgankio.designpattern.OpenState;
import com.example.ryan.hkgankio.designpattern.ProcessState;
import com.example.ryan.hkgankio.designpattern.StopProcessState;

/**
 * Created by ryan on 7/25/16.
 */
public class ActivityTemplatePattern extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamplate_pattern);
    }

    public void call(View view) {
    }

    public void bulletproof(View view) {
        NokiaPhone nokiaPhone = new NokiaPhone();
        nokiaPhone.call();
        nokiaPhone.bulletProof();
    }

    public void camera(View view) {
        SonyPhone sonyPhone = new SonyPhone();
        sonyPhone.call();
        sonyPhone.camera();
    }
}
