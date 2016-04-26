package com.example.ryan.hkgankio.model;

import com.example.ryan.hkgankio.api.DailyApiService;
import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.bean.DailyWebBean;
import com.example.ryan.hkgankio.bean.HotnewBean;
import com.example.ryan.hkgankio.bean.ThemeBean;
import com.example.ryan.hkgankio.common.HKCommon;
import com.example.ryan.hkgankio.listeners.BaseMultiLoadedListener;
import com.example.ryan.hkgankio.util.HttpMrg;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryan on 4/24/16.
 */
public class DailyModel implements BaseDailyModel {


    @Override
    public void loadDailyNews(final BaseMultiLoadedListener<DailyNewsBean> newsBeanBaseMultiLoadedListener) {
        DailyApiService dailyApiService = HttpMrg.getInstance().initRetrofit(HKCommon.daily_base_api, DailyApiService.class);
        dailyApiService.getLatestNews().enqueue(new Callback<DailyNewsBean>() {
            @Override
            public void onResponse(Call<DailyNewsBean> call, Response<DailyNewsBean> response) {
                newsBeanBaseMultiLoadedListener.onSuccess(response.code(), response.body());
            }

            @Override
            public void onFailure(Call<DailyNewsBean> call, Throwable t) {
                newsBeanBaseMultiLoadedListener.onError(t.toString());
            }
        });
    }

    @Override
    public void loadDailyHotsNews(final BaseMultiLoadedListener<HotnewBean> newsBeanBaseMultiLoadedListener) {
        DailyApiService dailyApiService = HttpMrg.getInstance().initRetrofit(HKCommon.daily_base_api, DailyApiService.class);
        dailyApiService.getHotNews().enqueue(new Callback<HotnewBean>() {
            @Override
            public void onResponse(Call<HotnewBean> call, Response<HotnewBean> response) {
                newsBeanBaseMultiLoadedListener.onSuccess(response.code(), response.body());
            }

            @Override
            public void onFailure(Call<HotnewBean> call, Throwable t) {
                newsBeanBaseMultiLoadedListener.onError(t.toString());
            }
        });
    }

    @Override
    public void loadDailyThemes(final BaseMultiLoadedListener<ThemeBean> newsBeanBaseMultiLoadedListener) {
        DailyApiService dailyApiService = HttpMrg.getInstance().initRetrofit(HKCommon.daily_base_api, DailyApiService.class);
        dailyApiService.getDailyThemes().enqueue(new Callback<ThemeBean>() {
            @Override
            public void onResponse(Call<ThemeBean> call, Response<ThemeBean> response) {
                newsBeanBaseMultiLoadedListener.onSuccess(response.code(), response.body());
            }

            @Override
            public void onFailure(Call<ThemeBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadDailyColumn(final BaseMultiLoadedListener<ColumnBean> newsBeanBaseMultiLoadedListener) {
        DailyApiService dailyApiService = HttpMrg.getInstance().initRetrofit(HKCommon.daily_base_api, DailyApiService.class);
        dailyApiService.getDailysections().enqueue(new Callback<ColumnBean>() {
            @Override
            public void onResponse(Call<ColumnBean> call, Response<ColumnBean> response) {
                newsBeanBaseMultiLoadedListener.onSuccess(response.code(), response.body());
            }

            @Override
            public void onFailure(Call<ColumnBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadDailyDetail(String url, final BaseMultiLoadedListener<DailyWebBean> newsBeanBaseMultiLoadedListener) {
        DailyApiService dailyApiService = HttpMrg.getInstance().initRetrofit("", DailyApiService.class);
        dailyApiService.getDetailBean(url).enqueue(new Callback<DailyWebBean>() {
            @Override
            public void onResponse(Call<DailyWebBean> call, Response<DailyWebBean> response) {
                newsBeanBaseMultiLoadedListener.onSuccess(response.code(), response.body());
            }

            @Override
            public void onFailure(Call<DailyWebBean> call, Throwable t) {

            }
        });
    }


}
