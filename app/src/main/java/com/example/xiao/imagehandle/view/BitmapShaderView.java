package com.example.xiao.imagehandle.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.xiao.imagehandle.R;

/**
 * Created by xiao on 2017/3/2.
 */

public class BitmapShaderView extends View {

    private Bitmap mBitmap;
    private Paint mPaint;
    private BitmapShader mBitmapShader;


    public BitmapShaderView(Context context) {
        this(context,null);
    }

    public BitmapShaderView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BitmapShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test4);
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(mBitmapShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(200,150,150,mPaint);
    }
}
