package com.example.ryan.hkgankio.view.daily;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.bean.StoriesBean;
import com.example.ryan.hkgankio.bean.TopStoriesBean;
import com.example.ryan.hkgankio.support.DailyNewsListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryan on 4/23/16.
 */
public class DailyNewsFragment extends DailyBaseListFragment{
    private List<StoriesBean> storiesBeens;
    private List<TopStoriesBean> topStoriesBeen;

    @Override
    void getArg() {
        mCategory =  getArguments().getString(getString(R.string.argument_item_id));
    }

    @Override
    void loadData() {
        apiService.getLatestNews().enqueue(new Callback<DailyNewsBean>() {
            @Override
            public void onResponse(Call<DailyNewsBean> call, Response<DailyNewsBean> response) {
                hideProgressBar();
                storiesBeens = response.body().getStories();
                topStoriesBeen = response.body().getTop_stories();
                recyclerView.setAdapter(bindAdapter());
            }

            @Override
            public void onFailure(Call<DailyNewsBean> call, Throwable t) {
                Toast.makeText(getContext(),"Load data error",Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    RecyclerView.Adapter bindAdapter() {
        return new DailyNewsListAdapter(storiesBeens,getContext());
    }
}
