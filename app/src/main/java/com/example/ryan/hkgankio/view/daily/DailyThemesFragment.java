package com.example.ryan.hkgankio.view.daily;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.ThemeBean;
import com.example.ryan.hkgankio.support.DailyThemesListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by studio02 on 4/25/16.
 */
public class DailyThemesFragment extends DailyBaseListFragment{

    private List<ThemeBean.OthersBean> themeBeen;
    @Override
    void getArg() {
        mCategory =  getArguments().getString(getString(R.string.argument_item_id));
    }

    @Override
    void loadData() {
        apiService.getDailyThemes().enqueue(new Callback<ThemeBean>() {
            @Override
            public void onResponse(Call<ThemeBean> call, Response<ThemeBean> response) {
                hideProgressBar();
                themeBeen = response.body().getOthers();
                recyclerView.setAdapter( bindAdapter());
            }

            @Override
            public void onFailure(Call<ThemeBean> call, Throwable t) {
                Toast.makeText(getContext(),"Load data error",Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    RecyclerView.Adapter bindAdapter() {
        return new DailyThemesListAdapter(themeBeen,getContext());
    }
}
