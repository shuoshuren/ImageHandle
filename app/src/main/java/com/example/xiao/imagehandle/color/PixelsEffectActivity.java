package com.example.xiao.imagehandle.color;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.example.xiao.imagehandle.R;
import com.example.xiao.imagehandle.utils.ImageHelper;

/**
 * 通过像素点改变图片的显示效果：底片效果，怀旧效果，浮雕效果
 */
public class PixelsEffectActivity extends AppCompatActivity {

    private ImageView mImageView1,mImageView2,mImageView3,mImageView4;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixels_effect);

        setTitle("像素处理");

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test2);
        Log.i("xc","bitmap:"+bitmap.hashCode());

        mImageView1 = (ImageView) findViewById(R.id.image1);
        mImageView2 = (ImageView) findViewById(R.id.image2);
        mImageView3 = (ImageView) findViewById(R.id.image3);
        mImageView4 = (ImageView) findViewById(R.id.image4);

        mImageView1.setImageBitmap(bitmap);
        mImageView2.setImageBitmap(ImageHelper.handleImageNegative(bitmap));
        mImageView3.setImageBitmap(ImageHelper.handleImagePixelsOldPhoto(bitmap));
        mImageView4.setImageBitmap(ImageHelper.handleImagePixelsRelief(bitmap));
    }
}
