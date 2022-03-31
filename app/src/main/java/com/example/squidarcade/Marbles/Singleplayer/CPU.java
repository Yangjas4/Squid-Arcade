package com.example.squidarcade.Marbles.Singleplayer;

import java.util.Random;

public class CPU implements Player {
    private int marbles;
    private String playerRole;


    public CPU(){
        this.marbles = 10;
    }

    //Generates random number from 1-3, unless there are less than 3 marbles.
    @Override
    public int generateGamble(){
        Random randomNumber = new Random();
        int gamble;
        if(this.marbles>2){
            gamble = randomNumber.nextInt(3)+1;
        }else{
            gamble = randomNumber.nextInt(this.marbles)+1;    //upper bound becomes # of marbles
        }
        return gamble;
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
    public String getGuess(){
        String guess;
        Random randomBoolean = new Random();
        boolean evenOdd = randomBoolean.nextBoolean();
        if (evenOdd == true) {
             guess = "even";
        } else {
            guess = "false";
        }
    }


    public int getMarbles(){
        return this.marbles;
    }

}
