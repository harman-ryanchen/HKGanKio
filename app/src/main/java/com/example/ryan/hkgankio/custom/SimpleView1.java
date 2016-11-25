package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;


/**
 * Created by studio02 on 11/24/16.
 */

public class SimpleView1 extends View {
    private Paint paint = new Paint();

    public SimpleView1(Context context) {
        super(context);
    }

    public SimpleView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
//        setMeasuredDimension(w,h);
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSomethings(canvas);
    }

    private void drawSomethings(Canvas canvas) {
        //init paint
        paint.setColor(R.color.red);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(30f);

        canvas.drawPoint(500, 500, paint);
        canvas.drawPoints(new float[]{700, 600, 700, 700, 700, 800}, paint);


        canvas.drawLine(300, 300, 500, 600, paint);    // 在坐标(300,300)(500,600)之间绘制一条直线
        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
                100, 200, 200, 200,
                100, 300, 200, 300
        }, paint);

        paint.setStrokeWidth(20f);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(R.color.gray);
        RectF rectF = new RectF(100, 500, 800, 900);
        canvas.drawRect(rectF, paint);
        // 绘制圆弧
        paint.setColor(Color.BLUE);
        canvas.drawArc(rectF,270,90,true,paint);


        paint.setStrokeWidth(70f);
        RectF rectrf = new RectF(100, 1000, 800, 1400);
        canvas.drawRoundRect(rectrf, 30, 30, paint);


        paint.setStrokeWidth(10f);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(R.color.black);
        RectF recttr = new RectF(100, 1500, 1000, 2000);
        canvas.drawOval(recttr, paint);


        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(R.color.red);
        canvas.drawCircle(1200, 500, 100, paint);


    }
}
