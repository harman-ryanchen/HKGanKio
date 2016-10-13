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

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.OnSubscribeSingle;
import rx.schedulers.Schedulers;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

/**
 * Created by studio02 on 5/18/16.
 */
public class RxAndroidActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava_activity);
        imageView = (ImageView) findViewById(R.id.image_iv);
        findViewById(R.id.observable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                createObservable();
//                observableJust();
//                observableFrom();
//                observableInterval();
//                observableRange();
                observableTime();
            }
        });
        findViewById(R.id.observer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                observerNormal();
//                observerNormal2();
//                observerNormal3();
                observerNormal4();
            }
        });
        findViewById(R.id.single_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               single_1();
//                    singleCreate();
//                singleMap();
//                singleFlatmap();
//                    singleOnErrorReturn();
//                    singleTimeOut();
                singleZip();
            }
        });
        findViewById(R.id.subject).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                asysncSubject();
//                behaviorSubject();
//                publishSubject();
                replaySubject();
            }
        });
        findViewById(R.id.schduler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCycleTiming();
            }
        });

        findViewById(R.id.schduler_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscription.unsubscribe();
            }
        });

    }

    private void observerNormal4() {
        Observable.create(new Observable.OnSubscribe<String[]>() {
            @Override
            public void call(Subscriber<? super String[]> subscriber) {
                String[] strings = new String[]{"ryan","sky","jake","xxx"};
                subscriber.onNext(strings);
            }
        }).flatMap(new Func1<String[], Observable<String>>() {
            @Override
            public Observable<String> call(String[] strings) {
                return Observable.from(strings);
            }
        }).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.equals("ryan");
            }
        }).map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return 108;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.e("TEST_RX observerNormal4 %s", integer);
            }
        });
    }

    private void observerNormal3() {
        Observable.create(new Observable.OnSubscribe<String[]>() {
            @Override
            public void call(Subscriber<? super String[]> subscriber) {
                String[] strings = new String[]{"ryan","sky","jake","xxx"};
                subscriber.onNext(strings);
            }
        }).flatMap(new Func1<String[], Observable<String>>() {
            @Override
            public Observable<String> call(String[] strings) {
                return Observable.from(strings);
            }
        }).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.equals("ryan");
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.e("TEST_RX observerNormal3 %s", s);
            }
        });

    }

    /**
     * 最普通的接收源,也就是观察者
     */
    private void observerNormal() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Logger.e("TEST_RX observerNormal %s", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Logger.e("TEST_RX observerNormal onError %s", e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Logger.e("TEST_RX observerNormal onNext %s", s);
            }
        };
        Observable.just("ryan").subscribe(observer);
    }
    private void observerNormal2(){
        final String[] strings = new String[]{"ryan","sky","jake","xxx"};
        Observable.create(new Observable.OnSubscribe<String[]>() {
            @Override
            public void call(Subscriber<? super String[]> subscriber) {
                String[] strings2 = new String[2];
                strings2[0] = strings[3];
                strings2[1] = strings[0];
                subscriber.onNext(strings2);

            }
        }).subscribe(new Action1<String[]>() {
            @Override
            public void call(String[] strings) {
                Logger.e("TEST_RX observerNormal2 onNext size = %s,value1 = %s", strings.length,strings[0]);
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
                    subscriber.onNext(drawable2);
                    Thread.sleep(1000);
                    Drawable drawable3 = getTheme().getDrawable(drawables[2]);
                    subscriber.onNext(drawable3);
                    Thread.sleep(1000);
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
        final Persion[] persions = new Persion[]{new Persion("ryan", 30), new Persion("yu", 32)};
        Subscriber<String> subscriber1 = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Logger.e("TEST_RX %s , value = %s", "onNext", s);
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

    private void single_1() {
        Single.just(addValue(5, 7)).subscribe(new SingleSubscriber<Integer>() {
            @Override
            public void onSuccess(Integer value) {
                Logger.e("TEST_RX single_1 success = %s ", value);
            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }

    private void singleCreate() {
        Single.create(new Single.OnSubscribe<Integer>() {
            @Override
            public void call(SingleSubscriber<? super Integer> singleSubscriber) {
                Logger.e("TEST_RX single_1 success = %s ");
                singleSubscriber.onSuccess(addValue(6, 9));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleSubscriber<Integer>() {
            @Override
            public void onSuccess(Integer value) {
                Logger.e("TEST_RX single_1 success = %s ", value);
            }

            @Override
            public void onError(Throwable error) {
                Logger.e("TEST_RX single_1 onError = %s ", error.getMessage());
            }
        });
    }

    private void singleMap() {
        Single.just(addValue(54, 86)).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return "value = " + integer;
            }
        }).subscribe(new SingleSubscriber<String>() {
            @Override
            public void onSuccess(String value) {
                Logger.e("TEST_RX singleMap = %s ", value);
            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }

    private void singleFlatmap() {
        Single.create(new Single.OnSubscribe<Integer>() {
            @Override
            public void call(SingleSubscriber<? super Integer> singleSubscriber) {
                singleSubscriber.onSuccess(addValue(543, 436));
            }
        }).flatMapObservable(new Func1<Integer, Observable<String>>() {
            @Override
            public Observable<String> call(Integer integer) {
                return Observable.just("value = " + integer);
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.e("TEST_RX singleFlatmap = %s ", s);
            }
        });
    }

    private void singleOnErrorReturn() {
        Single.create(new Single.OnSubscribe<Integer>() {
            @Override
            public void call(SingleSubscriber<? super Integer> singleSubscriber) {
//                singleSubscriber.onSuccess(addValue(241,6544435));
                singleSubscriber.onError(new Throwable("dw"));
            }
        }).onErrorReturn(new Func1<Throwable, Integer>() {
            @Override
            public Integer call(Throwable throwable) {
                return addValue(6346, 8658);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Logger.e("TEST_RX onNext = %s ", integer);
            }
        });
    }

    private void singleTimeOut() {
        Single.create(new Single.OnSubscribe<Integer>() {
            @Override
            public void call(SingleSubscriber<? super Integer> singleSubscriber) {
                try {
                    Thread.sleep(2000);
                    singleSubscriber.onSuccess(addValue(7546745, 9769));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).timeout(2, TimeUnit.SECONDS).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Logger.e("TEST_RX onCompleted = %s ");
            }

            @Override
            public void onError(Throwable e) {
                Logger.e("TEST_RX onError = %s ", e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Logger.e("TEST_RX onNext = %s ", integer);
            }
        });
    }

    private void singleZip() {
        Single<Integer> single1 = Single.create(new Single.OnSubscribe<Integer>() {
            @Override
            public void call(SingleSubscriber<? super Integer> singleSubscriber) {
                singleSubscriber.onSuccess(addValue(643, 867));
            }
        });
        Single<Integer> single2 = Single.create(new Single.OnSubscribe<Integer>() {
            @Override
            public void call(SingleSubscriber<? super Integer> singleSubscriber) {
                singleSubscriber.onSuccess(addValue(100, 101));
            }
        });

        Single.zip(single1, single2, new Func2<Integer, Integer, String>() {
            @Override
            public String call(Integer integer, Integer integer2) {
                Logger.e("TEST_RX  integer value = %s,integer2 value = %s  ", integer, integer2);
                return integer + integer2 + "";
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.e("TEST_RX  singleZip value = %s ", s);
            }
        });

    }

    private void asysncSubject() {
        AsyncSubject<Integer> asyncSubject = AsyncSubject.create();
        asyncSubject.onNext(1);
        asyncSubject.onNext(2);
        asyncSubject.onNext(3);
        asyncSubject.onNext(4);
        asyncSubject.onCompleted();
        asyncSubject.timeout(2, TimeUnit.SECONDS);
        asyncSubject.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Logger.e("TEST_RX  asysncSubject onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Logger.e("TEST_RX  asysncSubject onError = %s", e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Logger.e("TEST_RX  asysncSubject onNext value = %s", integer);
            }
        });
    }

    BehaviorSubject behaviorSubject;

    /**
     * Observer会接收到BehaviorSubject被订阅之前的最后一个数据，再接收其他发射过来的数据，如果BehaviorSubject被订阅之前没有发送任何数据，则会发送一个默认数据。
     * （注意跟AsyncSubject的区别，AsyncSubject要手动调用onCompleted()，且它的Observer会接收到onCompleted()前发送的最后一个数据，之后不会再接收数据，而BehaviorSubject不需手动调用onCompleted()，
     * 它的Observer接收的是BehaviorSubject被订阅前发送的最后一个数据，两个的分界点不一样，且之后还会继续接收数据。
     */
    private void behaviorSubject() {
        if (behaviorSubject == null) {
            behaviorSubject = BehaviorSubject.create(-1);
            behaviorSubject.onNext(1);
            behaviorSubject.onNext(2);
            behaviorSubject.onNext(3);
        }
        behaviorSubject.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Logger.e("TEST_RX  behaviorSubject onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Logger.e("TEST_RX  behaviorSubject onError = %s", e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Logger.e("TEST_RX  behaviorSubject onNext value = %s", integer);
            }
        });
        behaviorSubject.onNext(4);
        behaviorSubject.onNext(5);
    }

    /**
     * PublishSubject比较容易理解，相对比其他Subject常用，它的Observer只会接收到PublishSubject被订阅之后发送的数据。
     */
    private void publishSubject(){
        PublishSubject publishSubject = PublishSubject.create();
        publishSubject.onNext(1);
        publishSubject.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Logger.e("TEST_RX  publishSubject onCompleted value = %s" );
            }

            @Override
            public void onError(Throwable e) {
                Logger.e("TEST_RX  publishSubject onError value = %s",e.getMessage() );
            }

            @Override
            public void onNext(Integer integer) {
                Logger.e("TEST_RX  publishSubject onNext value = %s",integer );
            }
        });
        publishSubject.onNext(2);
        publishSubject.onNext(3);
    }
    private void replaySubject(){
        ReplaySubject replaySubject = ReplaySubject.create();
        replaySubject.onNext(1);
        replaySubject.onNext(2);
        replaySubject.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.e("TEST_RX  replaySubject onNext value = %s",integer );
            }
        });
        replaySubject.onNext(3);
    }

    private int addValue(int a, int b) {
        return a + b;
    }

    /**
     * 这样的好处是我们可以直接使用RxJava的线程调度逻辑。并且在合适的时机终止线程
     */
    private void creataNetwork(){
        Scheduler.Worker scheduler = Schedulers.io().createWorker();
        scheduler.schedule(new Action0() {
            @Override
            public void call() {
                Logger.e("TEST_RX  creataNetwork dely time");
            }
        },3,TimeUnit.SECONDS);
        scheduler.unsubscribe();
    }
    int count = 0;
    private Subscription subscription;
    private void createCycleTiming(){
        subscription = Schedulers.computation().createWorker().schedulePeriodically(new Action0() {
            @Override
            public void call() {
                count++;
                Logger.e("TEST_RX  createCycleTiming cycle time =%s",count);
            }
        },3,1,TimeUnit.SECONDS);
    }

    /**
     * 最基本的创建方式：
     */
    private void createObservable(){
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("call 1");
                subscriber.onNext("call 2");
                subscriber.onCompleted();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Logger.e("TEST_RX  createObservable onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Logger.e("TEST_RX  createObservable onError =%s",e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Logger.e("TEST_RX  createObservable onNext value =%s",s);
            }
        });
    }

    /**
     * 使用just( )，将为你创建一个Observable并自动为你调用onNext( )发射数据
     */
    private void observableJust(){
        Observable.just("greg","gwegw1","greg","gwegw1").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.e("TEST_RX  observableJust onNext value =%s",s);
            }
        });
    }

    /**
     * 使用from( )，遍历集合，发送每个item：
     */
    private void observableFrom(){
        String[] strings = new String[]{"greg","gwegw1","greg","gwegw1"};
        Observable.from(strings).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.e("TEST_RX  observableFrom onNext value =%s",s);
            }
        });
    }

    /**
     * 使用interval( ),创建一个按固定时间间隔发射整数序列的Observable，可用作定时器：
     */
    private void observableInterval(){
        Observable.interval(1,TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                Logger.e("TEST_RX  observableInterval onNext value =%s",aLong);
            }
        });
    }

    /**
     * 使用range( ),创建一个发射特定整数序列的Observable，第一个参数为起始值，第二个为发送的个数，如果为0则不发送，负数则抛异常：
     */
    private void observableRange(){
        Observable.range(100,108).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.e("TEST_RX  observableRange onNext value =%s",integer);
            }
        });
    }

    /**
     * 使用timer( ),创建一个Observable，它在一个给定的延迟后发射一个特殊的值，等同于Android中Handler的postDelay( )方法：
     */
    private void observableTime(){
        Observable.timer(3,TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                Logger.e("TEST_RX  observableRange oncall value =%s",aLong);
                Observable.just("ryan, this is a value=%s").subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.e("TEST_RX  observableRange oncall value =%s",s);
                    }
                });
            }
        });
    }

    /**
     * 使用repeat( ),创建一个重复发射特定数据的Observable:
     */
    private void observableRepeat(){
        Observable.just("3214").repeat(2).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.e("TEST_RX  observableRepeat oncall value =%s",s);
            }
        });
    }
}
