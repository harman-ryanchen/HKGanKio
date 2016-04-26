package com.example.ryan.hkgankio.model;

import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.bean.DailyWebBean;
import com.example.ryan.hkgankio.bean.HotnewBean;
import com.example.ryan.hkgankio.bean.StoriesBean;
import com.example.ryan.hkgankio.bean.ThemeBean;
import com.example.ryan.hkgankio.listeners.BaseMultiLoadedListener;

import java.util.List;

/**
 * Created by ryan on 4/23/16.
 */
public interface BaseDailyModel {
    void loadDailyNews(BaseMultiLoadedListener<DailyNewsBean> newsBeanBaseMultiLoadedListener);
    void loadDailyHotsNews(BaseMultiLoadedListener<HotnewBean> newsBeanBaseMultiLoadedListener);
    void loadDailyThemes(BaseMultiLoadedListener<ThemeBean> newsBeanBaseMultiLoadedListener);
    void loadDailyColumn(BaseMultiLoadedListener<ColumnBean> newsBeanBaseMultiLoadedListener);
    void loadDailyDetail(String url,BaseMultiLoadedListener<DailyWebBean> newsBeanBaseMultiLoadedListener);
}
