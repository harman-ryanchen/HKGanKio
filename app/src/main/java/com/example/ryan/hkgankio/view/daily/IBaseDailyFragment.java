package com.example.ryan.hkgankio.view.daily;

import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.bean.DailyWebBean;
import com.example.ryan.hkgankio.bean.HotnewBean;
import com.example.ryan.hkgankio.bean.StoriesBean;
import com.example.ryan.hkgankio.bean.ThemeBean;

import java.util.List;

/**
 * Created by ryan on 4/23/16.
 */
public interface IBaseDailyFragment extends IBaseFragment{



    /**
     * get data result after it query news
     * @param
     */
    void onLoadNewsResult(DailyNewsBean newsBean);

    /**
     * get data result after it query hot news
     * @param
     */
    void onLoadHotNewsResult(HotnewBean hotnewBean);

    /**
     * get data result after it query hot news
     * @param
     */
    void onLoadColumnsResult(ColumnBean columnBean);

    /**
     * get data result after it query hot news
     * @param
     */
    void onLoadThemesResult(ThemeBean themeBean);

    /**
     * get data result after it query hot news
     * @param
     */
    void onLoadWebDetailResult(DailyWebBean dailyWebBean );


}
