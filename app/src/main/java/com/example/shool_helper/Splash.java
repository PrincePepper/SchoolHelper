package com.example.shool_helper;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
public static boolean color;
    private static final String Theme = "Theme";
    public static boolean booleanTheme;
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
    public SharedPreferences getPreferences(int mode) {
        return super.getPreferences(mode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        /*SharedPreferences sharedPreferences = new Splash().getSharedPreferences(Theme, Context.MODE_PRIVATE);
         booleanTheme = sharedPreferences.getBoolean(Theme, false);*/
        color=false;
    }
}
