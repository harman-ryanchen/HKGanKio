package com.example.ryan.hkgankio.designpattern.decorator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.facade.AMTSystem;

/**
 * Created by ryan on 7/25/16.
 *
 * 动态地给一个对象添加一些额外的职责。
 */
public class ActivityDecoratorPattern extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator_pattern);
        EnginCar enginCar = new EnginCar();
        Speaker speaker = new Speaker(enginCar);
        SportCar sportCar = new SportCar(speaker);
        speaker.run();
    }

}
