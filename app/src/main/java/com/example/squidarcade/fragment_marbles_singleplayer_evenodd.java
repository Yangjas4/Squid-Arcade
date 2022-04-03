package com.example.squidarcade;

import android.content.Intent;
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

public class fragment_marbles_singleplayer_evenodd extends Fragment implements View.OnClickListener{
Button even;
Button odd;
marblesViewModel viewModel;
gameSingleplayer currentGame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homePage =  inflater.inflate(R.layout.fragment_marbles_singleplayer_evenodd, container, false);
        even = (Button) homePage.findViewById(R.id.evenGuess);
        even.setOnClickListener(this);
        odd = (Button) homePage.findViewById(R.id.oddGuess);
        odd.setOnClickListener(this);
        return homePage;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(marblesViewModel.class);
        viewModel.getGame().observe(this, item -> {
            currentGame = item;
        });
        currentGame.getCpu().generateGamble();
    }


    @Override
    public void onClick(View view) {
        currentGame.checkWin();

        if (currentGame.getWinner() == null) {
            currentGame.switchRole();

            if (view == even && currentGame.getCpu().getGamble() % 2 == 0) {
                currentGame.getCpu().loseMarbles(currentGame.getCpu().getGamble());
                currentGame.getHuman().addMarbles(currentGame.getCpu().getGamble());
                NavHostFragment.findNavController(fragment_marbles_singleplayer_evenodd.this).navigate(R.id. action_marbles_singleplayer_evenodd_to_marbles_singleplayer_results);

            } else if (view == even && currentGame.getCpu().getGamble() % 2 != 0) {
                currentGame.getCpu().addMarbles(currentGame.getCpu().getGamble());
                currentGame.getHuman().loseMarbles(currentGame.getCpu().getGamble());
                NavHostFragment.findNavController(fragment_marbles_singleplayer_evenodd.this).navigate(R.id. action_marbles_singleplayer_evenodd_to_marbles_singleplayer_results);

            } else if (view == odd && currentGame.getCpu().getGamble() % 2 == 0) {
                currentGame.getCpu().addMarbles(currentGame.getCpu().getGamble());
                currentGame.getHuman().loseMarbles(currentGame.getCpu().getGamble());
                NavHostFragment.findNavController(fragment_marbles_singleplayer_evenodd.this).navigate(R.id. action_marbles_singleplayer_evenodd_to_marbles_singleplayer_results);

            } else if (view == odd && currentGame.getCpu().getGamble() % 2 != 0) {
                currentGame.getCpu().loseMarbles(currentGame.getCpu().getGamble());
                currentGame.getHuman().addMarbles(currentGame.getCpu().getGamble());
                NavHostFragment.findNavController(fragment_marbles_singleplayer_evenodd.this).navigate(R.id. action_marbles_singleplayer_evenodd_to_marbles_singleplayer_results);

            }

        }







    }
}