package com.example.shool_helper.Fragment_Menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.shool_helper.R;
import com.example.shool_helper.Splash;

import java.util.Objects;

public class InfoFragment extends Fragment {
    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Objects.requireNonNull(getActivity()).setTitle("Приветствие");
        return inflater.inflate(R.layout.fragment_physics, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(Splash.picture){
            ImageView image = Objects.requireNonNull(getActivity()).findViewById(R.id.imageView3);
            Animation hyperspaceJump = AnimationUtils.loadAnimation(getContext(), R.anim.comboanim);
            image.startAnimation(hyperspaceJump);
            Splash.picture=true;
        }



    }
}