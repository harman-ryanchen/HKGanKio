package com.example.ryan.hkgankio.view.daily;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.bean.StoriesBean;
import com.example.ryan.hkgankio.presenter.IPresenter;
import com.example.ryan.hkgankio.presenter.imp.DailyColumnPresenter;
import com.example.ryan.hkgankio.presenter.imp.DailyHotsPresenter;
import com.example.ryan.hkgankio.support.BaseDailyListAdapter;
import com.example.ryan.hkgankio.support.DailyColumnsListAdapter;
import com.example.ryan.hkgankio.support.DailyHotNewsListAdapter;
import com.example.ryan.hkgankio.view.base.IDailyColumnsFragment;
import com.example.ryan.hkgankio.view.base.IDailyHotsFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by studio02 on 4/25/16.
 */
public class DailyColumnsFragment extends DailyBaseListFragment implements IDailyColumnsFragment{


    private IPresenter iPresenter;
    @Override
    void initSpecail() {
        iPresenter = new DailyColumnPresenter(this);
    }

    @Override
    void getArg() {
        mCategory =  getArguments().getString(getString(R.string.argument_item_id));
    }

    @Override
    void loadData() {
        iPresenter.loadData();
    }

    @Override
    public void refreshColumnBeen(List<ColumnBean.DataBean> columnBeen) {
        hideProgressBar();
        if (adapter==null){
            adapter = new DailyColumnsListAdapter(columnBeen,getContext());
            recyclerView.setAdapter(adapter);
        }else{
            adapter.addItems(columnBeen);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void loadError(String error) {

    }
}
