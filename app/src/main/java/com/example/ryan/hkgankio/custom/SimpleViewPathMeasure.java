package com.example.ryan.hkgankio.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;

import static com.orhanobut.logger.Logger.init;


/**
 * Created by studio02 on 11/24/16.
 * <p>
 * Path之完结篇
 */

public class SimpleViewPathMeasure extends View {
    private Paint mPaint = new Paint();
    private Paint segmentP = new Paint();

    private float currentValue = 0;     // 用于纪录当前的位置,取值范围[0,1]映射Path的整个长度

    private float[] pos;                // 当前点的实际位置
    private float[] tan;                // 当前点的tangent值,用于计算图片所需旋转的角度
    private Bitmap mBitmap;             // 箭头图片
    private Matrix mMatrix;             // 矩阵,用于对图片进行一些操作

    public SimpleViewPathMeasure(Context context) {
        super(context);
        initData();
        initPaint();
    }

    public SimpleViewPathMeasure(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData();
        initPaint();
    }


    public SimpleViewPathMeasure(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
        initPaint();
    }

    private void initData() {
        pos = new float[2];
        tan = new float[2];
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;       // 缩放图片
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.arrow, options);
        mMatrix = new Matrix();

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

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(R.color.gray);

        segmentP.setStyle(Paint.Style.STROKE);
        segmentP.setStrokeWidth(10);
        segmentP.setColor(R.color.blue);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
                      // 设置画布模式为填充

        canvas.translate(getWidth() / 2, getHeight() / 2);          // 移动画布(坐标系)

//        basicPathMesure(canvas);
//        pathMeasureSegment(canvas);
//        pathMeasureContour(canvas);
//        pathMeasurePosTan(canvas);
        pathMeasureMatrix(canvas);
    }

    /**
     * 1.对 matrix 的操作必须要在 getMatrix 之后进行，否则会被 getMatrix 重置而导致无效。
     2.矩阵对旋转角度默认为图片的左上角，我们此处需要使用 preTranslate 调整为图片中心。
     3.pre(矩阵前乘) 与 post(矩阵后乘) 的区别，此处请等待后续的文章或者自行搜索。
     * @param canvas
     */
    private void pathMeasureMatrix(Canvas canvas) {
        Path path = new Path();                                 // 创建 Path

        path.addCircle(0, 0, 200, Path.Direction.CW);           // 添加一个圆形

        PathMeasure measure = new PathMeasure(path, false);     // 创建 PathMeasure

        currentValue += 0.005;                                  // 计算当前的位置在总长度上的比例[0,1]
        if (currentValue >= 1) {
            currentValue = 0;
        }

        measure.getPosTan(measure.getLength() * currentValue, pos, tan);        // 获取当前位置的坐标以及趋势
        measure.getMatrix(measure.getLength()*currentValue,mMatrix,PathMeasure.TANGENT_MATRIX_FLAG | PathMeasure.POSITION_MATRIX_FLAG);

        mMatrix.preTranslate(-mBitmap.getWidth() / 2, -mBitmap.getHeight() / 2);   // <-- 将图片绘制中心调整到与当前点重合(注意:此处是前乘pre)

        canvas.drawPath(path, mPaint);                                   // 绘制 Path
        canvas.drawBitmap(mBitmap, mMatrix, mPaint);                     // 绘制箭头

        invalidate();                                                           // 重绘页面
    }

    /**
     * measure pos tan for path
     * @param canvas
     */
    private void pathMeasurePosTan(Canvas canvas) {

        Path path = new Path();                                 // 创建 Path

        path.addCircle(0, 0, 200, Path.Direction.CW);           // 添加一个圆形

        PathMeasure measure = new PathMeasure(path, false);     // 创建 PathMeasure

        currentValue += 0.005;                                  // 计算当前的位置在总长度上的比例[0,1]
        if (currentValue >= 1) {
            currentValue = 0;
        }

        measure.getPosTan(measure.getLength() * currentValue, pos, tan);        // 获取当前位置的坐标以及趋势
        // 获取当前位置的坐标以及趋势的矩阵
        Logger.d("TEST_CUSTOM_VIEW tan1 = %s , tan2 = %s ",tan[1],tan[0]);
//        mMatrix.reset();                                                        // 重置Matrix
        float degrees = (float) (Math.atan2(tan[1], tan[0]) * 180.0 / Math.PI); // 计算图片旋转角度

        Logger.d("TEST_CUSTOM_VIEW degress = %s tan1 = %s , tan2 = %s ",degrees,tan[1],tan[0]);

        mMatrix.postRotate(degrees, mBitmap.getWidth() / 2, mBitmap.getHeight() / 2);   // 旋转图片
        mMatrix.postTranslate(pos[0] - mBitmap.getWidth() / 2, pos[1] - mBitmap.getHeight() / 2);   // 将图片绘制中心调整到与当前点重合

        canvas.drawPath(path, mPaint);                                   // 绘制 Path
        canvas.drawBitmap(mBitmap, mMatrix, mPaint);                     // 绘制箭头

        invalidate();
    }

    /**
     *  measure multiply paths in a path
     * @param canvas
     */
    private void pathMeasureContour(Canvas canvas) {
        Path path = new Path();

        path.addRect(-300,-300,300,300, Path.Direction.CW);

        path.addRect(-150,-150,150,150, Path.Direction.CW);

        PathMeasure pathMeasure = new PathMeasure(path,false);

        Logger.d("TEST_CUSTOM_VIEW current path lenght = %s",pathMeasure.getLength());
        pathMeasure.nextContour();

        Logger.d("TEST_CUSTOM_VIEW current path lenght = %s",pathMeasure.getLength());

        canvas.drawPath(path,mPaint);
    }

    /**
     * segment the measure path of view
     * @param canvas
     */
    private void pathMeasureSegment(Canvas canvas) {
        Path path = new Path();

        path.addRect(-300,-300,300,300, Path.Direction.CW);

        canvas.drawPath(path,mPaint);
        PathMeasure pathMeasure = new PathMeasure(path,true);
        Path dsc =  new Path();

        pathMeasure.getSegment(300,1500,dsc,true);

        canvas.drawPath(dsc,segmentP);



    }

    /**
     * the basic path measure about the path whether closed
     * @param canvas
     */
    private void basicPathMesure(Canvas canvas) {
        Path path = new Path();

        path.lineTo(0,200);
        path.lineTo(200,200);
        path.lineTo(200,0);
        PathMeasure pathMeasure1 = new PathMeasure(path,true);

        Logger.d("TEST_CUSTOM_VIEW forceclose =%s ,lenght = %s ",pathMeasure1.isClosed(),pathMeasure1.getLength());

        canvas.drawPath(path,mPaint);

    }

}
