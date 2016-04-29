package com.example.ryan.hkgankio.presenter.imp;

import com.example.ryan.hkgankio.api.DailyApiService;
import com.example.ryan.hkgankio.bean.HotnewBean;
import com.example.ryan.hkgankio.common.HKCommon;
import com.example.ryan.hkgankio.presenter.IPresenter;
import com.example.ryan.hkgankio.view.daily.base.IDailNewsFragment;
import com.example.ryan.hkgankio.view.daily.base.IDailyHotsFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by studio02 on 4/29/16.
 */
public class DailyHotsPresenter implements IPresenter {
    DailyApiService apiService;
    private IDailyHotsFragment iDailyHotsFragment;

    public DailyHotsPresenter(IDailyHotsFragment iDailNewsFragment) {
        this.iDailyHotsFragment = iDailNewsFragment;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HKCommon.daily_base_api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(DailyApiService.class);
    }

    @Override
    public void loadData() {
        apiService.getHotNews().enqueue(new Callback<HotnewBean>() {
            @Override
            public void onResponse(Call<HotnewBean> call, Response<HotnewBean> response) {
                iDailyHotsFragment.refreshRecentBeen(response.body().getRecent());
            }

            @Override
            public void onFailure(Call<HotnewBean> call, Throwable t) {
                iDailyHotsFragment.loadError(t.getMessage());
            }
        });
    }
}
