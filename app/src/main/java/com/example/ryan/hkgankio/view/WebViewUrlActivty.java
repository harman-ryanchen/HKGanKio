package com.example.ryan.hkgankio.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.api.DailyApiService;
import com.example.ryan.hkgankio.bean.DailyWebBean;
import com.example.ryan.hkgankio.common.HKCommon;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ryan on 4/26/16.
 */
public class WebViewUrlActivty extends AppCompatActivity {
    protected WebView webView;
    protected ProgressBar progressBar;
    protected boolean isLoading = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.webview);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        // Let's display the progress in the activity title bar, like the
        // browser app does.
//        getWindow().requestFeature(Window.FEATURE_PROGRESS);

        webView.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                activity.setProgress(progress * 1000);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }
        });
        String num = getIntent().getExtras().getString(HKCommon.argument_detail_url_num);
        String section = getIntent().getExtras().getString(HKCommon.argument_detail_url_section);
        int id = getIntent().getExtras().getInt(HKCommon.argument_detail_url_id);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HKCommon.daily_base_api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DailyApiService apiService = retrofit.create(DailyApiService.class);
        apiService.getDetailBean(num,section,id).enqueue(new Callback<DailyWebBean>() {
            @Override
            public void onResponse(Call<DailyWebBean> call, Response<DailyWebBean> response) {
                webView.loadDataWithBaseURL("file:///android_asset/", "<link rel=\"stylesheet\" type=\"text/css\" href=\"dailycss.css\" />" + response.body().getBody(), "text/html", "utf-8", null);
            }

            @Override
            public void onFailure(Call<DailyWebBean> call, Throwable t) {
                Toast.makeText(WebViewUrlActivty.this,"Load data error",Toast.LENGTH_SHORT);
            }
        });
    }
}

