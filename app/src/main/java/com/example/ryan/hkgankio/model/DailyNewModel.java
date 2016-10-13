package com.example.ryan.hkgankio.model;

import android.graphics.Bitmap;

import com.example.ryan.hkgankio.api.DailyApiService;
import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.common.HKCommon;
import com.orhanobut.logger.Logger;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by studio02 on 10/12/16.
 */

public class DailyNewModel {
    DailyApiService apiService;
    private Map<String, SoftReference<DailyNewsBean>> referenceHashMap = new HashMap<String, SoftReference<DailyNewsBean>>();
    public DailyApiService getApiService() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(new OkHttpClient())
                    .baseUrl(HKCommon.daily_base_api)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(DailyApiService.class);
        }
        return apiService;
    }
    public void storeData(DailyNewsBean bean,String tag){
        Logger.d("TESG_CACHE storeData = %s ",tag);
        referenceHashMap.put(tag,new SoftReference<DailyNewsBean>(bean));
    }
    public DailyNewsBean getDailyNewsBean(String tag){
        Logger.d("TESG_CACHE  getDailyNewsBean= %s ",tag);
        if (referenceHashMap.get(tag)==null)return null;
        return referenceHashMap.get(tag).get();
    }
}
