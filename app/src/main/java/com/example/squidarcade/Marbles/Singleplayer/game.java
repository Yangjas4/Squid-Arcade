package com.example.squidarcade.Marbles.Singleplayer;

import java.util.Random;

public class game {

    private Player winner;
    private Player human;
    private Player cpu;

    public game() {
        this.human = new Human();
        this.cpu = new CPU();
    }

    public Player getWinner(){
        return this.winner;
    }

    public void checkWin() {
        if (this.human.getMarbles() == 0) {
            this.winner = cpu;
        } else if (this.cpu.getMarbles() == 0) {
            this.winner = human;
        }
    }

    public void nextTurn() {
        switchRole();
        if (human.getPlayerRole().equals("guesser")){
            openGuesserActivity();  //to be implemented with android studio
        } else if (human.getPlayerRole().equals("gambler")) {
            openGamblerActivity(); //to be implemented with android studio
        }
    }

    //after player guesses or gambles shows what the cpu decided and whether the player lost or won the turn
    public void turnResult(){
        checkWin();
        if (this.winner == null) {
            String turnResult;
            if (this.human.getPlayerRole().equals("guesser")) {
                if (human.getGuess().equals("even") &&)
                    turnResult = "CPU is holding " + cpu.getMarbles() + " marbles. Your guess was";
            }
        }
    }

    public void switchRole(){
        if (human.getPlayerRole().equals("guesser") && cpu.getPlayerRole().equals("gambler")) {
            human.setPlayerRole("gambler");
            cpu.setPlayerRole("guesser");
        } else if (human.getPlayerRole().equals("gambler") && cpu.getPlayerRole().equals("guesser")) {
            human.setPlayerRole("guesser");
            cpu.setPlayerRole("gambler");
        } else {
            throw new IllegalArgumentException("playerRole of human: " + human.getPlayerRole() + " and cpu: " + cpu.getPlayerRole() + " are invalid");
        }
    }

    public Player getHuman(){
        return this.human;
    }

    public Player getCpu(){
        return this.cpu;
    }
    
    public void assignRole(){
        Random zeroOrOne = new Random();
        int x = zeroOrOne.nextInt(2);
        if (x == 0) {
            human.setPlayerRole("guesser");
            cpu.setPlayerRole("gambler");
        } else {
            human.setPlayerRole("gambler");
            cpu.setPlayerRole("guesser");
        }
    }

}
