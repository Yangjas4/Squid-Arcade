package com.example.squidarcade.Multiplayer;

import com.example.squidarcade.Marbles.Singleplayer.CPU;
import com.example.squidarcade.Marbles.Singleplayer.Human;
import com.example.squidarcade.Marbles.Singleplayer.Player;

import java.util.Random;

public class gameMultiplayer {

    private HumanMultiplayer winner;
    private HumanMultiplayer player1;
    private HumanMultiplayer player2;

    public gameMultiplayer() {
        this.player1 = new HumanMultiplayer();
        this.player2 = new HumanMultiplayer();
    }

    public HumanMultiplayer getWinner(){
        return this.winner;
    }

    public void checkWin() {
        if (this.player1.getMarbles() == 0) {
            this.winner = player2;
        } else if (this.player2.getMarbles() == 0) {
            this.winner = player1;
        }
    }

//    public void nextTurn() {
//        switchRole();
//        if (human.getPlayerRole().equals("guesser")){
//            openGuesserActivity();  //TODO: to be implemented with android studio
//        } else if (human.getPlayerRole().equals("gambler")) {
//            openGamblerActivity(); //TODO: to be implemented with android studio
//        }
//    }

    //after player guesses or gambles shows what the cpu decided and whether the player lost or won the turn
    public void turnResult(int gamble){
        checkWin();
        if (this.winner == null) {
            String turnResult;
            if (this.player1.getPlayerRole().equals("guesser")) {
                player2.setGamble(gamble);
                if ((player1.getGuess().equals("even") && (player2.getMarbles() % 2 == 0)) || (player1.getGuess().equals("odd") && (player2.getMarbles() % 2 != 0))) {
                    player2.loseMarbles(gamble);
                    turnResult = String.format("Player1 guessed correctly, player2 is holding %s marbles now.", player2.getMarbles());
                } else{
                    player2.addMarbles(gamble);
                    turnResult = String.format("Player1 guessed incorrectly, player2 is holding %s marbles now.", player2.getMarbles());
                }
            }else{ /** this is the case when player gambles */
                player1.setGamble(gamble);
                if ((player2.getGuess().equals("even") && (player1.getMarbles() % 2 == 0)) || (player2.getGuess().equals("odd") && (player1.getMarbles() % 2 != 0))) {
                    player1.loseMarbles(gamble);
                    turnResult = String.format("Player2 guessed correctly, player1 is holding %s marbles now.", player1.getMarbles());
                } else{
                    player1.addMarbles(gamble);
                    turnResult = String.format("Player2 guessed incorrectly, player1 is holding %s marbles now.", player1.getMarbles());
                }
            }
        }
    }

    public void switchRole(){
        if (player1.getPlayerRole().equals("guesser") && player2.getPlayerRole().equals("gambler")) {
            player1.setPlayerRole("gambler");
            player2.setPlayerRole("guesser");
        } else if (player1.getPlayerRole().equals("gambler") && player2.getPlayerRole().equals("guesser")) {
            player1.setPlayerRole("guesser");
            player2.setPlayerRole("gambler");
        } else {
            throw new IllegalArgumentException("playerRole of player1: " + player1.getPlayerRole() + " and player2: " + player2.getPlayerRole() + " are invalid");
        }
    }

    public HumanMultiplayer getPlayer1(){
        return this.player1;
    }

    public HumanMultiplayer getPlayer2(){
        return this.player2;
    }
    
    public void assignRole(){
        Random zeroOrOne = new Random();
        int x = zeroOrOne.nextInt(2);
        if (x == 0) {
            player1.setPlayerRole("guesser");
            player2.setPlayerRole("gambler");
        } else {
            player1.setPlayerRole("gambler");
            player2.setPlayerRole("guesser");
        }
    }

}
