package com.example.ryan.hkgankio.view.daily;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.HotnewBean;
import com.example.ryan.hkgankio.support.DailyHotNewsListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by studio02 on 4/25/16.
 */
public class DailyHotsFragment extends DailyBaseListFragment{

    private List<HotnewBean.RecentBean> recentBeen;
    @Override
    void getArg() {
        mCategory =  getArguments().getString(getString(R.string.argument_item_id));
    }

    @Override
    void loadData() {
        apiService.getHotNews().enqueue(new Callback<HotnewBean>() {
            @Override
            public void onResponse(Call<HotnewBean> call, Response<HotnewBean> response) {
                hideProgressBar();
                recentBeen = response.body().getRecent();
                recyclerView.setAdapter(bindAdapter());
            }

            @Override
            public void onFailure(Call<HotnewBean> call, Throwable t) {
                Toast.makeText(getContext(),"Load data error",Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    RecyclerView.Adapter bindAdapter() {
        return new DailyHotNewsListAdapter(recentBeen,getContext());
    }
}
