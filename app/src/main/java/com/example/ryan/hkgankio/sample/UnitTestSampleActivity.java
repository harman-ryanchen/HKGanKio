package com.example.ryan.hkgankio.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;


/**
 * Created by ryan on 7/20/16.
 */
public class UnitTestSampleActivity extends FragmentActivity{

    private TextView textView;

    public UnitTestSampleActivity() {
        super();
        Logger.d(getClass().getName(),"UnitTestSampleActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(getClass().getName(),"UnitTestSampleActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d(getClass().getName(),"UnitTestSampleActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(getClass().getName(),"UnitTestSampleActivity");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d(getClass().getName(),"UnitTestSampleActivity");
        setContentView(R.layout.activity_unittest);
        textView = (TextView) findViewById(R.id.unittest_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("UNITTEST_RYAN","click TV");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(getClass().getName(),"UnitTestSampleActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(getClass().getName(),"UnitTestSampleActivity");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.d(getClass().getName(),"UnitTestSampleActivity");
    }

    public int getNumber(){
        Logger.e("ryan","UnitTestSampleActivity");
        return 8;
    }
}
