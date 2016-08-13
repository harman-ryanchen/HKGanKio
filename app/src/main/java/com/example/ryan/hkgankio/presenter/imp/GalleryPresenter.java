package com.example.ryan.hkgankio.presenter.imp;

import com.example.ryan.hkgankio.api.GanHuoApiService;
import com.example.ryan.hkgankio.bean.FuLiBean;
import com.example.ryan.hkgankio.common.HKCommon;
import com.example.ryan.hkgankio.presenter.IGalleryPresenter;
import com.example.ryan.hkgankio.presenter.IPresenter;
import com.example.ryan.hkgankio.view.gallery.base.IGalleryFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by studio02 on 5/3/16.
 */
public class GalleryPresenter implements IGalleryPresenter{

     IGalleryFragment iGalleryFragment;
     private GanHuoApiService ganHuoApiService;

    public GalleryPresenter(IGalleryFragment iGalleryFragment) {
        this.iGalleryFragment = iGalleryFragment;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HKCommon.ganhuo_base_api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ganHuoApiService = retrofit.create(GanHuoApiService.class);
    }

    @Override
    public void loadFuLiData(int page) {
        ganHuoApiService.loadFuLiData(page).enqueue(new Callback<FuLiBean>() {
            @Override
            public void onResponse(Call<FuLiBean> call, Response<FuLiBean> response) {
                iGalleryFragment.onResultFromNet(response.body());
            }

            @Override
            public void onFailure(Call<FuLiBean> call, Throwable t) {

            }
        });
    }
}
