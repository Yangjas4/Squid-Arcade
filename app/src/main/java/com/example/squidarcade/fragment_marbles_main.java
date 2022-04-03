package com.example.squidarcade;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.squidarcade.Marbles.Singleplayer.gameSingleplayer;

public class fragment_marbles_main extends Fragment implements View.OnClickListener {
    Button singleplayerBtn;
    Button multiplayerBtn;
    private marblesViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View homePage =  inflater.inflate(R.layout.fragment_marbles_main, container, false);
        singleplayerBtn = (Button) homePage.findViewById(R.id.singleplayer2);
        singleplayerBtn.setOnClickListener(this);
        multiplayerBtn = (Button) homePage.findViewById(R.id.multiplayer2);
        multiplayerBtn.setOnClickListener(this);
        return homePage;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(marblesViewModel.class);
    }

    @Override
    public void onClick(View view) {

        //singleplayer implementation
        if (view == singleplayerBtn) {

            gameSingleplayer currentGame = new gameSingleplayer();
            currentGame.assignRole();
            viewModel.setGame(currentGame);

            if (currentGame.getHuman().getPlayerRole().equals("guesser")) {
                NavHostFragment.findNavController(fragment_marbles_main.this).navigate(R.id.action_fragment_marbles_main_to_marbles_singleplayer_evenodd);

            } else if (currentGame.getHuman().getPlayerRole().equals("gambler")) {
                NavHostFragment.findNavController(fragment_marbles_main.this).navigate(R.id.action_fragment_marbles_main_to_marbles_singleplayer_gamble);
            }

        //multiplayer implementation
        } else if (view == multiplayerBtn){

        }
    }
}