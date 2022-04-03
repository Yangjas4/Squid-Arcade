package com.example.squidarcade;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.squidarcade.Marbles.Singleplayer.gameSingleplayer;

public class marblesViewModel extends ViewModel {
    private MutableLiveData<gameSingleplayer> currentGame = new MutableLiveData<>();

    public void setGame(gameSingleplayer input){
        currentGame.setValue(input);
    }

    public LiveData<gameSingleplayer> getGame(){
        return currentGame;
    }

}
