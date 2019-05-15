package com.example.shool_helper;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class About extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_about);

        ImageButton rate = findViewById(R.id.rate);

        //находим TextView
        TextView instagram = findViewById(R.id.instagram);
        TextView telegram = findViewById(R.id.telegram);
        TextView github = findViewById(R.id.github);

//Экранируем кавычки в атрибуте html тега слэшем:
        String textWithLink_instagram = "<a href=\"https://www.instagram.com/ppt.co_official\">Instagram</a>";
        String textWithLink_telegram = "<a href=\"https://t.me/PrincePepper\">Telegram</a>";
        String textWithLink_github = "<a href=\"https://github.com/PrincePepper\">GitHub</a>";


//Указываем с помощью Html.fromHtml, что у нас не просто текст:
        instagram.setText(Html.fromHtml(textWithLink_instagram, null, null));
        telegram.setText(Html.fromHtml(textWithLink_telegram, null, null));
        github.setText(Html.fromHtml(textWithLink_github, null, null));

////Указываем что разрешаем ссылки кликать:
        instagram.setLinksClickable(true);
        instagram.setMovementMethod(LinkMovementMethod.getInstance());

        telegram.setLinksClickable(true);
        telegram.setMovementMethod(LinkMovementMethod.getInstance());

        github.setLinksClickable(true);
        github.setMovementMethod(LinkMovementMethod.getInstance());

//Научаемся отлавливать клики пропустив текст через наш класс из пред. пункта.
        CharSequence text2 = instagram.getText();
        CharSequence text3 = telegram.getText();
        CharSequence text4 = github.getText();
        if (text2 instanceof Spannable) {
            instagram.setText(MakeLinksClicable.reformatText(text2));
        }
        if (text3 instanceof Spannable) {
            telegram.setText(MakeLinksClicable.reformatText(text3));
        }
        if (text4 instanceof Spannable) {
            github.setText(MakeLinksClicable.reformatText(text4));
        }
        rate.setOnClickListener(this::onClickRateThisApp);
    }


    public void onClickRateThisApp(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.supercell.hayday"));
        if (isActivityStarted(intent)) {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.supercell.hayday"));
            if (isActivityStarted(intent)) {
                //оповещение об отсутсвии Play Market
                Toast.makeText(this, getString(R.string.android_market), Toast.LENGTH_SHORT).show();
            }
        }
    }
    private boolean isActivityStarted(Intent aIntent) {
        try {
            startActivity(aIntent);
            return false;
        } catch (ActivityNotFoundException e) {
            return true;
        }
    }
}
