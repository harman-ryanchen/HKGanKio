package com.example.ryan.hkgankio.view.gallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.FuLiBean;

import java.util.List;

/**
 * Created by studio02 on 5/3/16.
 */
public class GalleryActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private List<FuLiBean.ResultsBean> mFuLiBeens;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        viewPager = (ViewPager) findViewById(R.id.gallery_container);
        mFuLiBeens = (List<FuLiBean.ResultsBean>) getIntent().getSerializableExtra("meizhi");
        int position = getIntent().getIntExtra("position",0);
        viewPager.setAdapter(new PictureGalleryAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    private class PictureGalleryAdapter extends FragmentStatePagerAdapter {

        public PictureGalleryAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return GalleryImageFragment.newInstance(mFuLiBeens.get(position).getUrl());
        }

        @Override
        public int getCount() {
            return mFuLiBeens.size();
        }
    }
}
