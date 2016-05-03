package com.example.ryan.hkgankio.view.gallery;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.FuLiBean;
import com.example.ryan.hkgankio.listener.OnRcvScrollListener;
import com.example.ryan.hkgankio.presenter.IGalleryPresenter;
import com.example.ryan.hkgankio.presenter.imp.GalleryPresenter;
import com.example.ryan.hkgankio.util.ToolBarInfo;
import com.example.ryan.hkgankio.view.MainActivity;
import com.example.ryan.hkgankio.view.gallery.base.IGalleryFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by studio02 on 4/29/16.
 */
public class GalleryFragment extends Fragment implements IGalleryFragment {
    private RecyclerView recyclerView;
    private IGalleryPresenter iPresenter;
    private List<FuLiBean.ResultsBean> mFuLiBeens = new ArrayList<>();
    private MeizhiListAdapter meizhiListAdapter;
    private int currentPage = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setToolBarInfo(new ToolBarInfo.Builder().setToolBarContentText("GalleryFragment").build());
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        iPresenter = new GalleryPresenter(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        initRecyclerview();
        iPresenter.loadFuLiData(currentPage);
        recyclerView.setOnScrollListener(new OnRcvScrollListener(){
            @Override
            public void onBottom() {
                currentPage++;
                iPresenter.loadFuLiData(currentPage);
            }
        });
        return view;
    }

    private void initRecyclerview() {
        StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onResultFromNet(FuLiBean fuLiBean) {
        if (meizhiListAdapter ==null){
            meizhiListAdapter = new MeizhiListAdapter();
            recyclerView.setAdapter(meizhiListAdapter);
        }
        mFuLiBeens.addAll(fuLiBean.getResults());
        meizhiListAdapter.notifyDataSetChanged();
    }

    public class MeizhiListAdapter extends RecyclerView.Adapter<MeizhiListAdapter.ViewHolder>{

        @Override
        public MeizhiListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_gallery_gril, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MeizhiListAdapter.ViewHolder holder, int position) {
            holder.titleview.setText(mFuLiBeens.get(position).getDesc());
            holder.iv_meizhi.setImageURI(Uri.parse(mFuLiBeens.get(position).getUrl()));
        }

        @Override
        public int getItemCount() {
            return mFuLiBeens.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

//            @BindView(R.id.news_image)
            SimpleDraweeView iv_meizhi;
//            @BindView(R.id.tv_title)
            TextView titleview;


            public ViewHolder(View itemView) {
                super(itemView);
//                ButterKnife.bind(this, itemView);
                iv_meizhi = (SimpleDraweeView) itemView.findViewById(R.id.meizhi_image);
                titleview = (TextView) itemView.findViewById(R.id.tv_title);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
        }
    }
}
