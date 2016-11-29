package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;


/**
 * Created by studio02 on 11/24/16.
 */

public class SimpleView2 extends View {
    private Paint mPaint = new Paint();

    public SimpleView2(Context context) {
        super(context);
    }

    public SimpleView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleView2(Context context, AttributeSet attrs, int defStyleAttr) {
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
//        scaleCanva(canvas);
//          rotateCanva(canvas);
            shewCanva(canvas);
    }

    private void shewCanva(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(getWidth() / 2, getHeight() / 2);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2f);
        RectF rect = new RectF(0,0,400,400);   // 矩形区域

        mPaint.setColor(R.color.gray);           // 绘制黑色矩形
        canvas.drawRect(rect,mPaint);

//        canvas.skew(1,0);                       // 水平错切 <- 45度
//        canvas.skew(0.5f,0);                       // 水平错切 <- 45度
        canvas.skew(0,-0.5f);                       // 水平错切 <- 45度

        mPaint.setColor(R.color.blue);            // 绘制蓝色矩形
        canvas.drawRect(rect,mPaint);
    }

    private void rotateCanva(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(getWidth() / 2, getHeight() / 2);

//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        mPaint.setColor(R.color.gray);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
////        canvas.rotate(180);                     // 旋转180度 <-- 默认旋转中心为原点
//        canvas.rotate(180,200,50);               // 旋转180度 <-- 旋转中心向右偏移200个单位
//
//        mPaint.setColor(R.color.blue);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);
        mPaint.setColor(R.color.blue);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2f);
        canvas.drawCircle(0,0,400,mPaint);          // 绘制两个圆形
        canvas.drawCircle(0,0,300,mPaint);
        mPaint.setColor(R.color.red);
        for (int i=0; i<=360; i+=10){               // 绘制圆形之间的连接线
            canvas.drawLine(0,300,0,400,mPaint);
            canvas.rotate(10);
        }
    }

    private void scaleCanva(Canvas canvas) {
        mPaint.setColor(R.color.red);
        canvas.translate(300,300);
        canvas.drawCircle(0,0,200,mPaint);

        mPaint.setColor(R.color.blue);
        canvas.translate(200,0);
        canvas.drawCircle(0,0,200,mPaint);


        canvas.translate(-500,-300);
        // 将坐标系原点移动到画布正中心
        canvas.translate(getWidth() / 2, getHeight() / 2);

        RectF rect = new RectF(-400,-400,400,400);   // 矩形区域

//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形

        for (int i=0; i<=20; i++)
        {
            canvas.scale(0.9f,0.9f);
            canvas.drawRect(rect,mPaint);
        }
//        canvas.scale(-0.5f,-0.5f,200,0);                // 画布缩放
//        canvas.drawRect(rect,mPaint);


    }
}
