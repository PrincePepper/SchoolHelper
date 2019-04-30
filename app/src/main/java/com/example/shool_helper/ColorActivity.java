package com.example.shool_helper;

import android.app.ActionBar;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.support.annotation.RequiresApi;

import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity {
    public static int red, green, blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        final ImageView mImageView = findViewById(R.id.Color_chance_view);

        final ImageButton button = findViewById(R.id.imageButton);

        final TextView mTextView = findViewById(R.id.textView2);

        mImageView.setDrawingCacheEnabled(true);
        mImageView.buildDrawingCache(true);

        mImageView.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    Bitmap bitmap = mImageView.getDrawingCache();

                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());

                    red = Color.red(pixel);
                    green = Color.green(pixel);
                    blue = Color.blue(pixel);
                    String HEX = "#" + Integer.toHexString(pixel);
                    mTextView.setText(red + ", " + green + ", " + blue);
                    //getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(HEX)));
                    //bar.setBackgroundDrawable(new ColorDrawable(Color.rgb(r,g,b)));
                    //targetView.setBackgroundColor(Color.rgb(r,g,b) );
                    //targetView.setBackgroundResource(R.color.colorPrimaryDark );

                    //mTextView.setText("RGB: "+r+", "+g+", "+b+"\nHEX:"+HEX);

                }
                return true;
            }
        });
        //this.recreate();




    }

}


