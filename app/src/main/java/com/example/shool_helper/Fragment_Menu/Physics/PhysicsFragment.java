package com.example.shool_helper.Fragment_Menu.Physics;


import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shool_helper.Database.Database;
import com.example.shool_helper.Database.Employees;
import com.example.shool_helper.NavigationActivity;
import com.example.shool_helper.R;

import java.util.Objects;

public class PhysicsFragment extends Fragment {
    Database dataBase;

    TextView textView_formula;
    Button button_find;
    EditText editText_formula;

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Objects.requireNonNull(getActivity()).setTitle(R.string.fragment_physics);

        SharedPreferences.Editor ed = NavigationActivity.sPref_fragment.edit();
        ed.putInt(NavigationActivity.KEY_FRAGMENT, 0);
        ed.apply();

        return inflater.inflate(R.layout.fragment_physics, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView_formula = Objects.requireNonNull(getActivity()).findViewById(R.id.textView_formula);
        button_find = getActivity().findViewById(R.id.button_find);
        editText_formula = getActivity().findViewById(R.id.editText_formula);

        initializeDataBase();

        button_find.setOnClickListener(v -> findFormula());

    }

    private void findFormula() {
        try {
            Employees entity = dataBase.entityDao().getByName(editText_formula.getText().toString());
            String name = entity.getFormula();
            textView_formula.setText(name);
        } catch (Exception e) {
            Toast.makeText(getContext(), R.string.enter_the_number, Toast.LENGTH_SHORT).show();
        }

    }


    //Метод инициализации базы данных
    private void initializeDataBase() {
        dataBase = Room.databaseBuilder(Objects.requireNonNull(getActivity()).getApplicationContext(), Database.class, "note_database").allowMainThreadQueries().build();
    }

}
