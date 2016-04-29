package com.example.ryan.hkgankio.view.base;

import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.bean.ThemeBean;

import java.util.List;

/**
 * Created by studio02 on 4/29/16.
 */
public interface IDailyThemesFragment {

    void refreshThemeBeen(List<ThemeBean.OthersBean> themeBeen);

    void loadError(String error);
}
