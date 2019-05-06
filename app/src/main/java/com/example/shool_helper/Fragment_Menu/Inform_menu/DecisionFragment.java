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

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView decision_textView2 = Objects.requireNonNull(getActivity()).findViewById(R.id.decision_textView2);
        decision_textView2.setText("Приведем число "+strnumber+" в систему счисления "+chooseint_2+" последовательным делением на число "+chooseint_2+":");
        //TextView decision_textView3 = getActivity().findViewById(R.id.decision_textView3);

        TextView decision_result = getActivity().findViewById(R.id.decision_result);
        decision_result.setText(result);
    }

}
