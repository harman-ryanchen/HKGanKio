package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.ryan.hkgankio.R;

/**
 * Created by studio02 on 12/2/16.
 */

public class BezierView1 extends View{

    private PointF start,end,control;
    private int centerX,centerY;
    private Paint mPaint = new Paint();
    public BezierView1(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setTextSize(60);

        start = new PointF(0,0);
        end = new PointF(0,0);
        control = new PointF(0,0);

    }

    public BezierView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public BezierView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w/2;
        centerY = h/2;

        start.x = centerX - 200;
        start.y = centerY;

        end.x = centerX + 200;
        end.y = centerY;

        control.x = centerX;
        control.y = centerY - 200;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        control.x = event.getX();
        control.y = event.getY();
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制数据点和控制点的小圆点
        mPaint.setColor(R.color.black);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(start.x,start.y,mPaint);
        canvas.drawPoint(end.x,end.y,mPaint);
        canvas.drawPoint(control.x,control.y,mPaint);

        //绘制辅助线
        mPaint.setColor(R.color.gray);
        mPaint.setStrokeWidth(5);
        canvas.drawLine(start.x,start.y,control.x,control.y,mPaint);
        canvas.drawLine(end.x,end.y,control.x,control.y,mPaint);

        //绘制贝塞尔曲线

        mPaint.setColor(R.color.red);
        mPaint.setStrokeWidth(8);
        Path path = new Path();
        path.moveTo(start.x,start.y);
        path.quadTo(control.x,control.y,end.x,end.y);

        canvas.drawPath(path,mPaint);
    }
}
