package com.example.shool_helper;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import com.example.shool_helper.Fragment_Menu.InfoFragment;
import com.example.shool_helper.Fragment_Menu.InformFragment;
import com.example.shool_helper.Fragment_Menu.PhysicsFragment;
import com.example.shool_helper.Fragment_Menu.XimiaFragment;

import static com.example.shool_helper.Splash.color;


public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String COLORKEY = "false";
    public static final String PICTURE = "picture";
    public static SharedPreferences sPref;

    public boolean booleanColor;

    private View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeColors(this);
        setTitle("");

        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_navigation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);


        setTitle("School Helper");
        sPref = getPreferences(MODE_PRIVATE);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            openQuitDialog();
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

        booleanColor = sPref.getBoolean(COLORKEY, true);

        if (color == booleanColor) {
            color = !color;
        }
        if (color) {
            header.setBackgroundResource(R.color.colorBlack);
        } else {
            header.setBackgroundResource(R.color.colorRed);
        }

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
            booleanColor = sPref.getBoolean(COLORKEY, false);
            if (color == booleanColor) {
                color = !color;
            }
            if (color) {
                //смена фона
                ThemeColors.setNewThemeColor(NavigationActivity.this, 200, 50, 50);
                //перезапись переменной SharedPreferences
                SharedPreferences.Editor ed = sPref.edit();
                ed.putBoolean(COLORKEY, true);
                ed.apply();
            } else {
                //смена фона
                ThemeColors.setNewThemeColor(NavigationActivity.this, 54, 54, 54);
                //перезапись переменной SharedPreferences
                SharedPreferences.Editor ed = sPref.edit();
                ed.putBoolean(COLORKEY, false);
                ed.apply();
            }
            restartFragment();
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
        ImageView imageView = findViewById(R.id.imageViewItems);
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
            fragment = new InformFragment();
            imageView.setImageResource(R.mipmap.inform_icon);
            ed.putInt(PICTURE, 2);
            ed.apply();
        } else if (id == R.id.nav_ximia) {
            fragment = new XimiaFragment();
            imageView.setImageResource(R.mipmap.ximia_icon);
            ed.putInt(PICTURE, 3);
            ed.apply();
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


    public void restartFragment() {
        Fragment fragment = null;
        ImageView imageView = findViewById(R.id.imageViewItems);
        int picture = sPref.getInt(PICTURE, 0);
        //Выставление соответсвуещей иконки выбранному меню
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
                fragment = new InformFragment();
                imageView.setImageResource(R.mipmap.inform_icon);
                break;
            case 3:
                fragment = new XimiaFragment();
                imageView.setImageResource(R.mipmap.ximia_icon);
                break;

        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.screen_area, fragment);
            ft.commit();
        }
    }

}
