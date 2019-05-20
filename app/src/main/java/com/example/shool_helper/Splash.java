package com.example.shool_helper;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.shool_helper.Database.Database;
import com.example.shool_helper.Database.Employees;

public class Splash extends AppCompatActivity {

    protected static boolean color;
    public static boolean picture;
    Database dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        startSplashAmimation();
        initializeDataBase();
        filddatabase();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        color = false;
        picture = false;
    }

    //Метод инициализации базы данных
    private void initializeDataBase() {
        dataBase = Room.databaseBuilder(getApplicationContext(), Database.class, "note_database").allowMainThreadQueries().build();
    }

    private void filddatabase() {
        //Достаём список записей из таблицы
        if (dataBase.entityDao().getAll().isEmpty()) {
            dataBase.entityDao().insert(new Employees("AAA", "FFF"));
        }
    }

    //запуск
    private  void startSplashAmimation(){
        int SPLASH_DISPLAY = 3000;
        startAnimation();
        new Handler().postDelayed(() -> {

            Intent SplashIntent = new Intent(Splash.this, NavigationActivity.class);
            Splash.this.startActivity(SplashIntent);

            Splash.this.finish();

        }, SPLASH_DISPLAY);
    }

    private void startAnimation() {
        ImageView imageView = findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.comboanim);
        imageView.startAnimation(animation);
    }
}
