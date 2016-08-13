package com.example.ryan.hkgankio.designpattern.visitor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.template.NokiaPhone;
import com.example.ryan.hkgankio.designpattern.template.SonyPhone;

/**
 * Created by ryan on 7/25/16.
 */
public class ActivityVisitorPattern extends Activity {

    private Storage storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_pattern);
        storage = new Storage();
    }

    public void call(View view) {
    }

    public void showconsume(View view) {
        storage.showDeliverBehaviour(new Receiver("receiver"));
    }

    public void showproduce(View view) {
        storage.showConsumeBehaviour(new Deliver("deliver"));
    }
}
