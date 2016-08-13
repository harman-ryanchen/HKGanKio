package com.example.ryan.hkgankio.view.daily;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.HotnewBean;
import com.example.ryan.hkgankio.presenter.IPresenter;
import com.example.ryan.hkgankio.presenter.imp.DailyHotsPresenter;
import com.example.ryan.hkgankio.support.DailyHotNewsListAdapter;
import com.example.ryan.hkgankio.view.daily.base.IDailyHotsFragment;

import java.util.List;

/**
 * Created by studio02 on 4/25/16.
 */
public class DailyHotsFragment extends DailyBaseListFragment implements IDailyHotsFragment{

    private IPresenter iPresenter;
    @Override
    void initSpecail() {
        iPresenter = new DailyHotsPresenter(this);
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
    public void refreshRecentBeen(List<HotnewBean.RecentBean> recentBeen) {
        hideProgressBar();
        if (adapter==null){
            adapter = new DailyHotNewsListAdapter(recentBeen,getContext());
            recyclerView.setAdapter(adapter);
        }else{
            adapter.addItems(recentBeen);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void loadError(String error) {

    }
}
