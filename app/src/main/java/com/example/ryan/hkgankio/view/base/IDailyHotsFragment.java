package com.example.ryan.hkgankio.view.base;

import com.example.ryan.hkgankio.bean.HotnewBean;
import com.example.ryan.hkgankio.bean.StoriesBean;

import java.util.List;

/**
 * Created by studio02 on 4/29/16.
 */
public interface IDailyHotsFragment{

    void refreshRecentBeen(List<HotnewBean.RecentBean> recentBeen);

    void loadError(String error);
}
