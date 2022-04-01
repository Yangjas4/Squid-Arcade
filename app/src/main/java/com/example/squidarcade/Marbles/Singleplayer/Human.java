package com.example.squidarcade.Marbles.Singleplayer;

public class Human implements Player{
    private int marbles;
    private int gamble;
    private String playerRole;
    private String guess;

    public Human(){
        this.marbles = 10;
    }

    public int getMarbles(){
        return this.marbles;
    }

    //null
    @Override
    public void generateGamble() {
        return 0;
    }

    @Override
    public void loseMarbles(int marblesLost) {
        this.marbles -= marblesLost;
    }

    @Override
    public void setGamble(int gamble){
        this.gamble = gamble;
    }

    //Have Gamble be a boolean value. True for even and false for odd.
    //So even button will make gamble True and odd will make it False
    /*public void changeMarbles(Boolean gamble){
        if(gamble){
            if(marbles % 2 == 0){
                this.marbles = this.marbles - this.gamble;
            }else{
                this.marbles = this.marbles + this.gamble;
            }
        }
    }*/
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
