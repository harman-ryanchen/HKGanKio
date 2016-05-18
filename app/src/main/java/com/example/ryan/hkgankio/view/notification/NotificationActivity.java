package com.example.ryan.hkgankio.view.notification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.service.PollingService;
import com.example.ryan.hkgankio.util.PollingUtils;

/**
 * Created by studio02 on 5/18/16.
 */
public class NotificationActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
        PollingUtils.startPollingService(this, 5, PollingService.class, PollingService.ACTION);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PollingUtils.stopPollingService(this, PollingService.class, PollingService.ACTION);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
