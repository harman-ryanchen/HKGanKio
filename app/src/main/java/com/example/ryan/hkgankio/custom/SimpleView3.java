package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
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

public class SimpleView3 extends View {
    private Paint mPaint = new Paint();
    private Picture mPicture = new Picture();

    public SimpleView3(Context context) {
        super(context);
    }

    public SimpleView3(Context context, AttributeSet attrs) {
        super(context, attrs);

        recording();
    }

    private void recording() {
        Canvas canvas  = mPicture.beginRecording(500,500);

        mPaint.setColor(R.color.red);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        canvas.translate(250,250);
        canvas.drawCircle(0,0,100,mPaint);

        mPicture.endRecording();
    }

    public SimpleView3(Context context, AttributeSet attrs, int defStyleAttr) {
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
//        canvaDrawPicture(canvas);
//          pictureDrawable(canvas);
//            decodeDrawable(canvas);
            decodeDrawableCutAndScale(canvas);

    }

    /**
     * cut a picture and scale
     * @param canvas
     */
    private void decodeDrawableCutAndScale(Canvas canvas) {
//        canvas.translate(0,getHeight()/2);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_test_3);
        Rect src = new Rect(bitmap.getWidth()/2,0,bitmap.getWidth(),bitmap.getHeight());
        Rect dst = new Rect(200,0,800,1500);
        canvas.drawBitmap(bitmap,src,dst,null);
    }

    /**
     * decode the drawable from different way y
     * @param canvas
     */
    private void decodeDrawable(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_test_2);
        Logger.d("TEST_CUSTOM_VIEW view height = %s , bitmap height = %s ",getHeight(),bitmap.getHeight());
        canvas.drawBitmap(bitmap,0,(getHeight()/2) - (bitmap.getHeight()/2),mPaint); // settle vertical center
//        canvas.drawBitmap(bitmap,new Matrix(),mPaint);
    }

    /**
     * use PictureDrawable can settle the bounds for drawing canvas.
     * @param canvas
     */
    private void pictureDrawable(Canvas canvas) {
        PictureDrawable pictureDrawable = new PictureDrawable(mPicture);

        pictureDrawable.setBounds(0,0,250,mPicture.getHeight());

        pictureDrawable.draw(canvas);
    }

    /**
     * use drawpicture of canvas will better.
     * @param canvas
     */
    private void canvaDrawPicture(Canvas canvas) {
        canvas.drawPicture(mPicture,new RectF(0,0,mPicture.getWidth(),100));
    }
}
