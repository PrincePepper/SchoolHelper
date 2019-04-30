package com.example.shool_helper;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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
import android.view.Window;

import com.example.shool_helper.Fragment_Menu.InformFragment;
import com.example.shool_helper.Fragment_Menu.PhysicsFragment;
import com.example.shool_helper.Fragment_Menu.XimiaFragment;


public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        new ThemeColors(this);

        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        setTitle("School Helper");



    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Раздувать меню; это добавляет элементы в панель действий, если она присутствует.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Обрабатывать щелчки элементов панели действий здесь. Панель действий будет
        // автоматически обрабатывать нажатия на кнопку Home / Up, так долго
        // когда вы указываете родительское действие в AndroidManifest.xml.


        int id = item.getItemId();


        if (id == R.id.action_color) {




            if (Splash.color==false) {
                ThemeColors.setNewThemeColor(NavigationActivity.this, 200, 50, 50);
                Splash.color=true;
            } else {
                ThemeColors.setNewThemeColor(NavigationActivity.this, 54, 54, 54);
                Splash.color=false;;
            }

            //Intent intent_color = new Intent(NavigationActivity.this,ColorActivity.class);
            //startActivity(intent_color);
        }

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Обрабатывать навигацию просмотра элементов кликами здесь.

        Fragment fragment = null;

        int id = item.getItemId();

        if (id == R.id.nav_physics) {
            fragment = new PhysicsFragment();
        } else if (id == R.id.nav_inform) {
            fragment = new InformFragment();
        } else if (id == R.id.nav_ximia) {
            fragment = new XimiaFragment();
        } else if (id == R.id.nav_about) {
            Intent intent_about = new Intent(NavigationActivity.this, About.class);
            startActivity(intent_about);
        } else if (id == R.id.nav_send) {


        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.screen_area, fragment);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
