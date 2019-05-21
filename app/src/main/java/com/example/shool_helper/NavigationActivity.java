package com.example.shool_helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shool_helper.Fragment_Menu.Chemistry.XimiaFragment;
import com.example.shool_helper.Fragment_Menu.InfoFragment;
import com.example.shool_helper.Fragment_Menu.Informatics.ChangefragmentFragment;
import com.example.shool_helper.Fragment_Menu.Physics.PhysicsFragment;

import static com.example.shool_helper.Splash.color;


public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "myLogs";
    public static final String KEY_FRAGMENT = "fragment";

    static final String COLORKEY = "false", PICTURE = "picture";
    static final String NAME = "ThemeColors", KEY = "color";
    static String stringColor;

    public static SharedPreferences sPref_fragment;

    static SharedPreferences sPref;
    static SharedPreferences sharedPreferences;

    @ColorInt
    int colortheme;

    int key_fragment;
    boolean booleanColor;

    ImageView imageView;
    View header;
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setTitle("");//мы не устанавливаем имя navigation

        ThemeChange();

        setContentView(R.layout.activity_navigation);

        sPref = getPreferences(MODE_PRIVATE);
        sPref_fragment =getPreferences(MODE_PRIVATE);

        toolbar = findViewById(R.id.toolbar);
        imageView = findViewById(R.id.imageviewitems);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if((key_fragment  = sPref_fragment.getInt(KEY_FRAGMENT, 0))==0){
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                openQuitDialog();
            }
        } else{
            Fragment fragment = new ChangefragmentFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            //смена fragment'ов, а не перезапуск
            ft.replace(R.id.screen_area, fragment);
            ft.commit();
        }

    }

    //Вызов меню выхода из приложения
    private void openQuitDialog() {
        //Сообщение о выходе
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(NavigationActivity.this);
        quitDialog.setTitle(R.string.are_you_sure);
        //Кнопка "ДА"
        quitDialog.setPositiveButton(R.string.yes, (dialog, which) -> {
            // TODO Auto-generated method stub
            finish();
        });
        //Кнопка "НЕТ"
        quitDialog.setNegativeButton(R.string.no, (dialog, which) -> {
            // TODO Auto-generated method stub
        });

        quitDialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Это добавляет элементы в панель действий, если она присутствует.
        //Обновляется 1 раз за цикл

        restartFragment();
        getMenuInflater().inflate(R.menu.navigation, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Обрабатывать щелчки элементов панели действий здесь. Панель действий будет
        // автоматически обрабатывать нажатия на кнопку Home / Up, так долго
        // когда вы указываете родительское действие в AndroidManifest.xml.

        int id = item.getItemId();
        //проверка ID фона
        if (id == R.id.action_color) {
            //НАСТРОЙКА ФОНА ПРИЛОЖЕНИЯ
            //запись в booleanColor последнего использованного фона
            booleanColor = sPref.getBoolean(COLORKEY, true);
            if (color == booleanColor) {
                color = !color;
            }
            if (color) {
                //смена фона - красный
                setNewThemeColor(NavigationActivity.this, 200, 50, 50);
                //перезапись переменной SharedPreferences
                SharedPreferences.Editor ed = sPref.edit();
                ed.putBoolean(COLORKEY, true);
                ed.apply();
            } else {
                //смена фона - темный-серый
                setNewThemeColor(NavigationActivity.this, 54, 54, 54);
                //перезапись переменной SharedPreferences
                SharedPreferences.Editor ed = sPref.edit();
                ed.putBoolean(COLORKEY, false);
                ed.apply();

            }

        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //Обрабатывать навигацию просмотра элементов кликами здесь.
        //Здесь происходит открытие фрагментов окон

        //инициализация Fragment
        Fragment fragment = null;
        //перехвать id окна
        int id = item.getItemId();
        //инициализация SharedPreferences
        SharedPreferences.Editor ed = sPref.edit();
        //инициализация imageView
        imageView = findViewById(R.id.imageviewitems);
        //проверка ID на выбор окон
        if (id == R.id.nav_physics) {
            //запуск fragment'a
            fragment = new PhysicsFragment();
            //установка ижображение конкретного окна
            imageView.setImageResource(R.mipmap.physics_icon);
            //перезапись SharedPreferences
            ed.putInt(PICTURE, 1);
            ed.apply();
        } else if (id == R.id.nav_inform) {

            fragment = new ChangefragmentFragment();
            imageView.setImageResource(R.mipmap.inform_icon);
            ed.putInt(PICTURE, 2);
            ed.apply();
        } else if (id == R.id.nav_ximia) {
            Toast.makeText(this, R.string.In_developing, Toast.LENGTH_SHORT).show();
            /*fragment = new XimiaFragment();
            imageView.setImageResource(R.mipmap.ximia_icon);
            ed.putInt(PICTURE, 3);
            ed.apply();*/
        } else if (id == R.id.nav_about) {
            //инициализация и вызов нового окна About повех всех
            Intent intent_about = new Intent(NavigationActivity.this, About.class);
            startActivity(intent_about);
        } else if (id == R.id.nav_send) {
            fragment = new InfoFragment();
            imageView.setImageResource(R.mipmap.logo);
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            //смена fragment'ов, а не перезапуск
            ft.replace(R.id.screen_area, fragment);
            ft.commit();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void ThemeChange() {
        sharedPreferences = getSharedPreferences(NAME, Context.MODE_PRIVATE);
        String stringColor = sharedPreferences.getString(KEY, "363636");
        colortheme = Color.parseColor("#" + stringColor);

        if (isLightActionBar()) setTheme(R.style.AppTheme);
        setTheme(getResources().getIdentifier("T_" + stringColor, "style",//установка темы
                getPackageName()));
    }

    public void restartFragment() {
        Fragment fragment = null;
        int picture = sPref.getInt(PICTURE, 0);
        imageView = findViewById(R.id.imageviewitems);
        //Выставление соответсвуещей иконки выбранному меню
        if (imageView != null) {
            switch (picture) {
                case 0:
                    fragment = new InfoFragment();
                    imageView.setImageResource(R.mipmap.logo);
                    break;
                case 1:
                    fragment = new PhysicsFragment();
                    imageView.setImageResource(R.mipmap.physics_icon);
                    break;
                case 2:
                    fragment = new ChangefragmentFragment();
                    imageView.setImageResource(R.mipmap.inform_icon);
                    break;
                case 3:
                    fragment = new XimiaFragment();
                    imageView.setImageResource(R.mipmap.ximia_icon);
                    break;

            }
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.screen_area, fragment);
            ft.commit();
        }
        booleanColor = sPref.getBoolean(COLORKEY, true);
        if (color == booleanColor) {
            color = !color;
        }
        if (color) {
            header.setBackgroundResource(R.color.colorBlack);
        } else {
            header.setBackgroundResource(R.color.colorRed);
        }

    }


    public static void setNewThemeColor(Activity activity, int red, int green, int blue) {
        int colorStep = 15;

        red = Math.round(red / colorStep) * colorStep;
        green = Math.round(green / colorStep) * colorStep;
        blue = Math.round(blue / colorStep) * colorStep;

        stringColor = Integer.toHexString(Color.rgb(red, green, blue)).substring(2);
        SharedPreferences.Editor editor = activity.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit();
        editor.putString(KEY, stringColor);
        editor.apply();

        activity.recreate();

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) activity.recreate();
        else {
            Intent i = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
            assert i != null;
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivity(i);
        }*/

    }

    private boolean isLightActionBar() {// Checking if title text color will be black
        int rgb = (Color.red(colortheme) + Color.green(colortheme) + Color.blue(colortheme)) / 3;
        return rgb > 210;
    }

}


