package com.example.ryan.hkgankio.view.daily;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.ThemeBean;
import com.example.ryan.hkgankio.presenter.IPresenter;
import com.example.ryan.hkgankio.presenter.imp.DailyColumnPresenter;
import com.example.ryan.hkgankio.presenter.imp.DailyThemesPresenter;
import com.example.ryan.hkgankio.support.BaseDailyListAdapter;
import com.example.ryan.hkgankio.support.DailyHotNewsListAdapter;
import com.example.ryan.hkgankio.support.DailyThemesListAdapter;
import com.example.ryan.hkgankio.view.base.IDailyThemesFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by studio02 on 4/25/16.
 */
public class DailyThemesFragment extends DailyBaseListFragment implements IDailyThemesFragment{

    private IPresenter iPresenter;
    @Override
    void initSpecail() {
        iPresenter = new DailyThemesPresenter(this);
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
    public void refreshThemeBeen(List<ThemeBean.OthersBean> themeBeen) {
        hideProgressBar();
        if (adapter==null){
            adapter = new DailyThemesListAdapter(themeBeen,getContext());
            recyclerView.setAdapter(adapter);
        }else{
            adapter.addItems(themeBeen);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void loadError(String error) {

    }
}
