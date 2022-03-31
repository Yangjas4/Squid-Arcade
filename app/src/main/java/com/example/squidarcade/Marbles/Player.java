package com.example.squidarcade.Marbles;

public class Player {
    private int marbles;
    private int gamble;

    public Player(){
        this.marbles = 10;
    }

    public int getMarbles(){
        return this.marbles;
    }

    public void setGamble(int gamble){
        this.gamble = gamble;
    }

    //Have Gamble be a boolean value. True for even and false for odd.
    //So even button will make gamble True and odd will make it False
    public void changeMarbles(Boolean gamble){
        if(gamble){
            if(marbles % 2 == 0){
                this.marbles = this.marbles - this.gamble;
            }else{
                this.marbles = this.marbles + this.gamble;
            }
        }
    }


}
