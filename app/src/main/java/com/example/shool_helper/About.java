package com.example.shool_helper;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.Objects;

public class About extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_about);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!Splash.color) {
                    ThemeColors.setNewThemeColor(About.this, 200, 50, 50);
                    Splash.color=true;
                } else {
                    ThemeColors.setNewThemeColor(About.this, 54, 54, 54);
                    Splash.color=false;;
                }
            }
        }, 2000);

    }
}
