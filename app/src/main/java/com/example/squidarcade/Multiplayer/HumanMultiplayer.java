package com.example.squidarcade.Multiplayer;

import com.example.squidarcade.Marbles.Singleplayer.Player;

public class HumanMultiplayer implements Player {
    private int marbles;
    private int gamble;
    private String playerRole;
    private String guess;

    public HumanMultiplayer(){
        this.marbles = 10;
    }

    public int getMarbles(){
        return this.marbles;
    }

    //null
    @Override
    public void generateGamble() {
    }

    @Override
    public void loseMarbles(int marblesLost) {
        this.marbles -= marblesLost;
    }

    @Override
    public void addMarbles(int marblesGained) {
        this.marbles += marblesGained;
    }

    @Override
    public void setGamble(int gamble){
        this.gamble = gamble;
    }


    public String getPlayerRole(){
        return this.playerRole;
    }

    @Override
    public void newGuess() {
    }

    @Override
    public int getGamble() {
        return 0;
    }

    @Override
    public String getGuess() {
        return this.guess;
    }


    public void setPlayerRole(String newRole){
        this.playerRole = newRole;
    }
}
