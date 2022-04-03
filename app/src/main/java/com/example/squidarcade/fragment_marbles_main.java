package com.example.squidarcade;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragment_marbles_main extends Fragment implements View.OnClickListener {
    Button singleplayerBtn;
    Button multiplayerBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homePage =  inflater.inflate(R.layout.fragment_home_page, container, false);
        singleplayerBtn = (Button) homePage.findViewById(R.id.singleplayer2);
        singleplayerBtn.setOnClickListener(this);
        multiplayerBtn = (Button) homePage.findViewById(R.id.multiplayer2);
        multiplayerBtn.setOnClickListener(this);
        return homePage;
    }

    @Override
    public void onClick(View view) {

    }
}