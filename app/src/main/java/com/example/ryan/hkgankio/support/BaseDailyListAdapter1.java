package com.example.ryan.hkgankio.support;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by studio02 on 4/25/16.
 */
public abstract class BaseDailyListAdapter1<M,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>{
    protected List<M> mItems = new ArrayList<>();
    protected Context mContext;

    public BaseDailyListAdapter1() {
    }
    public abstract void addItems(List<M> ms);

    protected M getItem(int position){
        return mItems.get(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
