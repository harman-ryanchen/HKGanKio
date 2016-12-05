package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;


/**
 * Created by studio02 on 11/24/16.
 * <p>
 * Path之完结篇
 */

public class SimpleView5 extends View {
    private Paint mPaint = new Paint();

    public SimpleView5(Context context) {
        super(context);
    }

    public SimpleView5(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


    public SimpleView5(Context context, AttributeSet attrs, int defStyleAttr) {
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
        mPaint.setStyle(Paint.Style.FILL);                   // 设置画布模式为填充

        canvas.translate(getWidth() / 2, getHeight() / 2);          // 移动画布(坐标系)


//        normalFillRule(canvas);
//        normalFillRule2(canvas);
        taiJiView(canvas);
    }

    /**
     * 画一个太极图案
     * @param canvas
     */
    private void taiJiView(Canvas canvas) {
        Path path1 = new Path();
        Path path2 = new Path();
        Path path3 = new Path();
        Path path4 = new Path();
        Path path5 = new Path();
        Path path6 = new Path();

        path1.addCircle(0,0,200,Path.Direction.CW);
        path2.addRect(0,-200,200,200,Path.Direction.CW);

        path3.addCircle(0,-100,100, Path.Direction.CW);

        path4.addCircle(0,100,100, Path.Direction.CCW);

        path5.addCircle(0,-100,30, Path.Direction.CCW);

        path1.op(path2,Path.Op.DIFFERENCE);
        path1.op(path3,Path.Op.UNION);
        path1.op(path4,Path.Op.DIFFERENCE);
        path1.op(path5,Path.Op.DIFFERENCE);




        canvas.drawPath(path1,mPaint);

        path6.setFillType(Path.FillType.EVEN_ODD);                   // 设置Path填充模式为 奇偶规则

        path6.addCircle(0,100,30, Path.Direction.CCW);
        canvas.drawPath(path6,mPaint);

    }

    /**
     * 非零奇偶环绕数规则填充结果
     * @param canvas
     */
    private void normalFillRule2(Canvas canvas) {
        Path path = new Path();
        path.addRect(-200,-200,200,200,Path.Direction.CW);
        path.addRect(-100,-100,100,100,Path.Direction.CCW);

        path.setFillType(Path.FillType.WINDING);
//        path.setFillType(Path.FillType.INVERSE_WINDING);

        canvas.drawPath(path,mPaint);
    }

    /**
     *  奇偶规则和反奇偶规则
     * @param canvas
     */
    private void normalFillRule(Canvas canvas) {
        Path path = new Path();                                     // 创建Path

path.setFillType(Path.FillType.EVEN_ODD);                   // 设置Path填充模式为 奇偶规则
//        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);            // 反奇偶规则

        path.addRect(-200, -200, 200, 200, Path.Direction.CW);         // 给Path中添加一个矩形
        canvas.drawPath(path,mPaint);
    }

}
