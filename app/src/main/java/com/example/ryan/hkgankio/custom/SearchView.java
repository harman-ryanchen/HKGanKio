package com.example.ryan.hkgankio.custom;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;


/**
 * Created by studio02 on 11/24/16.
 */

public class SearchView extends View {
    private Paint mPaint = new Paint();
    private int viewWidth, viewHeight;
    private int defaultDuring = 2000;
    private float animatorValue = 0;
    private ValueAnimator searchAnimator;
    private ValueAnimator startAnimator;
    private ValueAnimator endAnimator;
    private ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
    private ValueAnimator.AnimatorListener mAnimatorListener;
    Path path_search;
    Path path_circle;
    private PathMeasure mPathMeasure;
    private SearchState currentState = SearchState.NONE;

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAll();

    }

    private enum SearchState {
        NONE,
        STARING,
        SEARCHING,
        END;
    }

    private void initAll() {
        initPaint();
        initPath();
        initListner();
        initValueAnimation();

        currentState = SearchState.STARING;
        startAnimator.start();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (currentState) {
                case NONE:
                    currentState = SearchState.STARING;
                    startAnimator.start();
                    break;
                case STARING:
                    currentState = SearchState.SEARCHING;
                    searchAnimator.start();
                    break;
                case SEARCHING:
                    currentState = SearchState.END;
                    endAnimator.start();
                    break;
                case END:
                    currentState = SearchState.NONE;
                    handler.sendEmptyMessageDelayed(0,2000);
                    break;

            }
        }
    };

    private void initListner() {
        animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animatorValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        };
        mAnimatorListener = new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        };
    }

    private void initValueAnimation() {
        searchAnimator = ValueAnimator.ofFloat(0, 1).setDuration(defaultDuring);
        startAnimator = ValueAnimator.ofFloat(0, 1).setDuration(defaultDuring);
        endAnimator = ValueAnimator.ofFloat(1, 0).setDuration(defaultDuring);

        searchAnimator.addListener(mAnimatorListener);
        startAnimator.addListener(mAnimatorListener);
        endAnimator.addListener(mAnimatorListener);


        searchAnimator.addUpdateListener(animatorUpdateListener);
        startAnimator.addUpdateListener(animatorUpdateListener);
        endAnimator.addUpdateListener(animatorUpdateListener);
    }


    private void initPath() {
        path_search = new Path();
        path_circle = new Path();

        mPathMeasure = new PathMeasure();
        RectF searchRect = new RectF(-50, -50, 50, 50);
        path_search.addArc(searchRect, 45, 359.9f);

        RectF circleRect = new RectF(-100, -100, 100, 100);
        path_circle.addArc(circleRect, 45, -359.9f);


        float pos[] = new float[2];
        mPathMeasure.setPath(path_circle, false);
        mPathMeasure.getPosTan(0, pos, null);

        path_search.lineTo(pos[0], pos[1]);

        Logger.d("TEST_CUSTOM_VIEW pos[0] = %s , pos[1] = %s", pos[0], pos[1]);
    }

    private void initPaint() {
        mPaint.setColor(R.color.white);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    /**
     * measure size of the view
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);      //取出宽度的确切数值
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);      //取出宽度的测量模式

        int heightsize = MeasureSpec.getSize(heightMeasureSpec);    //取出高度的确切数值
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);    //取出高度的测量模式

        Logger.d("TEST_Custom_View widthsize = %s , widthmode = %s , heightsize = %s , heightmode = %s", widthsize, widthmode, heightsize, heightmode);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * if you want change or confirm the view`s with and height
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //confirm the view`s  with and height
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSearchView(canvas);
    }

    private void drawSearchView(Canvas canvas) {


        canvas.drawColor(Color.parseColor("#0082D7"));

        canvas.translate(viewWidth / 2, viewHeight / 2);

        switch (currentState) {
            case NONE:
                canvas.drawPath(path_search, mPaint);
                break;
            case STARING:
                mPathMeasure.setPath(path_search, false);
                Path dst = new Path();
                mPathMeasure.getSegment(mPathMeasure.getLength() * animatorValue, mPathMeasure.getLength(), dst, true);
                canvas.drawPath(dst, mPaint);
                break;
            case SEARCHING:
                mPathMeasure.setPath(path_circle, false);
                Path dct = new Path();
                float stop = mPathMeasure.getLength() * animatorValue;
                float start = (float) (stop - ((0.5 - Math.abs(animatorValue - 0.5)) * 200f));
                Logger.d("TEST_CUSTOM_VIEW stop = %s , start = %s",stop,start);
                mPathMeasure.getSegment(start, stop, dct, true);
                canvas.drawPath(dct, mPaint);
                break;
            case END:
                mPathMeasure.setPath(path_search, false);
                Path dst1 = new Path();
                mPathMeasure.getSegment(mPathMeasure.getLength() * animatorValue, mPathMeasure.getLength(), dst1, true);
                canvas.drawPath(dst1, mPaint);
                break;
        }
    }

}
