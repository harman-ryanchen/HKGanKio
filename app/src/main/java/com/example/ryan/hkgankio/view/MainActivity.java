package com.example.ryan.hkgankio.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.util.FragmentControler;
import com.example.ryan.hkgankio.util.FragmentsType;
import com.example.ryan.hkgankio.util.ToolBarControler;
import com.example.ryan.hkgankio.util.ToolBarInfo;
import com.example.ryan.hkgankio.view.Tools.ToolsFragment;
import com.example.ryan.hkgankio.view.daily.DailyNavigationFragment;
import com.example.ryan.hkgankio.view.gallery.GalleryFragment;
import com.example.ryan.hkgankio.view.setting.SettingFragment;
import com.example.ryan.hkgankio.view.slideshow.SlideshowFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentControler fragmentControler;
    private ToolBarControler toolBarControler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentControler = new FragmentControler(getSupportFragmentManager(),R.id.framelayout);
        if (savedInstanceState == null) {
            fragmentControler.showMainFragment(new DailyNavigationFragment());
        }
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolBarControler = new ToolBarControler(this,toolbar);
        toolBarControler.setToolbarInfo(new ToolBarInfo.Builder().setToolBarContentText(getString(R.string.app_name)).build());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }
    public void setToolBarInfo(ToolBarInfo info){
        toolBarControler.setToolbarInfo(info);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            // Handle the camera action
            fragmentControler.showMainFragment(new DailyNavigationFragment());
        } else if (id == R.id.nav_gallery) {
            fragmentControler.showMainFragment(new GalleryFragment());
        } else if (id == R.id.nav_slideshow) {
            fragmentControler.showMainFragment(new SlideshowFragment());
        } else if (id == R.id.nav_manage) {
            fragmentControler.showMainFragment(new ToolsFragment());
        } else if (id == R.id.nav_share) {
            fragmentControler.showMainFragment(new DailyNavigationFragment());
        } else if (id == R.id.nav_send) {
            fragmentControler.showMainFragment(new SettingFragment());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
