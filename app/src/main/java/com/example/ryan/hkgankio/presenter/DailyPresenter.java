package com.example.ryan.hkgankio.presenter;

import android.util.ArrayMap;

import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.bean.HotnewBean;
import com.example.ryan.hkgankio.bean.ThemeBean;
import com.example.ryan.hkgankio.listeners.BaseMultiLoadedListener;
import com.example.ryan.hkgankio.model.BaseDailyModel;
import com.example.ryan.hkgankio.model.DailyModel;
import com.example.ryan.hkgankio.view.daily.IBaseDailyFragment;

import java.util.HashMap;

/**
 * Created by ryan on 4/24/16.
 */
public class DailyPresenter implements BaseDailyPresenter{
    private IBaseDailyFragment iBaseDailyFragment;
    private BaseDailyModel baseDailyModel;

    public DailyPresenter(IBaseDailyFragment iBaseDailyFragment) {
        this.iBaseDailyFragment = iBaseDailyFragment;
        this.baseDailyModel = new DailyModel();
    }

    @Override
    public void loadDailyNewsData() {
        baseDailyModel.loadDailyNews(new BaseMultiLoadedListener<DailyNewsBean>() {
            @Override
            public void onSuccess(int event_tag, DailyNewsBean data) {
                iBaseDailyFragment.onLoadNewsResult(data);
            }

            @Override
            public void onError(String msg) {

            }

            @Override
            public void onException(String msg) {

            }
        });
    }

    @Override
    public void loadDailyHotNewsData() {
        baseDailyModel.loadDailyHotsNews(new BaseMultiLoadedListener<HotnewBean>() {
            @Override
            public void onSuccess(int event_tag, HotnewBean data) {
                iBaseDailyFragment.onLoadHotNewsResult(data);
            }

            @Override
            public void onError(String msg) {

            }

            @Override
            public void onException(String msg) {

            }
        });
    }

    @Override
    public void loadDailyThemesData() {
        baseDailyModel.loadDailyThemes(new BaseMultiLoadedListener<ThemeBean>() {
            @Override
            public void onSuccess(int event_tag, ThemeBean data) {
                iBaseDailyFragment.onLoadThemesResult(data);
            }

            @Override
            public void onError(String msg) {

            }

            @Override
            public void onException(String msg) {

            }
        });
    }

    @Override
    public void loadDailyColumnData() {
        baseDailyModel.loadDailyColumn(new BaseMultiLoadedListener<ColumnBean>() {
            @Override
            public void onSuccess(int event_tag, ColumnBean data) {
                iBaseDailyFragment.onLoadColumnsResult(data);
            }

            @Override
            public void onError(String msg) {

            }

            @Override
            public void onException(String msg) {

            }
        });
    }

}
