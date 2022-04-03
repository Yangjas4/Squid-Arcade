package com.example.squidarcade;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

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
        // Inflate the layout for this fragment
        View homePage =  inflater.inflate(R.layout.fragment_home_page, container, false);
        singleplayerBtn = (Button) homePage.findViewById(R.id.marblesButton);
        singleplayerBtn.setOnClickListener(this);
        multiplayerBtn = (Button) homePage.findViewById(R.id.rlglButton);
        multiplayerBtn.setOnClickListener(this);
        return homePage;
    }

    public void onClick(View view){
        if (view == ) {
            NavHostFragment.findNavController(fragment_marbles_main.this).navigate(R.id.action_fragment_home_page_to_fragment_marbles_main);
        } else {
            //TODO: implement rlgl fragments later
            NavHostFragment.findNavController(fragment_marbles_main.this).navigate(R.id.action_fragment_home_page_to_marbles_singleplayer_gamble);
        }
    }

}