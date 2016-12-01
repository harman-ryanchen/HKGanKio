package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 12/1/16.
 */

public class SpiderWebView extends View{

    private int webCount = 6;
    private float angle = (float) (Math.PI*2/webCount);
    private float raduis;
    private int centerX;
    private int centerY;
    private Paint webPaint = new Paint();
    private String[] titles = {"a","b","c","d","e","f"};
    private double[] data = {100,60,60,60,100,50,10,20}; //各维度分值
    private float maxValue = 100;             //数据最大值
    private Paint valuePaint = new Paint();               //数据区画笔
    private Paint textPaint = new Paint();

    public SpiderWebView(Context context) {
        super(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        raduis = Math.min(h,w)/2 * 0.8f;
        centerX = w/2;
        centerY = h/2;
        postInvalidate();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();
        drawPolygon(canvas);
        drawLines(canvas);
        drawRegion(canvas);
        drawText(canvas);
    }

    private void drawLines(Canvas canvas) {
        Path path = new Path();
        for (int i = 0;i<webCount;i++){
            path.reset();
            path.moveTo(centerX,centerY);
            float cx = (float) (centerX+ raduis*Math.cos(angle*i));
            float cy = (float) (centerY+ raduis*Math.sin(angle*i));
            path.lineTo(cx,cy);
            canvas.drawPath(path, webPaint);
        }
    }

    private void initPaint() {
        webPaint.setColor(R.color.blue);
        webPaint.setStyle(Paint.Style.STROKE);
        webPaint.setStrokeWidth(4);
    }

    private void drawPolygon(Canvas canvas) {
        Path path = new Path();
        float r = raduis/(webCount-1);
        for (int i = 1 ; i <webCount ; i++){
            float cur = r * i;
            path.reset();
            for (int x = 0;x < webCount ; x ++){
                if (x == 0){
                    path.moveTo(centerX+cur,centerY);
                }else{
                    //Math 正弦余弦用法 http://blog.csdn.net/getdate/article/details/8011700
                    float cx = (float) (centerX+ cur*Math.cos(angle*x));
                    float cy = (float) (centerY+ cur*Math.sin(angle*x));
                    Logger.d("TEXT_CUSTOM_VIEW angle = %s , cosX = %s , sinY = %s,cx = %s , cy = %s ",angle*x,Math.cos(angle*x),Math.sin(angle*x),cx,cy);
                    path.lineTo(cx,cy);
                }
            }
            path.close();
            canvas.drawPath(path, webPaint);
        }
    }

    public SpiderWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpiderWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 绘制区域
     * @param canvas
     */
    private void drawRegion(Canvas canvas){
        Path path = new Path();
        valuePaint.setAlpha(255);
        for(int i=0;i<webCount;i++){
            double percent = data[i]/maxValue;
            float x = (float) (centerX+raduis*Math.cos(angle*i)*percent);
            float y = (float) (centerY+raduis*Math.sin(angle*i)*percent);
            if(i==0){
                path.moveTo(x, centerY);
            }else{
                path.lineTo(x,y);
            }
            //绘制小圆点
            canvas.drawCircle(x,y,10,valuePaint);
        }
        valuePaint.setStyle(Paint.Style.STROKE);
        valuePaint.setStrokeWidth(10);
        path.close();
        canvas.drawPath(path, valuePaint);
        valuePaint.setAlpha(127);
        //绘制填充区域
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);
    }
    /**
     * 绘制文字
     * @param canvas
     */
    private void drawText(Canvas canvas){
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        textPaint.setTextSize(50f);
        for(int i=0;i<webCount;i++){
            float x = (float) (centerX+(raduis+fontHeight/2)*Math.cos(angle*i));
            float y = (float) (centerY+(raduis+fontHeight/2)*Math.sin(angle*i));
            if(angle*i>=0&&angle*i<=Math.PI/2){//第4象限
                canvas.drawText(titles[i], x,y,textPaint);
            }else if(angle*i>=3*Math.PI/2&&angle*i<=Math.PI*2){//第3象限
                canvas.drawText(titles[i], x,y,textPaint);
            }else if(angle*i>Math.PI/2&&angle*i<=Math.PI){//第2象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x-dis,y,textPaint);
            }else if(angle*i>=Math.PI&&angle*i<3*Math.PI/2){//第1象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x-dis,y,textPaint);
            }
        }
    }
}
