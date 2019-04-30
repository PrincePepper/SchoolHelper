package com.example.shool_helper;

import android.content.Intent;

import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
public static boolean color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int SPLASH_DISPLAY = 1800;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent SplashIntent = new Intent(Splash.this, NavigationActivity.class);
                Splash.this.startActivity(SplashIntent);
                Splash.this.finish();


            }
        }, SPLASH_DISPLAY);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        color=false;
    }
}
