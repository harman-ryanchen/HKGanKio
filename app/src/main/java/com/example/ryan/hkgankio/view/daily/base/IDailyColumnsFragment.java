package com.example.ryan.hkgankio.view.daily.base;

import com.example.ryan.hkgankio.bean.ColumnBean;

import java.util.List;

/**
 * Created by studio02 on 4/29/16.
 */
public interface IDailyColumnsFragment {

    void refreshColumnBeen(List<ColumnBean.DataBean> columnBeen);

    void loadError(String error);
}
