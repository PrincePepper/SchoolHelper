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
            dataBase.entityDao().insert(new Employees("давление", "Р=F/S"));
            dataBase.entityDao().insert(new Employees("плотность", "ρ=m/V"));
            dataBase.entityDao().insert(new Employees("давление на глубине жидкости", "P=ρ∙g∙h"));
            dataBase.entityDao().insert(new Employees("сила тяжести", "F=mg"));
            dataBase.entityDao().insert(new Employees("архимедова сила", "F=ρж∙g∙Vт"));
            dataBase.entityDao().insert(new Employees("ускорение", " a=(υ-υ 0)/t"));
            dataBase.entityDao().insert(new Employees("скорость при движении по окружности", "υ=2πR/Т"));
            dataBase.entityDao().insert(new Employees("центростремительное ускорение", "a=υ2/R"));
            dataBase.entityDao().insert(new Employees("связь периода с частотой", "ν=1/T=ω/2π"));
            dataBase.entityDao().insert(new Employees("2 закон Ньютона", "F=ma"));
            dataBase.entityDao().insert(new Employees("закон Гука", "Fy=-kx"));
            dataBase.entityDao().insert(new Employees("закон Всемирного тяготения", "F=G∙M∙m/R2"));
            dataBase.entityDao().insert(new Employees("сила трения", "Fтр=µN"));
            dataBase.entityDao().insert(new Employees("импульс тела", "p=mυ"));
            dataBase.entityDao().insert(new Employees("момент силы", "M=F∙ℓ"));
            dataBase.entityDao().insert(new Employees("потенциальная энергия тела", "Eп=mgh"));
            dataBase.entityDao().insert(new Employees("кинетическая энергия тела", "Ek=mυ2/2"));
            dataBase.entityDao().insert(new Employees("работа", "A=F∙S∙cosα"));
            dataBase.entityDao().insert(new Employees("мощность", "N=A/t=F∙υ"));
            dataBase.entityDao().insert(new Employees("коэффициент полезного действия", "η=Aп/Аз"));
            dataBase.entityDao().insert(new Employees("длина волны", "λ= υТ"));
            dataBase.entityDao().insert(new Employees("молярная масса", "М=m/ν"));
            dataBase.entityDao().insert(new Employees("закон Кулона", "F=k∙q1∙q2/R2"));
            dataBase.entityDao().insert(new Employees("сила тока", "I=q/t"));
            dataBase.entityDao().insert(new Employees("сопротивление проводника", "R=ρ∙ℓ/S"));
            dataBase.entityDao().insert(new Employees("закон Ома", " I=U/R"));
            dataBase.entityDao().insert(new Employees("мощность электрического тока", "P=I∙U"));

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
