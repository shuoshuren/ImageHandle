package com.example.xiao.imagehandle.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.xiao.imagehandle.R;

/**
 * 镜面倒影
 * Created by xiao on 2017/3/2.
 */

public class ReflectView extends View {
    private Bitmap mSrcBitmap;
    private Bitmap mReflectBitmap;
    private Paint mPaint;

    public ReflectView(Context context) {
        this(context, null);
    }

    public ReflectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ReflectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test4);
        Matrix matrix = new Matrix();
        matrix.setScale(1, -1); // x轴对称
        mReflectBitmap = Bitmap.createBitmap(mSrcBitmap, 0, 0, mSrcBitmap.getWidth(), mSrcBitmap.getHeight(), matrix, true);
        mPaint.setShader(new LinearGradient(0,mSrcBitmap.getHeight(),0,mSrcBitmap.getHeight()*1.4f,
                0xDD000000,0x10000000, Shader.TileMode.CLAMP));
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(mSrcBitmap, 0, 0, null);
        canvas.drawBitmap(mReflectBitmap, 0, mSrcBitmap.getHeight(), null);
        canvas.drawRect(0,mSrcBitmap.getHeight(),mSrcBitmap.getWidth(),mSrcBitmap.getHeight()*2,mPaint);
    }
}
