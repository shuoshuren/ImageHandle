package com.example.xiao.imagehandle.color;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.xiao.imagehandle.R;

/**
 * 通过矩阵改变图片的色相，饱和度，亮度
 */
public class ColorMatrixActivity extends AppCompatActivity {

    private ImageView mImageView;
    private GridLayout mGridLayout;
    private Bitmap mBitmap;
    private int mEtWidth,mEtHeight;
    private EditText[] mEts = new EditText[20];
    private float[] mColorMatrix = new float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix);
        setTitle("颜色矩阵");
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test1);
        mImageView = (ImageView) findViewById(R.id.color_matrix_imageview);
        mGridLayout = (GridLayout) findViewById(R.id.group);
        mImageView.setImageBitmap(mBitmap);

        mGridLayout.post(new Runnable() {
            @Override
            public void run() {

                mEtWidth = mGridLayout.getWidth() /5;
                mEtHeight = mGridLayout.getHeight() /4;
                addEditText();
                initMatrix();
            }
        });


    }



    private void addEditText(){
        for (int i = 0; i < 20; i++) {
            EditText editText = new EditText(this);
            mEts[i] = editText;
            mGridLayout.addView(editText,mEtWidth,mEtHeight);
        }
    }

    private void initMatrix(){
        for (int i = 0; i < 20; i++) {
            if(i%6==0){

                mEts[i].setText(String.valueOf(1));
            }else{

                mEts[i].setText(String.valueOf(0));
            }

        }
    }

    private void getMatrix(){
        for (int i = 0; i < 20; i++) {
            mColorMatrix[i] = Float.valueOf(mEts[i].getText().toString().trim());
        }
    }

    private void setImageMatrix(){
        Bitmap bmp = Bitmap.createBitmap(mBitmap.getWidth(),mBitmap.getHeight(),Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix(mColorMatrix);

        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(mBitmap,0,0,paint);
        mImageView.setImageBitmap(bmp);
    }

    public void btnChange(View view){
        getMatrix();
        setImageMatrix();

    }


    public void btnReset(View view){
        initMatrix();
        getMatrix();
        setImageMatrix();
    }
}
