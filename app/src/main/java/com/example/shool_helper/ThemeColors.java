package com.example.shool_helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;

public class ThemeColors extends AppCompatActivity {

    private static final String NAME = "ThemeColors", KEY = "color";
    public static String stringColor;

    @ColorInt
    public int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            Context context = new NavigationActivity();
            getWindow().setNavigationBarColor(context.getResources().getIdentifier("T_" + stringColor, "style", context.getPackageName()));
            getWindow().setStatusBarColor(context.getResources().getIdentifier("T_" + stringColor, "style", context.getPackageName()));

        }
    }
    public ThemeColors(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        String stringColor = sharedPreferences.getString(KEY, "c83232");
        color = Color.parseColor("#" + stringColor);

        if (isLightActionBar()) context.setTheme(R.style.AppTheme);
        context.setTheme(context.getResources().getIdentifier("T_" + stringColor, "style", context.getPackageName()));


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
        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) activity.recreate();
        else {
            Intent i = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
            assert i != null;
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivity(i);
        }
         */
    }

    private boolean isLightActionBar() {// Checking if title text color will be black
        int rgb = (Color.red(color) + Color.green(color) + Color.blue(color)) / 3;
        return rgb > 210;
    }
}