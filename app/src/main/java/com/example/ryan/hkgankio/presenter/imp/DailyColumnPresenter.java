package com.example.ryan.hkgankio.presenter.imp;

import com.example.ryan.hkgankio.api.DailyApiService;
import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.common.HKCommon;
import com.example.ryan.hkgankio.presenter.IPresenter;
import com.example.ryan.hkgankio.view.daily.base.IDailyColumnsFragment;
import com.example.ryan.hkgankio.view.daily.base.IDailyHotsFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by studio02 on 4/29/16.
 */
public class DailyColumnPresenter implements IPresenter {
    DailyApiService apiService;
    private IDailyColumnsFragment iDailyColumnsFragment;

    public DailyColumnPresenter(IDailyColumnsFragment iDailyColumnsFragment) {
        this.iDailyColumnsFragment = iDailyColumnsFragment;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HKCommon.daily_base_api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(DailyApiService.class);
    }

    @Override
    public void loadData() {
        apiService.getDailysections().enqueue(new Callback<ColumnBean>() {
            @Override
            public void onResponse(Call<ColumnBean> call, Response<ColumnBean> response) {
                iDailyColumnsFragment.refreshColumnBeen(response.body().getData());
            }

            @Override
            public void onFailure(Call<ColumnBean> call, Throwable t) {
                iDailyColumnsFragment.loadError(t.getMessage());
            }
        });
    }
}
