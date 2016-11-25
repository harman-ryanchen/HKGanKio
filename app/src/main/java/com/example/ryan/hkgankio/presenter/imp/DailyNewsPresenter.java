package com.example.ryan.hkgankio.presenter.imp;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.ryan.hkgankio.bean.DailyNewsBean;
import com.example.ryan.hkgankio.bean.StoriesBean;
import com.example.ryan.hkgankio.model.DailyNewModel;
import com.example.ryan.hkgankio.presenter.IDailyNewsPresenter;
import com.example.ryan.hkgankio.view.daily.base.IDailNewsFragment;
import com.orhanobut.logger.Logger;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by studio02 on 4/28/16.
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class DailyNewsPresenter implements IDailyNewsPresenter {
    private Subscription subscription;
    private BehaviorSubject cache;

    private IDailNewsFragment iDailNewsFragment;
    private DailyNewModel newModel;

    public DailyNewsPresenter(IDailNewsFragment iDailNewsFragment) {
        this.iDailNewsFragment = iDailNewsFragment;
        newModel = new DailyNewModel();
    }
    long loadtimeStart;
    @Override
    public void loadLaestNewsData() {
        unsubscribe();
        loadtimeStart = System.currentTimeMillis();
        if (cache == null) {
            Logger.d("TEST_DAILY cache  = %s", "null");
            cache = BehaviorSubject.create();
            Observable.create(new Observable.OnSubscribe<DailyNewsBean>() {
                @Override
                public void call(Subscriber<? super DailyNewsBean> subscriber) {
                    loadFromNetwork();
//                    DailyNewsBean dailyNewsBean = newModel.getDailyNewsBean("DAILYNEWSBEAN");
                    Logger.d("TEST_DAILY data from  = %s", "network");
//                    if (dailyNewsBean == null) {
//                    } else {
//                        Logger.d("TEST_DAILY data from  = %s", "memory");
//                        subscriber.onNext(dailyNewsBean);
//                    }
                }
            }).subscribeOn(Schedulers.io()).subscribe(cache);
        }
        subscription = cache.observeOn(AndroidSchedulers.mainThread()).subscribe(dailyNewsBeanObserver);

    }

    Observer<DailyNewsBean> dailyNewsBeanObserver = new Observer<DailyNewsBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Logger.d("TEST_DAILY status = %s", e.toString());
        }

        @Override
        public void onNext(DailyNewsBean bean) {
            long endtime = System.currentTimeMillis();
            Logger.d("TEST_DAILY date = %s,spend time = %s", bean.getDate(),endtime-loadtimeStart);
            for (StoriesBean s : bean.getStories()) {
                Logger.d("TEST_DAILY story = %s", s.getTitle());
            }
            for (DailyNewsBean.TopStoriesBean t : bean.getTop_stories()) {
                Logger.d("TEST_DAILY TopStoriesBean = %s", t.getTitle());
            }
            iDailNewsFragment.refreshLaestTopStories(bean.getTop_stories());
            iDailNewsFragment.refreshStories(bean.getStories());
        }
    };

    private void loadFromNetwork() {
        newModel.getApiService().getLatestNews().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1<DailyNewsBean>() {
            @Override
            public void call(DailyNewsBean bean) {
//                newModel.storeData(bean, "DAILYNEWSBEAN");
            }
        }).subscribe(new Action1<DailyNewsBean>() {
            @Override
            public void call(DailyNewsBean bean) {
                cache.onNext(bean);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Logger.d("TEST_DAILY error = %s", throwable.getMessage());
            }
        });
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void loadBeforeNewsData() {
//        laestDate--;
//        apiService.getBeforeNews(laestDate).enqueue(new Callback<DailyNewsBean>() {
//            @Override
//            public void onResponse(Call<DailyNewsBean> call, Response<DailyNewsBean> response) {
//                laestDate = Long.valueOf(response.body().getDate());
//                storiesBeanArrayMap.put(Long.valueOf(response.body().getDate()),response.body().getStories());
//                iDailNewsFragment.refreshStories(response.body().getStories());
//            }
//
//            @Override
//            public void onFailure(Call<DailyNewsBean> call, Throwable t) {
//                iDailNewsFragment.loadError(t.getMessage());
//            }
//        });
    }
}
