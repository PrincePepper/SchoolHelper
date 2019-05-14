package com.example.shool_helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    public static boolean color;
    public static boolean picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);
        int SPLASH_DISPLAY = 3000;
        startAnimation();
        new Handler().postDelayed(() -> {

            Intent SplashIntent = new Intent(Splash.this, NavigationActivity.class);
            Splash.this.startActivity(SplashIntent);

            Splash.this.finish();

        }, SPLASH_DISPLAY);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        color=false;
        picture=false;
    }
    private void startAnimation(){

        ImageView imageView = findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.comboanim);
        imageView.startAnimation(animation);
    }
}
