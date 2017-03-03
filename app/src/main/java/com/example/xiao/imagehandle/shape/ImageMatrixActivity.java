package com.example.xiao.imagehandle.shape;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.xiao.imagehandle.R;
import com.example.xiao.imagehandle.view.ImageMatrixView;

/**
 * 通过矩阵变换实现图像变形特效
 */
public class ImageMatrixActivity extends AppCompatActivity {

    private ImageMatrixView mImageMatrixView;
    private GridLayout mGridLayout;
    private int mEtWidth, mEtHeight;
    private EditText[] mEts = new EditText[9];
    private float[] mMatrixs = new float[9];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_matrix);

        setTitle("矩阵变换");

        mImageMatrixView = (ImageMatrixView) findViewById(R.id.image_matrix_view);
        mGridLayout = (GridLayout) findViewById(R.id.image_matrix_group);
        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth = mGridLayout.getWidth() / 3;
                mEtHeight = mGridLayout.getHeight() / 3;

                addEts();
                initImageMatrix();
            }
        });
    }

    private void addEts() {
        for (int i = 0; i < 9; i++) {
            EditText editText = new EditText(ImageMatrixActivity.this);
            mEts[i] = editText;
            editText.setGravity(Gravity.CENTER);
            mGridLayout.addView(editText, mEtWidth, mEtHeight);
        }

    }

    private void initImageMatrix() {
        for (int i = 0; i < 9; i++) {
            if (i % 4 == 0) {
                mEts[i].setText(String.valueOf(1));
            } else {
                mEts[i].setText(String.valueOf(0));
            }
        }
    }

    private void getImageMatrix() {
        for (int i = 0; i < 9; i++) {
            mMatrixs[i] = Float.valueOf(mEts[i].getText().toString().trim());
        }
    }

    private void setImageMatrix() {
        Matrix matrix = new Matrix();
        matrix.setValues(mMatrixs);
        mImageMatrixView.setImageMatrix(matrix);
        mImageMatrixView.invalidate();

    }

    public void btnChange(View view) {
        getImageMatrix();
        setImageMatrix();


    }

    public void btnReset(View view) {
        initImageMatrix();
        getImageMatrix();
        setImageMatrix();
    }
}
