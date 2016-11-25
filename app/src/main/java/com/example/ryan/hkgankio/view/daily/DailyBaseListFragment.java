package com.example.ryan.hkgankio.view.daily;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.api.DailyApiService;
import com.example.ryan.hkgankio.common.HKCommon;
import com.example.ryan.hkgankio.support.BaseDailyListAdapter;
import com.example.ryan.hkgankio.HKApplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by studio02 on 4/25/16.
 */
public abstract class DailyBaseListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    protected View mRootView;
    protected RecyclerView recyclerView;
    protected BaseDailyListAdapter adapter;
    protected LinearLayoutManager mLayoutManager;
    protected String mCategory;
    protected String mUrl;
    protected DailyApiService apiService;
    protected LinearLayout contentLayout;
    protected ConvenientBanner convenientBanner;
    protected SwipeRefreshLayout mSwipeLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_daily, container, false);
        contentLayout = (LinearLayout) mRootView.findViewById(R.id.content_layout);
        convenientBanner = (ConvenientBanner) mRootView.findViewById(R.id.convenientBanner);
        mSwipeLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.pull_to_refresh);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HKCommon.daily_base_api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(DailyApiService.class);
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(HKApplication.AppContext);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
        initSwipeRefreshLayout();
        initSpecail();
        getArg();
        loadData();

        return mRootView;
    }

    protected void initSwipeRefreshLayout(){
        //上面的方法已经废弃
        mSwipeLayout.setColorSchemeColors(Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.RED);


        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwipeLayout.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mSwipeLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mSwipeLayout.setSize(SwipeRefreshLayout.LARGE);

        //设置下拉刷新的监听
        mSwipeLayout.setOnRefreshListener(this);
    }

    abstract void initSpecail();
    abstract void getArg();
    abstract void loadData();

    @Override
    public void onRefresh() {

    }
}
