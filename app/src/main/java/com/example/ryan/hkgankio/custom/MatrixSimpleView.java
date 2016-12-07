package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

import com.example.ryan.hkgankio.R;

/**
 * Created by studio02 on 12/6/16.
 */

public class MatrixSimpleView extends View {
    private Bitmap mBitmap;             // 要绘制的图片
    private Matrix mPolyMatrix;         // 测试setPolyToPoly用的Matrix

    public MatrixSimpleView(Context context) {
        super(context);
        initBitmapAndMatrix();
    }

    public MatrixSimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBitmapAndMatrix();
    }

    public MatrixSimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initBitmapAndMatrix() {
        mBitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_test_4);

        mPolyMatrix = new Matrix();


        float[] src = {0, 0,                                    // 左上
                mBitmap.getWidth(), 0,                          // 右上
                mBitmap.getWidth(), mBitmap.getHeight(),        // 右下
                0, mBitmap.getHeight()};                        // 左下

        float[] dst = {0, 0,                                    // 左上
                mBitmap.getWidth(), 400,                        // 右上
                mBitmap.getWidth(), mBitmap.getHeight() + 200,  // 右下
                0, mBitmap.getHeight()};                        // 左下

        // 核心要点
        mPolyMatrix.setPolyToPoly(src, 0, dst, 0, src.length >> 1); // src.length >> 1 为位移运算 相当于处以2

        // 此处为了更好的显示对图片进行了等比缩放和平移(图片本身有点大)
        mPolyMatrix.postScale(0.26f, 0.26f);
        mPolyMatrix.postTranslate(0,200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 根据Matrix绘制一个变换后的图片
        canvas.drawBitmap(mBitmap, mPolyMatrix, null);
    }
}
