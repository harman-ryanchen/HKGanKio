package com.example.ryan.hkgankio.view.daily;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.bean.DailyWebBean;
import com.example.ryan.hkgankio.bean.HotnewBean;
import com.example.ryan.hkgankio.bean.ThemeBean;
import com.example.ryan.hkgankio.presenter.BaseDailyPresenter;
import com.example.ryan.hkgankio.presenter.DailyPresenter;

/**
 * Created by ryan on 4/26/16.
 */
public class WebViewUrlActivty extends AppCompatActivity implements  IBaseDailyFragment{
    protected WebView webView;
    protected ProgressBar progressBar;
    protected boolean isLoading = true;
    private BaseDailyPresenter dailyPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.webview);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        dailyPresenter = new DailyPresenter(this);

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
        final String url = getIntent().getStringExtra(getString(R.string.argument_web_url));
        dailyPresenter.loadDailyDetailData(url);
    }

    @Override
    public void onLoadNewsResult(DailyNewsBean newsBean) {

    }

    @Override
    public void onLoadHotNewsResult(HotnewBean hotnewBean) {

    }

    @Override
    public void onLoadColumnsResult(ColumnBean columnBean) {

    }

    @Override
    public void onLoadThemesResult(ThemeBean themeBean) {

    }

    @Override
    public void onLoadWebDetailResult(DailyWebBean dailyWebBean) {
        if (dailyWebBean==null)return;
        webView.loadDataWithBaseURL("file:///android_asset/", "<link rel=\"stylesheet\" type=\"text/css\" href=\"dailycss.css\" />"+dailyWebBean.getBody(), "text/html", "utf-8", null);
    }
}
