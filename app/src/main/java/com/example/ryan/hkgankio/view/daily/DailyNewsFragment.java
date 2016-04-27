package com.example.ryan.hkgankio.view.daily;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.bean.StoriesBean;
import com.example.ryan.hkgankio.bean.TopStoriesBean;
import com.example.ryan.hkgankio.support.DailyNewsListAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryan on 4/23/16.
 */
public class DailyNewsFragment extends DailyBaseListFragment{
    private List<StoriesBean> storiesBeens;
    private List<TopStoriesBean> topStoriesBeen;

    @Override
    void getArg() {
        mCategory =  getArguments().getString(getString(R.string.argument_item_id));
    }

    @Override
    void loadData() {
        apiService.getLatestNews().enqueue(new Callback<DailyNewsBean>() {
            @Override
            public void onResponse(Call<DailyNewsBean> call, Response<DailyNewsBean> response) {
                convenientBanner.setVisibility(View.VISIBLE);
                hideProgressBar();
                storiesBeens = response.body().getStories();
                topStoriesBeen = response.body().getTop_stories();
                recyclerView.setAdapter(bindAdapter());
                settleDataToConvenientBanner();
            }

            @Override
            public void onFailure(Call<DailyNewsBean> call, Throwable t) {
                Toast.makeText(getContext(),"Load data error",Toast.LENGTH_SHORT);
            }
        });
    }
    private void settleDataToConvenientBanner(){
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
    RecyclerView.Adapter bindAdapter() {
        return new DailyNewsListAdapter(storiesBeens,getContext());
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
