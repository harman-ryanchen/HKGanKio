package com.example.ryan.hkgankio.view.base;

import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.bean.HotnewBean;

import java.util.List;

/**
 * Created by studio02 on 4/29/16.
 */
public interface IDailyColumnsFragment {

    void refreshColumnBeen(List<ColumnBean.DataBean> columnBeen);

    void loadError(String error);
}
