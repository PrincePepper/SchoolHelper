package com.example.shool_helper.Fragment_Menu.Inform_menu;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shool_helper.R;

import java.util.Objects;

import static com.example.shool_helper.Fragment_Menu.Inform_menu.PaymentFragment.*;


public class DecisionFragment extends Fragment {
    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_decision, container, false);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView decision_textView2= Objects.requireNonNull(getActivity()).findViewById(R.id.decision_textView2);
        TextView decision_textView3=getActivity().findViewById(R.id.decision_textView3);
        TextView decision_textView4=getActivity().findViewById(R.id.decision_textView4);
        TextView decision_textView5=getActivity().findViewById(R.id.decision_textView5);
        TextView decision_textView6=getActivity().findViewById(R.id.decision_textView6);
        TextView decision_textView7=getActivity().findViewById(R.id.decision_textView7);
        if(chooseint_1!=10){
            decision_textView2.setText(getString(R.string.will_give)+strnumber+getString(R.string.number_systems)+chooseint_1+getString(R.string.decimal_number_system));
            decision_textView2.setTypeface(decision_textView2.getTypeface(), Typeface.BOLD);
            decision_textView2.setTextColor(Color.BLACK);
            decision_textView2.setTextSize(15);

            decision_textView3.setText(strnumber+getString(R.string.arrow)+subtotal);
            decision_textView3.setTypeface(decision_textView3.getTypeface(), Typeface.ITALIC);
            decision_textView3.setTextColor(Color.MAGENTA);
            decision_textView3.setTextSize(20);

            decision_textView4.setText("Приведем целую часть числа "+subtotal+" в систему счисления "+chooseint_2+" последовательным делением на число "+chooseint_1+".");
            decision_textView4.setTypeface(decision_textView4.getTypeface(), Typeface.BOLD);
            decision_textView4.setTextColor(Color.BLACK);
            decision_textView4.setTextSize(15);

            decision_textView5.setText("Записав полученные цифры в ряд снизу вверх, получим:");
            decision_textView5.setTypeface(decision_textView5.getTypeface(), Typeface.BOLD);
            decision_textView5.setTextColor(Color.BLACK);
            decision_textView5.setTextSize(15);

            decision_textView6.setText(subtotal+getString(R.string.arrow)+result);
            decision_textView6.setTypeface(decision_textView6.getTypeface(), Typeface.ITALIC);
            decision_textView6.setTextColor(Color.MAGENTA);
            decision_textView6.setTextSize(20);

            decision_textView7.setText(resultend);
            decision_textView7.setTypeface(decision_textView7.getTypeface(), Typeface.BOLD_ITALIC);
            decision_textView5.setTextColor(Color.RED);
            decision_textView7.setTextSize(20);

        } else{
            decision_textView2.setText(getString(R.string.give_the_integer_part)+subtotal+getString(R.string.in_number_systems)+chooseint_2+getString(R.string.successive_division_by_number)+chooseint_2+getString(R.string.point));
            decision_textView2.setTypeface(decision_textView2.getTypeface(), Typeface.BOLD);
            decision_textView2.setTextColor(Color.BLACK);
            decision_textView2.setTextSize(15);

            decision_textView3.setText("Записав полученные цифры в ряд снизу вверх, получим:");
            decision_textView3.setTypeface(decision_textView3.getTypeface(), Typeface.BOLD);
            decision_textView3.setTextColor(Color.BLACK);
            decision_textView3.setTextSize(15);

            decision_textView4.setText(subtotal+"-->"+result);
            decision_textView4.setTypeface(decision_textView4.getTypeface(), Typeface.ITALIC);
            decision_textView4.setTextColor(Color.MAGENTA);
            decision_textView4.setTextSize(20);

            decision_textView5.setText(resultend);
            decision_textView5.setTypeface(decision_textView5.getTypeface(), Typeface.BOLD_ITALIC);
            decision_textView5.setTextColor(Color.RED);
            decision_textView5.setTextSize(20);

        }


    }

}