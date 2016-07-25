package com.example.ryan.hkgankio;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.TextView;

import com.example.ryan.hkgankio.bean.FuLiBean;
import com.example.ryan.hkgankio.sample.UnitTestSampleActivity;
import com.example.ryan.hkgankio.sample.UnitTestSampleFragment;
import com.example.ryan.hkgankio.sample.UnitTestServer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboSharedPreferences;
import org.robolectric.internal.ShadowExtractor;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowBitmap;
import org.robolectric.shadows.ShadowLog;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

/**
 * Created by ryan on 7/21/16.
 */
@RunWith(CustomShadowTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21,shadows=ShadowFuLiBean.class)
public class UnitTestSample {
    UnitTestSampleActivity unitTestSampleActivity;
    @Before
    public void setUp() throws Exception {
        ShadowLog.stream = System.out;

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void testActivity() throws Exception {
        unitTestSampleActivity = Robolectric.buildActivity(UnitTestSampleActivity.class).create().resume().get();
        Assert.assertNotNull(unitTestSampleActivity);
        Assert.assertEquals(8,unitTestSampleActivity.getNumber());

    }

    @Test
    public void testViewStatus() throws Exception {
        unitTestSampleActivity = Robolectric.buildActivity(UnitTestSampleActivity.class).create().resume().get();
        TextView textView = (TextView) unitTestSampleActivity.findViewById(R.id.unittest_tv);
        Assert.assertTrue(textView.isEnabled());
        textView.performClick();
    }

    @Test
    public void testFragment() throws Exception {
        UnitTestSampleFragment unitTestSampleFragment = UnitTestSampleFragment.newInstance(2);
        SupportFragmentTestUtil.startFragment(unitTestSampleFragment);
        Assert.assertEquals(2,unitTestSampleFragment.getNumber());
    }

    @Test
    public void testReources() throws Exception {
        Application application = RuntimeEnvironment.application;
        String str = application.getString(R.string.action_settings);
        Assert.assertEquals("Settings",str);
    }

//    @Test
//    public void testServer() throws Exception {
//        Application application = RuntimeEnvironment.application;
//        RoboSharedPreferences preferences = (RoboSharedPreferences) application
//                .getSharedPreferences("example", Context.MODE_PRIVATE);
//
//        UnitTestServer registrationService = new UnitTestServer("ryan_testing");
//        registrationService.onHandleIntent(new Intent());
//
//        Assert.assertEquals(preferences.getString("SAMPLE_DATA", ""), "sample data");
//
//    }

    @Test
    public void testPublicShadow() throws Exception {
        UnitTestSampleActivity mainActivity = Robolectric.setupActivity(UnitTestSampleActivity.class);

        //通过Shadows.shadowOf()可以获取很多Android对象的Shadow对象
        ShadowActivity shadowActivity = Shadows.shadowOf(mainActivity);
        ShadowApplication shadowApplication = Shadows.shadowOf(RuntimeEnvironment.application);

        Bitmap bitmap = BitmapFactory.decodeFile("Path");
        ShadowBitmap shadowBitmap = Shadows.shadowOf(bitmap);

        //Shadow对象提供方便我们用于模拟业务场景进行测试的api
        Assert.assertNull(shadowActivity.getNextStartedActivity());
        Assert.assertNull(shadowApplication.getNextStartedActivity());
        Assert.assertNotNull(shadowBitmap);

    }

    @Test
    public void testCustomShadow() throws Exception {
        FuLiBean person = new FuLiBean();
        //getName()实际上调用的是ShadowPerson的方法

        //获取Person对象对应的Shadow对象
        ShadowFuLiBean shadowPerson = (ShadowFuLiBean) ShadowExtractor.extract(person);
        Assert.assertEquals("FuliBean", shadowPerson.getName());

    }
}
