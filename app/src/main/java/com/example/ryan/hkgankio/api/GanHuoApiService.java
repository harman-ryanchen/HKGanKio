package com.example.ryan.hkgankio.api;

import com.example.ryan.hkgankio.bean.FuLiBean;
import com.example.ryan.hkgankio.bean.GanHuoDayBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by studio02 on 5/3/16.
 */
public interface GanHuoApiService {

    //http://gank.io/api/day/2015/08/06
    @GET("day/{year}/{month}/{day}")
    Call<GanHuoDayBean> loadGanHuoDay(@Path("year") int year, @Path("month") int month,@Path("day") int day);

    //http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1
    @GET("data/%E7%A6%8F%E5%88%A9/10/{page}")
    Call<FuLiBean> loadFuLiData(@Path("page") int page);

}
