package com.example.ryan.hkgankio.designpattern.decorator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.facade.AMTSystem;

/**
 * Created by ryan on 7/25/16.
 */
public class ActivityDecoratorPattern extends Activity {

    private Driver driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator_pattern);
        driver = new Driver();
    }

    public void drivetruck(View view) {
        driver.driveTurck();
    }

    public void drivesportcar(View view) {
        driver.driveSportCar();
    }

}
