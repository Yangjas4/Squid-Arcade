package com.example.squidarcade;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.squidarcade.Marbles.Singleplayer.gameSingleplayer;


public class marbles_singleplayer_gamble extends Fragment implements View.OnClickListener {
    Button submitBtn;
    EditText gambleInput;
    int gamble;
    marblesViewModel viewModel;
    gameSingleplayer currentGame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homePage =  inflater.inflate(R.layout.fragment_marbles_singleplayer_gamble, container, false);
        submitBtn = (Button) homePage.findViewById(R.id.submitGamble);
        submitBtn.setOnClickListener(this);
        gambleInput = (EditText) homePage.findViewById(R.id.gambleAmount);
        return homePage;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(marblesViewModel.class);
        viewModel.getGame().observe(this, item -> {
            currentGame = item;
        });
        currentGame.getCpu().getGuess();
    }

    @Override
    public void onClick(View view) {

        currentGame.switchRole();
        gamble = Integer.valueOf(gambleInput.getText().toString());

        if (gamble < 1 || gamble > currentGame.getHuman().getMarbles()) {
            Toast.makeText(getActivity(),"invalid gamble, please try again", Toast.LENGTH_LONG);
        }
    }


}