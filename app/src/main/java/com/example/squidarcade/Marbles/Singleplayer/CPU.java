package com.example.squidarcade.Marbles.Singleplayer;

import java.util.Random;

public class CPU implements Player {
    private int marbles;
    private Boolean guess;
    private String playerRole;


    public CPU(){
        this.marbles = 10;
    }

    //Generates random number from 1-3, unless there are less than 3 marbles.
    @Override
    public void setGamble(){
        Random randomNumber = new Random();
        if(this.marbles>2){
            int x = randomNumber.nextInt(3)+1;
        }else{
            int x = randomNumber.nextInt(this.marbles)+1;    //upper bound becomes # of marbles
        }
    }

    @Override
    public void loseMarbles(int marblesLost) {
        this.marbles -= marblesLost;
    }

    @Override
    public void setGamble(int gamble) {
    }

    @Override
    public String getPlayerRole() {
        return this.playerRole;
    }

    @Override
    public void setPlayerRole(String newRole) {
        this.playerRole = newRole;
    }

    //sets a random Boolean value to guess for even or odd
    public void setGuess(){
        Random randomBoolean = new Random();
        this.guess = randomBoolean.nextBoolean();
    }

    public Boolean getGuess(){
        return this.guess;
    }

    public int getMarbles(){
        return this.marbles;
    }

}
