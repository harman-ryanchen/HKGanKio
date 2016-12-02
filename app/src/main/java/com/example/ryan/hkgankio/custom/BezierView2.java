package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 12/2/16.
 */

public class BezierView2 extends View{

    private PointF start,end, control1,control2;
    private int centerX,centerY;
    private Paint mPaint = new Paint();
    private boolean mode = false;
    public BezierView2(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setTextSize(60);

        start = new PointF(0,0);
        end = new PointF(0,0);
        control1 = new PointF(0,0);
        control2 = new PointF(0,0);

    }

    public BezierView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public BezierView2(Context context, AttributeSet attrs, int defStyleAttr) {
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

        control1.x = centerX;
        control1.y = centerY - 200;

        control2.x = centerX;
        control2.y = centerY - 200;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //判断手指落下时近哪个控制点
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                PointF downPoint = new PointF();
                downPoint.x = event.getX();
                downPoint.y = event.getY();
                float distanceToC1 = distance(downPoint,control1);
                float distanceToC2 = distance(downPoint,control2);
                mode = distanceToC1 > distanceToC2 ? true : false;
                Logger.d("TEST_CUSTOM_VIEW distanceToC1 = %s , distanceToC2 = %s mode = %s", distanceToC1,distanceToC2,mode);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
//                mode = false;
                break;
        }

        if (mode){
            control2.x = event.getX();
            control2.y = event.getY();
        }else{
            control1.x = event.getX();
            control1.y = event.getY();
        }
        invalidate();
        return true;
    }

    // 计算两个触摸点之间的距离
    private float distance(PointF point1, PointF point2) {
        float x = point1.x - point2.x;
        float y = point1.y - point2.y;
        //Android5.0使用 FloatMath已过时，直接使用Math
        return (float)Math.sqrt(x * x + y * y);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //绘制数据点和控制点的小圆点
        mPaint.setColor(R.color.black);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(start.x,start.y,mPaint);
        canvas.drawPoint(end.x,end.y,mPaint);
        canvas.drawPoint(control1.x, control1.y,mPaint);
        canvas.drawPoint(control2.x, control2.y,mPaint);

        //绘制辅助线
        mPaint.setColor(R.color.gray);
        mPaint.setStrokeWidth(5);
        canvas.drawLine(start.x,start.y, control1.x, control1.y,mPaint);
        canvas.drawLine(control1.x,control1.y, control2.x, control2.y,mPaint);
        canvas.drawLine(control2.x,control2.y, end.x, end.y,mPaint);

        //绘制贝塞尔曲线

        mPaint.setColor(R.color.red);
        mPaint.setStrokeWidth(8);
        Path path = new Path();
        path.moveTo(start.x,start.y);
        path.cubicTo(control1.x, control1.y, control2.x,control2.y, end.x, end.y);

        canvas.drawPath(path,mPaint);
    }
}
