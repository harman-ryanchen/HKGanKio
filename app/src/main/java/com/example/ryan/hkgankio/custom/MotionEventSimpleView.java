package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;

import java.util.Arrays;

/**
 * Created by studio02 on 12/7/16.
 */

public class MotionEventSimpleView extends View {
    private Paint mPaint;
    private Path path_gesture;
    private float[] prePos, curPos;
    private PathMeasure mPathMeasure;

    public MotionEventSimpleView(Context context) {
        super(context);
        initAll();
    }

    public MotionEventSimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAll();
    }

    public MotionEventSimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAll();
    }

    private void initAll() {
        initPaint();
        initPath();
        curPos = new float[2];
        prePos = new float[2];
    }

    private void initPath() {
        path_gesture = new Path();
        mPathMeasure = new PathMeasure();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(R.color.blue);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLineDependGesture(canvas);
    }

    /**
     * draw the line according the gesture by user
     * @param canvas
     */
    private void drawLineDependGesture(Canvas canvas) {
        path_gesture.lineTo(curPos[0],curPos[1]);

        Path path = new Path();
        mPathMeasure.setPath(path_gesture,false);
        int startD = (int) mPathMeasure.getLength();
        int stopD = (int) (mPathMeasure.getLength() - 300);
        mPathMeasure.getSegment(stopD,startD,path,true);
//        Logger.d("TEST_CUSTOM_VIEW path length = %s current pos = %s ",startD,Arrays.toString(curPos));
        canvas.drawPath(path,mPaint);

    }
    private int mActivePointerId = -1;
    int pointerIndex = -1;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                prePos[0] = event.getX();
                prePos[1] = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                prePos = curPos;
                curPos[0] = event.getX();
                curPos[1] = event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;

    }

}
