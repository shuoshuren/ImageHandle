package com.example.xiao.imagehandle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.xiao.imagehandle.color.ColorMatrixActivity;
import com.example.xiao.imagehandle.color.PixelsEffectActivity;
import com.example.xiao.imagehandle.color.PrimaryColorActivity;
import com.example.xiao.imagehandle.shape.BitmapShaderActivity;
import com.example.xiao.imagehandle.shape.ImageMatrixActivity;
import com.example.xiao.imagehandle.shape.MeshActivity;
import com.example.xiao.imagehandle.shape.ReflectActivity;
import com.example.xiao.imagehandle.shape.XfermodeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seekToPrimaryColor(View view){
        Intent intent = new Intent(MainActivity.this,PrimaryColorActivity.class);
        startActivity(intent);
    }

    public void seekToColorMatrix(View view){
        Intent intent = new Intent(MainActivity.this,ColorMatrixActivity.class);
        startActivity(intent);
    }

    public void seekToPixelsEffect(View view){
        Intent intent = new Intent(MainActivity.this,PixelsEffectActivity.class);
        startActivity(intent);

    }

    public void seekToImageMatrix(View view){
        Intent intent = new Intent(MainActivity.this,ImageMatrixActivity.class);
        startActivity(intent);
    }

    public void seekToXfermode(View view){
        Intent intent = new Intent(MainActivity.this, XfermodeActivity.class);
        startActivity(intent);
    }

    public void seekToBitmapShader(View view){
        Intent intent = new Intent(MainActivity.this, BitmapShaderActivity.class);
        startActivity(intent);
    }


    public void seekToReflect(View view){
        Intent intent = new Intent(MainActivity.this, ReflectActivity.class);
        startActivity(intent);
    }

    public void seekToMesh(View view){
        Intent intent = new Intent(MainActivity.this, MeshActivity.class);
        startActivity(intent);
    }
}
