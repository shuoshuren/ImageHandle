package com.example.xiao.imagehandle.color;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.xiao.imagehandle.R;
import com.example.xiao.imagehandle.utils.ImageHelper;

/**
 * 改变图片的色相，饱和度，亮度
 */
public class PrimaryColorActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView mImageView;
    private SeekBar mHueSeekBar;
    private SeekBar mSaturationSeekBar;
    private SeekBar mLumSeekBar;

    private static final int MAX_VALUE = 255;
    private static final int MID_VALUE = 127;

    private float mHue, mSaturation, mLum;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_color);
        setTitle("基色");

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test3);

        mImageView = (ImageView) findViewById(R.id.imageview);
        mHueSeekBar = (SeekBar) findViewById(R.id.hue_seekbar);
        mSaturationSeekBar = (SeekBar) findViewById(R.id.saturation_seekbar);
        mLumSeekBar = (SeekBar) findViewById(R.id.lum_seekbar);

        mHueSeekBar.setMax(MAX_VALUE);
        mSaturationSeekBar.setMax(MAX_VALUE);
        mLumSeekBar.setMax(MAX_VALUE);

        mHueSeekBar.setProgress(MID_VALUE);
        mSaturationSeekBar.setProgress(MID_VALUE);
        mLumSeekBar.setProgress(MID_VALUE);

        mHueSeekBar.setOnSeekBarChangeListener(this);
        mSaturationSeekBar.setOnSeekBarChangeListener(this);
        mLumSeekBar.setOnSeekBarChangeListener(this);

        mImageView.setImageBitmap(bitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.hue_seekbar:
                mHue = (progress - MID_VALUE) * 1.0F / MID_VALUE * 180;
                break;
            case R.id.saturation_seekbar:
                mSaturation = progress * 1.0F / MID_VALUE;
                break;
            case R.id.lum_seekbar:
                mLum = progress * 1.0f / MID_VALUE;
                break;
        }


        mImageView.setImageBitmap(ImageHelper.handleImageEffect(this.bitmap, mHue, mSaturation, mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
