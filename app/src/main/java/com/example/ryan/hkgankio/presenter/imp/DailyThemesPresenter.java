package com.example.ryan.hkgankio.presenter.imp;

import com.example.ryan.hkgankio.api.DailyApiService;
import com.example.ryan.hkgankio.bean.ThemeBean;
import com.example.ryan.hkgankio.common.HKCommon;
import com.example.ryan.hkgankio.presenter.IPresenter;
import com.example.ryan.hkgankio.view.daily.base.IDailyColumnsFragment;
import com.example.ryan.hkgankio.view.daily.base.IDailyThemesFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by studio02 on 4/29/16.
 */
public class DailyThemesPresenter implements IPresenter {
    DailyApiService apiService;
    private IDailyThemesFragment iDailyThemesFragment;

    public DailyThemesPresenter(IDailyThemesFragment iDailyThemesFragment) {
        this.iDailyThemesFragment = iDailyThemesFragment;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HKCommon.daily_base_api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(DailyApiService.class);
    }

    @Override
    public void loadData() {
        apiService.getDailyThemes().enqueue(new Callback<ThemeBean>() {
            @Override
            public void onResponse(Call<ThemeBean> call, Response<ThemeBean> response) {
              iDailyThemesFragment.refreshThemeBeen(response.body().getOthers());
            }

            @Override
            public void onFailure(Call<ThemeBean> call, Throwable t) {
               iDailyThemesFragment.loadError(t.getMessage());
            }
        });
    }
}
