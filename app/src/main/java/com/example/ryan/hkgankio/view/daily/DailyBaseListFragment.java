package com.example.ryan.hkgankio.view.daily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.ryan.hkgankio.HKApplication;
import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.api.DailyApiService;
import com.example.ryan.hkgankio.common.HKCommon;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by studio02 on 4/25/16.
 */
public abstract class DailyBaseListFragment extends Fragment{
    protected View mRootView;
    protected ProgressBar progressBar;
    protected RecyclerView recyclerView;
    protected RecyclerView.Adapter adapter;
    protected LinearLayoutManager mLayoutManager;
    protected String mCategory;
    protected String mUrl;
    protected DailyApiService apiService;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_daily, container, false);
        progressBar = (ProgressBar) mRootView.findViewById(R.id.progressbar);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HKCommon.daily_base_api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(DailyApiService.class);
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(HKApplication.AppContext);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
        showProgressBar();
        getArg();
        loadData();

        return mRootView;
    }
    protected void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }
    protected void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
    abstract void getArg();
    abstract void loadData();
    abstract RecyclerView.Adapter bindAdapter();
}
