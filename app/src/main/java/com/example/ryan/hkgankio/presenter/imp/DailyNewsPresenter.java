package com.example.ryan.hkgankio.presenter.imp;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.ArrayMap;

import com.example.ryan.hkgankio.api.DailyApiService;
import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.bean.StoriesBean;
import com.example.ryan.hkgankio.bean.TopStoriesBean;
import com.example.ryan.hkgankio.common.HKCommon;
import com.example.ryan.hkgankio.presenter.IDailyNewsPresenter;
import com.example.ryan.hkgankio.view.daily.base.IDailNewsFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by studio02 on 4/28/16.
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class DailyNewsPresenter implements IDailyNewsPresenter {
    DailyApiService apiService;
    private IDailNewsFragment iDailNewsFragment;
    private List<TopStoriesBean> topStoriesBeens;
    private long laestDate;
    private ArrayMap<Long,List<StoriesBean>> storiesBeanArrayMap = new ArrayMap<>();
    public DailyNewsPresenter(IDailNewsFragment iDailNewsFragment) {
        this.iDailNewsFragment = iDailNewsFragment;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HKCommon.daily_base_api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(DailyApiService.class);
    }

    @Override
    public void loadLaestNewsData() {
        apiService.getLatestNews().enqueue(new Callback<DailyNewsBean>() {
            @Override
            public void onResponse(Call<DailyNewsBean> call, Response<DailyNewsBean> response) {
                laestDate = Long.valueOf(response.body().getDate());
                topStoriesBeens = response.body().getTop_stories();
                iDailNewsFragment.refreshStories(response.body().getStories());
                iDailNewsFragment.refreshLaestTopStories(topStoriesBeens);
                storiesBeanArrayMap.put(Long.valueOf(response.body().getDate()),response.body().getStories());
            }

            @Override
            public void onFailure(Call<DailyNewsBean> call, Throwable t) {
                iDailNewsFragment.loadError(t.getMessage());
            }
        });
    }

    @Override
    public void loadBeforeNewsData() {
        laestDate--;
        apiService.getBeforeNews(laestDate).enqueue(new Callback<DailyNewsBean>() {
            @Override
            public void onResponse(Call<DailyNewsBean> call, Response<DailyNewsBean> response) {
                laestDate = Long.valueOf(response.body().getDate());
                storiesBeanArrayMap.put(Long.valueOf(response.body().getDate()),response.body().getStories());
                iDailNewsFragment.refreshStories(response.body().getStories());
            }

            @Override
            public void onFailure(Call<DailyNewsBean> call, Throwable t) {
                iDailNewsFragment.loadError(t.getMessage());
            }
        });
    }
}
