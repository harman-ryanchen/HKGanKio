package com.example.ryan.hkgankio.view.notification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.service.PollingService;
import com.example.ryan.hkgankio.util.PollingUtils;

/**
 * Created by studio02 on 5/18/16.
 */
public class NotificationActivity extends AppCompatActivity{

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
        imageView = (ImageView) findViewById(R.id.image_iv);
        findViewById(R.id.setupPicture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.welcome_2);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
