package com.example.squidarcade.Marbles;

import java.util.Random;

public class CPU {
    private int marbles;
    private int gamble;
    private Boolean guess;

    public CPU(){
        this.marbles = 10;
    }

    //Generates random number from 1-3, unless there are less than 3 marbles.
    public void setGamble(){
        Random randomNumber = new Random();
        if(this.marbles>2){
            int x = randomNumber.nextInt(3)+1;
        }else{
            int x = randomNumber.nextInt(this.marbles)+1;    //upper bound becomes # of marbles
        }
    }

    //sets a random Boolean value to guess for even or odd
    public void setGuess(){
        Random randomBoolean = new Random();
        this.guess = randomBoolean.nextBoolean();
    }

    public int getMarbles(){
        return this.marbles;
    }

}
