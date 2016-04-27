package com.example.ryan.hkgankio.view.daily;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.support.DailyColumnsListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by studio02 on 4/25/16.
 */
public class DailyColumnsFragment extends DailyBaseListFragment{

    private List<ColumnBean.DataBean> columnBean;

    @Override
    void getArg() {
        mCategory =  getArguments().getString(getString(R.string.argument_item_id));
    }

    @Override
    void loadData() {
        apiService.getDailysections().enqueue(new Callback<ColumnBean>() {
            @Override
            public void onResponse(Call<ColumnBean> call, Response<ColumnBean> response) {
                hideProgressBar();
                columnBean = response.body().getData();
                recyclerView.setAdapter( bindAdapter());
            }

            @Override
            public void onFailure(Call<ColumnBean> call, Throwable t) {
                Toast.makeText(getContext(),"Load data error",Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    RecyclerView.Adapter bindAdapter() {
        return new DailyColumnsListAdapter(columnBean,getContext());
    }
}
