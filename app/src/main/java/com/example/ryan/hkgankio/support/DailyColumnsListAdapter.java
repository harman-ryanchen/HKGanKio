package com.example.ryan.hkgankio.support;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.ColumnBean;
import com.example.ryan.hkgankio.common.HKCommon;
import com.example.ryan.hkgankio.view.daily.WebViewUrlActivty;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by studio02 on 4/25/16.
 */
public class DailyColumnsListAdapter extends BaseDailyListAdapter<ColumnBean.DataBean, DailyColumnsListAdapter.ViewHolder> {


    public DailyColumnsListAdapter(List<ColumnBean.DataBean> mItems, Context mContext) {
        super(mItems, mContext);
    }

    @Override
    public void addItems(List<ColumnBean.DataBean> dataBeen) {

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item_layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_daily_news_adapter, parent, false);
        ViewHolder vh = new ViewHolder(item_layout);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ColumnBean.DataBean sb = mItems.get(position);
        holder.news_content.setText(sb.getName());
        holder.news_image.setImageURI(Uri.parse(sb.getThumbnail()));
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, WebViewUrlActivty.class);
                Bundle bundle = new Bundle();
                //    http://news-at.zhihu.com/api/3/section/1
                bundle.putString(HKCommon.argument_detail_url_num,HKCommon.argument_detail_url_num_3);
                bundle.putString(HKCommon.argument_detail_url_section,HKCommon.argument_detail_url_section_section);
                bundle.putInt(HKCommon.argument_detail_url_id,getItem(position).getId());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View parentView;
        private TextView news_content;
        private SimpleDraweeView news_image;

        ViewHolder(View itemView) {
            super(itemView);
            parentView = itemView;
            news_content = (TextView) itemView.findViewById(R.id.news_content);
            news_image = (SimpleDraweeView) itemView.findViewById(R.id.news_image);
        }
    }
}
