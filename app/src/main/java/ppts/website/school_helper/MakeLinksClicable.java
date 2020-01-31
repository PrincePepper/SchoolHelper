package ppts.website.school_helper;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;

//Здесь происходит обработка ссылок в Activity "About"
class MakeLinksClicable {
    private final static String LOG = MakeLinksClicable.class.getSimpleName();

    public static class CustomerTextClick extends ClickableSpan {
        String mUrl;

        CustomerTextClick(String url) {
            mUrl = url;
        }

        @Override
        public void onClick(@NonNull View widget) {
            //Тут можно как-то обработать нажатие на ссылку
            //Сейчас же мы просто открываем браузер с ней

            Log.i(LOG, "url clicked: " + this.mUrl);

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(mUrl));
            widget.getContext().startActivity(i);
        }
    }

    static SpannableStringBuilder reformatText(CharSequence text) {
        int end = text.length();
        Spannable sp = (Spannable) text;
        URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);
        SpannableStringBuilder style = new SpannableStringBuilder(text);
        for (URLSpan url : urls) {
            style.removeSpan(url);
            MakeLinksClicable.CustomerTextClick click = new MakeLinksClicable.CustomerTextClick(url.getURL());
            style.setSpan(click, sp.getSpanStart(url), sp.getSpanEnd(url),
                          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return style;
    }
}