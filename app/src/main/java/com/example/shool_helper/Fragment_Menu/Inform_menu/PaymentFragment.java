package com.example.shool_helper.Fragment_Menu.Inform_menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shool_helper.R;

import java.math.BigInteger;
import java.util.Objects;

public class PaymentFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    public static String choose1, choose2, strnumber, result;
    public static int chooseint_1, chooseint_2;

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pay, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner spinner1 = Objects.requireNonNull(getActivity()).findViewById(R.id.spinner1);
        Spinner spinner2 = Objects.requireNonNull(getActivity()).findViewById(R.id.spinner2);
        TextView textView = getActivity().findViewById(R.id.result);
        EditText editText = getActivity().findViewById(R.id.editText);
        Button button_inform = getActivity().findViewById(R.id.button_pay);

        ArrayAdapter<?> adapter1 = ArrayAdapter.createFromResource(Objects.requireNonNull(getContext()), R.array.spinner_numbers_1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<?> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.spinner_numbers_2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(PaymentFragment.this);


        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(PaymentFragment.this);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                choose1 = parent.getSelectedItem().toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                choose2 = parent.getSelectedItem().toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        button_inform.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                int start = 1;
                strnumber = editText.getText().toString();
                chooseint_1 = Integer.parseInt(choose1);
                chooseint_2 = Integer.parseInt(choose2);
                for (int i = 0; i < strnumber.length(); i++) {
                    char chars = strnumber.charAt(0);
                    if (chooseint_1 == 2 && chars > '1') {
                        start = 0;
                        break;
                    } else if (chooseint_1 == 3 && chars > '2') {
                        start = 0;
                        break;
                    } else if (chooseint_1 == 4 && chars > '3') {
                        start = 0;
                        break;
                    } else if (chooseint_1 == 5 && chars > '4') {
                        start = 0;
                        break;
                    } else if (chooseint_1 == 6 && chars > '5') {
                        start = 0;
                        break;
                    } else if (chooseint_1 == 7 && chars > '6') {
                        start = 0;
                        break;
                    } else if (chooseint_1 == 8 && chars > '7') {
                        start = 0;
                        break;
                    } else if (chooseint_1 == 9 && chars > '8') {
                        start = 0;
                        break;
                    } else if (chooseint_1 == 10 && chars > '9') {
                        start = 0;
                        break;
                    }
                }

                if (start == 1) {
                    if (chooseint_2 == 16) {

                        BigInteger b = new BigInteger(new BigInteger(strnumber).toString(10), chooseint_1);
                        result = b.toString();
                        result = Integer.toHexString(Integer.parseInt(result)).toUpperCase();

                    } else {
                        BigInteger b = new BigInteger(new BigInteger(strnumber).toString(chooseint_2), chooseint_1);
                        result = b.toString();
                    }

                    textView.setText(result);
                } else {
                    Toast.makeText(getContext(), "Неправильно выбрана система счисления числа", Toast.LENGTH_SHORT).show();
                }
            } else {

                Toast.makeText(getContext(), "Введите число, чтобы не возникло ошибки", Toast.LENGTH_SHORT).show();
            }


        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}


