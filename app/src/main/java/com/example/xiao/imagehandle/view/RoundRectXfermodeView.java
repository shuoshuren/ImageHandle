package com.example.xiao.imagehandle.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.xiao.imagehandle.R;

/**
 * Created by xiao on 2017/3/2.
 */

public class RoundRectXfermodeView extends View {
    private Bitmap mBitmap;
    private Bitmap mOutBitmap;
    private Paint mPaint;

    public RoundRectXfermodeView(Context context) {
        this(context,null);
    }

    public RoundRectXfermodeView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RoundRectXfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    private void initView() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);//禁用硬件加速
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test3);
        mOutBitmap = Bitmap.createBitmap(mBitmap.getWidth(),
                mBitmap.getHeight(),Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(mOutBitmap);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawRoundRect(0,0,mBitmap.getWidth(),mBitmap.getHeight(),50,50,mPaint); //先绘制的是Dst

        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(mBitmap,0,0,mPaint);//Src
        mPaint.setXfermode(null);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mOutBitmap,0,0,null);
    }
}
