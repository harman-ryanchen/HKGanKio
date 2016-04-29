package com.example.ryan.hkgankio.view.daily.base;

import com.example.ryan.hkgankio.bean.StoriesBean;
import com.example.ryan.hkgankio.bean.TopStoriesBean;

import java.util.List;

/**
 * Created by studio02 on 4/29/16.
 */
public interface IDailNewsFragment {

    void refreshLaestTopStories(List<TopStoriesBean> topStoriesBeen);
    void refreshStories(List<StoriesBean> storiesBeen);
    void loadError(String error);
}
