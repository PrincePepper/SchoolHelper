package com.example.shool_helper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;


public class About extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_about);

        //находим TextView
        TextView email=findViewById(R.id.email);
        TextView instagram=findViewById(R.id.instagram);
        TextView telegram=findViewById(R.id.telegram);
        TextView github=findViewById(R.id.github);

//Экранируем кавычки в атрибуте html тега слэшем:
        String textWithLink_email = "<a href=\"semyon3336@gmail.com\">Email</a>";
        String textWithLink_instagram = "<a href=\"https://www.instagram.com/school_helper_vl\">Instagram</a>";
        String textWithLink_telegram = "<a href=\"https://t.me/PrincePepper\">Telegram</a>";
        String textWithLink_github = "<a href=\"https://github.com/PrincePepper\">GitHub</a>";


//Указываем с помощью Html.fromHtml, что у нас не просто текст:
        email.setText(Html.fromHtml(textWithLink_email, null, null));
        instagram.setText(Html.fromHtml(textWithLink_instagram, null, null));
        telegram.setText(Html.fromHtml(textWithLink_telegram, null, null));
        github.setText(Html.fromHtml(textWithLink_github, null, null));

////Указываем что разрешаем ссылки кликать:
        email.setLinksClickable(true);
        email.setMovementMethod(LinkMovementMethod.getInstance());

        instagram.setLinksClickable(true);
        instagram.setMovementMethod(LinkMovementMethod.getInstance());

        telegram.setLinksClickable(true);
        telegram.setMovementMethod(LinkMovementMethod.getInstance());

        github.setLinksClickable(true);
        github.setMovementMethod(LinkMovementMethod.getInstance());

//Научаемся отлавливать клики пропустив текст через наш класс из пред. пункта.
        CharSequence text1 = email.getText();
        CharSequence text2 = instagram.getText();
        CharSequence text3 = telegram.getText();
        CharSequence text4 = github.getText();
        if (text1 instanceof Spannable) { email.setText(MakeLinksClicable.reformatText(text1));
        }
        if (text2 instanceof Spannable) { instagram.setText(MakeLinksClicable.reformatText(text2));
        }
        if (text3 instanceof Spannable) { telegram.setText(MakeLinksClicable.reformatText(text3));
        }
        if (text4 instanceof Spannable) { github.setText(MakeLinksClicable.reformatText(text4));
        }
    }

}
