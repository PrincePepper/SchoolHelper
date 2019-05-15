package com.example.shool_helper.Fragment_Menu;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shool_helper.Fragment_Menu.Inform_menu.DecisionFragment;
import com.example.shool_helper.Fragment_Menu.Inform_menu.PaymentFragment;
import com.example.shool_helper.R;

import java.util.Objects;


public class InformFragment extends Fragment {

    private Button btnPayment, btnDecision;
    //Фрагменты для отображения на экране
    private PaymentFragment paymentFragment;
    private DecisionFragment fragmentDecision;
    //"Инструмены" необходимые для отображения child фрагментов
    private FragmentTransaction fChildTransactions;
    private FragmentManager fChildManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Objects.requireNonNull(getActivity()).setTitle(R.string.fragment_inform);
        View view = inflater.inflate(R.layout.fragment_inform, container, false);

        initializeFragments();

        View.OnClickListener oclBtn = v -> {
            switch (v.getId()) {
                case R.id.btn_Payment:
                    setPaymentFragment();
                    break;
                case R.id.btn_Decision:
                    setDecisionFragment();
                    break;
            }
        };

        btnPayment = view.findViewById(R.id.btn_Payment);
        btnDecision = view.findViewById(R.id.btn_Decision);

        btnPayment.setOnClickListener(oclBtn);
        btnDecision.setOnClickListener(oclBtn);



        return view;
    }

    private void initializeFragments() {
        fragmentDecision = new DecisionFragment();
        paymentFragment = new PaymentFragment();
    }

    private void setPaymentFragment() {
        //Менеджеру даём именно child manager
        fChildManager = getChildFragmentManager();
        //Уже из child менеджера получаем транзакцию
        fChildTransactions = fChildManager.beginTransaction();
        //Устанавливаем фграмент во frame
        fChildTransactions.replace(R.id.inform_mainFrame, paymentFragment);
        //Применяем транзакцию
        fChildTransactions.commit();
    }

    private void setDecisionFragment() {
        fChildManager = getChildFragmentManager();
        fChildTransactions = fChildManager.beginTransaction();
        fChildTransactions.replace(R.id.inform_mainFrame, fragmentDecision);
        fChildTransactions.commit();
    }


}


