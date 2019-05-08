package com.example.shool_helper.Fragment_Menu.Inform_menu;

import android.annotation.SuppressLint;
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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView decision_textView2= Objects.requireNonNull(getActivity()).findViewById(R.id.decision_textView2);
        TextView decision_textView3=getActivity().findViewById(R.id.decision_textView3);
        TextView decision_textView4=getActivity().findViewById(R.id.decision_textView4);
        TextView decision_textView5=getActivity().findViewById(R.id.decision_textView5);
        TextView decision_textView6=getActivity().findViewById(R.id.decision_textView6);
        TextView decision_result=getActivity().findViewById(R.id.decision_result);
        if(chooseint_1!=10){
            decision_textView2.setText("Приведем "+strnumber+" из системы счисления "+chooseint_1+" в десятичную систему счисления:");
            decision_textView3.setText(strnumber+"-->"+subtotal);
            decision_textView4.setText("Приведем целую часть числа "+subtotal+" в систему счисления "+chooseint_2+" последовательным делением на число "+chooseint_1+".");
            decision_textView5.setText("Записав полученные цифры в ряд снизу вверх, получим:");
            decision_textView6.setText(subtotal+"-->"+result);
            decision_result.setText(resultend);
        } else{
            decision_textView2.setText("Приведем целую часть числа "+subtotal+" в систему счисления "+chooseint_2+" последовательным делением на число "+chooseint_1+".");
            decision_textView3.setText("Записав полученные цифры в ряд снизу вверх, получим:");
            decision_textView4.setText(subtotal+"-->"+result);
            decision_result.setText(resultend);
        }


    }

}