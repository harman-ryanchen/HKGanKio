package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;


/**
 * Created by studio02 on 11/24/16.
 *
 * 这次我们了解的Picture和上文中的录像功能是类似的，只不过我们Picture录的是Canvas中绘制的内容。

 我们把Canvas绘制点，线，矩形等诸多操作用Picture录制下来，下次需要的时候拿来就能用，使用Picture相比于再次调用绘图API，开销是比较小的，也就是说对于重复的操作可以更加省时省力。
 */

public class SimpleView4 extends View {
    private Paint mPaint = new Paint();

    public SimpleView4(Context context) {
        super(context);
    }

    public SimpleView4(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


    public SimpleView4(Context context, AttributeSet attrs, int defStyleAttr) {
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
        initPaint();
//        drawLineTo(canvas);
//        pathDirection(canvas);
        doublePath(canvas);
//            drawArc(canvas);
//            someFunction(canvas);
    }

    /**
     * some simple methods
     * @param canvas
     */
    private void someFunction(Canvas canvas) {
        Path path = new Path();
        path.lineTo(0,400);
        path.lineTo(400,400);
        path.lineTo(400,0);
        path.lineTo(0,0);

        RectF rect = new RectF();
        boolean b = path.isRect(rect);
        Logger.d("Rect","isRect:"+b+"| left:"+rect.left+"| top:"+rect.top+"| right:"+rect.right+"| bottom:"+rect.bottom);
    }

    /**
     * use path draw a Arc
     * @param canvas
     */
    private void drawArc(Canvas canvas) {
        canvas.translate(getWidth()/2,getHeight()/2);

        Path path = new Path();
        path.lineTo(100,100);
        RectF rectF = new RectF(0,0,400,400);

//        path.addArc(rectF,0,180);
        path.arcTo(rectF,0,180);
        canvas.drawPath(path,mPaint);
    }

    /**
     *  two path being together
     * @param canvas
     */
    private void doublePath(Canvas canvas) {
        canvas.translate(getWidth()/2,getHeight()/2);
        canvas.translate(0,-400);

        // draw a triangle
        Path path = new Path();
        path.lineTo(400,400);
        path.lineTo(-400,400);
        path.close();

        Path src = new Path();
        src.addCircle(0,0,100,Path.Direction.CW);
//        path.addPath(src,0,200);
//        src中存在内容时，dst中原有的内容会被清空，而存放平移后的path。
        path.offset(0,200,src);

        canvas.drawPath(path,mPaint);

        mPaint.setColor(R.color.blue);
        canvas.drawPath(src,mPaint);
    }

    /**
     * draw a parttern use direction
     * @param canvas
     */
    private void pathDirection(Canvas canvas) {
        canvas.translate(getWidth()/2,getHeight()/2);

        Path path = new Path();
        path.addRect(-300,-300,300,300,Path.Direction.CCW);
        path.setLastPoint(100,-100);
        canvas.drawPath(path,mPaint);
    }

    /**
     * simple path line to function
     * @param canvas
     */
    private void drawLineTo(Canvas canvas) {
        canvas.translate(getWidth()/2,getHeight()/2);
        Path path = new Path();
        path.lineTo(200,200);
        path.setLastPoint(200,100);
        path.lineTo(200,0);
        path.close();
        canvas.drawPath(path,mPaint);
    }

    private void initPaint() {
        mPaint.setColor(R.color.black);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }
}
