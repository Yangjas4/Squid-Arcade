package com.example.squidarcade;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragment_marbles_main extends Fragment implements View.OnClickListener{

    Button marblesBtn;
    Button rlglBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homePage =  inflater.inflate(R.layout.fragment_home_page, container, false);
        marblesBtn = (Button) homePage.findViewById(R.id.marblesButton);
        marblesBtn.setOnClickListener(this);
        rlglBtn = (Button) homePage.findViewById(R.id.rlglButton);
        rlglBtn.setOnClickListener(this);
        return homePage;
    }

    @Override
    public void onClick(View view) {
        if (view == marblesBtn) {
       //
        }
    }
}