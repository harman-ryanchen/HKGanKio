package com.example.ryan.hkgankio.util;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by ryan on 12/27/15.
 */
public class ToolBarControler {

    private AppCompatActivity mContext;
    private Toolbar mToolbar;

    public ToolBarControler(AppCompatActivity mContext, Toolbar mToolbar) {
        this.mContext = mContext;
        this.mToolbar = mToolbar;
        initToolbar();
    }

    private void initToolbar() {
        mContext.setSupportActionBar(mToolbar);
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    /**
     * @param toolbarInfo
     */
    public void setToolbarInfo(ToolBarInfo toolbarInfo) {


        if (toolbarInfo.getTitleTextContent() != null) {
            mToolbar.setTitle(toolbarInfo.getTitleTextContent());
        }
//        if (toolbarInfo.getToolbarLogo() != 0) {
//            mToolbar.setNavigationIcon(toolbarInfo.getToolbarLogo());
//
//        } else {
//            mToolbar.setNavigationIcon(null);
//        }
//
//        if (toolbarInfo.getNavigationIcon_color() != 0) {
//            mToolbar.setTitleTextColor(toolbarInfo.getNavigationIcon_color());
//        }
//        if (toolbarInfo.getMenu() != 0) {
//            mToolbar.inflateMenu(toolbarInfo.getMenu());
//        } else {
//            mToolbar.getMenu().clear();
//        }
    }



}
