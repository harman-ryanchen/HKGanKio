package com.example.ryan.hkgankio.view.daily;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.StoriesBean;
import com.example.ryan.hkgankio.bean.TopStoriesBean;
import com.example.ryan.hkgankio.listener.OnRcvScrollListener;
import com.example.ryan.hkgankio.presenter.IDailyNewsPresenter;
import com.example.ryan.hkgankio.presenter.imp.DailyNewsPresenter;
import com.example.ryan.hkgankio.support.BaseDailyListAdapter;
import com.example.ryan.hkgankio.support.DailyNewsListAdapter;
import com.example.ryan.hkgankio.view.base.IDailNewsFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


/**
 * Created by ryan on 4/23/16.
 */
@TargetApi(Build.VERSION_CODES.M)
public class DailyNewsFragment extends DailyBaseListFragment implements IDailNewsFragment {
    private IDailyNewsPresenter iDailyNewsPresenter;


    @Override
    void initSpecail() {
        convenientBanner.setVisibility(View.VISIBLE);
        iDailyNewsPresenter = new DailyNewsPresenter(this);
        recyclerView.setOnScrollListener(new OnRcvScrollListener(){
            @Override
            public void onBottom() {
                super.onBottom();
                iDailyNewsPresenter.loadBeforeNewsData();
            }
        });
    }

    @Override
    void getArg() {
        mCategory =  getArguments().getString(getString(R.string.argument_item_id));
    }

    @Override
    void loadData() {
        iDailyNewsPresenter.loadLaestNewsData();
    }

    private void settleDataToConvenientBanner(List<TopStoriesBean> topStoriesBeen){
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        //网络加载例子
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        },topStoriesBeen)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused});
                //设置指示器的方向
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
    }


    @Override
    public void refreshLaestTopStories(List<TopStoriesBean> topStoriesBeen) {
        hideProgressBar();
        settleDataToConvenientBanner(topStoriesBeen);
    }

    @Override
    public void refreshStories(List<StoriesBean> storiesBeen) {
        hideProgressBar();
        if (adapter==null){
            adapter = new DailyNewsListAdapter(storiesBeen,getContext());
            recyclerView.setAdapter(adapter);
        }else{
            adapter.addItems(storiesBeen);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void loadError(String error) {

    }


    public class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
        }
    }

    public class NetworkImageHolderView implements Holder<TopStoriesBean> {
        private SimpleDraweeView imageView;
        @Override
        public View createView(Context context) {
            //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
            imageView = new SimpleDraweeView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, TopStoriesBean data) {
            imageView.setImageURI(Uri.parse(data.getImage()));

        }
    }
}
