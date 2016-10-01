package com.example.ryan.hkgankio.view;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ryan.hkgankio.IMyAidlInterface;
import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.common.HKCommon;
import com.example.ryan.hkgankio.designpattern.visitor.ActivityVisitorPattern;
import com.example.ryan.hkgankio.service.MyAidlService;
import com.example.ryan.hkgankio.util.ToolBarControler;
import com.example.ryan.hkgankio.util.ToolBarInfo;
import com.example.ryan.hkgankio.view.Tools.ToolsFragment;
import com.example.ryan.hkgankio.view.daily.DailyNavigationFragment;
import com.example.ryan.hkgankio.view.gallery.GalleryFragment;
import com.example.ryan.hkgankio.view.setting.SettingFragment;
import com.example.ryan.hkgankio.view.slideshow.SlideshowFragment;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
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
        if (savedInstanceState == null) {
            switchFragment(HKCommon.TAG_DAILY);
        }
        EventBus.getDefault().register(this);
        ininAidlService();
    }
    private IMyAidlInterface iMyAidlInterface;
    private  MyServiceConnection myServiceConnection;
    private void ininAidlService() {
        myServiceConnection = new MyServiceConnection();
        bindService(new Intent(this, MyAidlService.class),myServiceConnection,BIND_AUTO_CREATE);
    }
    public class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
            try {
                Logger.d("TEST_AIDL_GETNAME = %s", iMyAidlInterface.getName());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        unbindService(myServiceConnection);
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
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
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
            switchFragment(HKCommon.TAG_DAILY);
        } else if (id == R.id.nav_gallery) {
            switchFragment(HKCommon.TAG_GALLERY);
        } else if (id == R.id.nav_slideshow) {
            switchFragment(HKCommon.TAG_SLIDESHOW);
        } else if (id == R.id.nav_manage) {
            switchFragment(HKCommon.TAG_TOOL);
        } else if (id == R.id.nav_share) {
            switchFragment(HKCommon.TAG_SETTING);
        } else if (id == R.id.nav_send) {
            startActivity(new Intent(this,ActivityVisitorPattern.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private Fragment currentFragment;
    private void switchFragment(String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        currentFragment = fragmentManager.findFragmentByTag(tag);
        if (currentFragment==null){
            if (tag.equals(HKCommon.TAG_DAILY)){
                currentFragment = new DailyNavigationFragment();
            }else if (tag.equals(HKCommon.TAG_GALLERY)){
                currentFragment = new GalleryFragment();
            }else if (tag.equals(HKCommon.TAG_SLIDESHOW)){
                currentFragment = new SlideshowFragment();
            }else if (tag.equals(HKCommon.TAG_TOOL)){
                currentFragment = new ToolsFragment();
            }else if (tag.equals(HKCommon.TAG_SETTING)){
                currentFragment = new SettingFragment();
                try {
                    iMyAidlInterface.setName("我随便按个东西洛");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout, currentFragment,tag);
        transaction.commit();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void reveiveMessage(String meesage){
        Toast.makeText(this,"I get a meesage"+meesage,Toast.LENGTH_SHORT).show();
    }
}
