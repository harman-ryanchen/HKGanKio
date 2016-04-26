package com.example.ryan.hkgankio.view.daily;

import android.support.v7.widget.RecyclerView;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.bean.HotnewBean;
import com.example.ryan.hkgankio.bean.ThemeBean;
import com.example.ryan.hkgankio.presenter.BaseDailyPresenter;
import com.example.ryan.hkgankio.presenter.DailyPresenter;
import com.example.ryan.hkgankio.support.DailyColumnsListAdapter;
import com.example.ryan.hkgankio.support.DailyThemesListAdapter;

import java.util.List;

/**
 * Created by studio02 on 4/25/16.
 */
public class DailyColumnsFragment extends DailyBaseListFragment implements IBaseDailyFragment{

    private List<ColumnBean.DataBean> columnBean;
    @Override
    BaseDailyPresenter createPresenter() {
        return  new DailyPresenter(this);
    }

    @Override
    void getArg() {
        mCategory =  getArguments().getString(getString(R.string.argument_item_id));
    }

    @Override
    void loadData() {
        dailyPresenter.loadDailyColumnData();
    }

    @Override
    RecyclerView.Adapter bindAdapter() {
        return new DailyColumnsListAdapter(columnBean,getContext());
    }

    @Override
    public void onLoadNewsResult(DailyNewsBean newsBean) {

    }

    @Override
    public void onLoadHotNewsResult(HotnewBean hotnewBean) {

    }

    @Override
    public void onLoadColumnsResult(ColumnBean columnBean) {
        hideProgressBar();
        if (columnBean==null)return;
        this.columnBean = columnBean.getData();
        adapter = bindAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoadThemesResult(ThemeBean themeBean) {

    }
}
