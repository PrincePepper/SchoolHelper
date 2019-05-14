package com.example.shool_helper.Fragment_Menu.Inform_menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.shool_helper.Fragment_Menu.InformFragment;
import com.example.shool_helper.R;

import java.util.Objects;

public class ChangefragmentFragment extends Fragment {
    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_change, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Button[] ip_cal = {Objects.requireNonNull(getActivity()).findViewById(R.id.ip_cal)};
        final Button[] scale_cal = {getActivity().findViewById(R.id.scale_cal)};
        final Fragment[] fragment = {null};
        scale_cal[0].setOnClickListener(v -> {
            fragment[0] = new InformFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.screen_area, fragment[0]);
            ft.commit();
        });

        ip_cal[0].setOnClickListener(v -> {
            Toast.makeText(getContext(), R.string.In_developing, Toast.LENGTH_SHORT).show();
            /*fragment[0] = new NetworkCalFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.screen_area, fragment[0]);
            ft.commit();*/
        });
    }
}
