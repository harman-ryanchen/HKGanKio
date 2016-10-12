package com.example.ryan.hkgankio.view.rxandroid;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.bean.Persion;
import com.orhanobut.logger.Logger;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by studio02 on 5/18/16.
 */
public class RxAndroidActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
        imageView = (ImageView) findViewById(R.id.image_iv);
        findViewById(R.id.setupPicture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRxObserver();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void initRxObserver() {
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Logger.e("TEST_RX %s", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Logger.e("TEST_RX %s", "onError");
            }

            @Override
            public void onNext(String s) {
                Logger.e("TEST_RX %s, value = %s", "onNext", s);
            }
        };

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Logger.e("TEST_RX %s", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Logger.e("TEST_RX %s", "onError");
            }

            @Override
            public void onNext(String s) {
                Logger.e("TEST_RX %s, value = %s", "onNext", s);
            }
        };
        Observable.OnSubscribe<String> onSubscribe = new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("WHO");
                subscriber.onNext("are");
                subscriber.onNext("you");
            }
        };
        Observable observable = Observable.create(onSubscribe);
        observable.subscribe(subscriber);

        String[] names = new String[]{"fwef", "fwefew", "fwe2f", "fwefe421w"};
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.e("TEST_RX %s, value = %s", "call", s);
            }
        });

        final int[] drawables = new int[]{R.drawable.pic_1, R.drawable.pic_2, R.drawable.pic_3, R.drawable.pic_4};
        final int drawable = R.drawable.pic_1;
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                try {
                    Drawable drawable1 = getTheme().getDrawable(drawables[0]);
                    subscriber.onNext(drawable1);
                    Thread.sleep(1000);
                    Drawable drawable2 = getTheme().getDrawable(drawables[1]);
                    subscriber.onNext(drawable2);   Thread.sleep(1000);
                    Drawable drawable3 = getTheme().getDrawable(drawables[2]);
                    subscriber.onNext(drawable3);   Thread.sleep(1000);
                    Drawable drawable4 = getTheme().getDrawable(drawables[3]);
                    subscriber.onNext(drawable4);
                    subscriber.onCompleted();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Drawable>() {
            @Override
            public void onCompleted() {

                Logger.e("TEST_RX %s", "onCompleted");
            }


            @Override
            public void onError(Throwable e) {
                Logger.e("TEST_RX %s, value = %s", "onError", e);
            }

            @Override
            public void onNext(Drawable drawable) {
                Logger.e("TEST_RX %s", "onNext");
                imageView.setImageDrawable(drawable);
            }
        });

        //简单的变换
        Observable.just("harman.com").map(new Func1<String, Bitmap>() {
            @Override
            public Bitmap call(String s) {
                return null;

            }
        }).subscribe(new Action1<Bitmap>() {
            @Override
            public void call(Bitmap bitmap) {

            }
        });

        //多态变换
        final Persion[] persions = new Persion[]{new Persion("ryan",30),new Persion("yu",32)};
        Subscriber<String> subscriber1 = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Logger.e("TEST_RX %s , value = %s", "onNext",s);
            }
        };
        Observable.from(persions).flatMap(new Func1<Persion, Observable<String>>() {
            @Override
            public Observable<String> call(Persion persion) {
                return Observable.from(persion.getHobbies());
            }
        }).subscribe(subscriber1);

        BehaviorSubject subject = BehaviorSubject.create();
    }
}
