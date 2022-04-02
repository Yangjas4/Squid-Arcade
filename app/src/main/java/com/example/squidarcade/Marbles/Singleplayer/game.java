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
            openGuesserActivity();  //TODO: to be implemented with android studio
        } else if (human.getPlayerRole().equals("gambler")) {
            openGamblerActivity(); //TODO: to be implemented with android studio
        }
    }

    //after player guesses or gambles shows what the cpu decided and whether the player lost or won the turn
    public void turnResult(int gamble){
        checkWin();
        if (this.winner == null) {
            String turnResult;
            if (this.human.getPlayerRole().equals("guesser")) {
                cpu.setGamble(gamble);
                if ((human.getGuess().equals("even") && (cpu.getMarbles() % 2 == 0)) || (human.getGuess().equals("odd") && (cpu.getMarbles() % 2 != 0))) {
                    cpu.loseMarbles(gamble);
                    turnResult = String.format("Your guess was correct, CPU is holding %s marbles now.",cpu.getMarbles());
                } else{
                    cpu.addMarbles(gamble);
                    turnResult = String.format("Your guess was wrong, CPU is holding %s marbles now.",cpu.getMarbles());
                }
            }else{ /** this is the case when player gambles */
                human.setGamble(gamble);
                if ((cpu.getGuess().equals("even") && (human.getMarbles() % 2 == 0)) || (cpu.getGuess().equals("odd") && (human.getMarbles() % 2 != 0))) {
                    human.loseMarbles(gamble);
                    turnResult = String.format("CPU guessed correct, you are now holding %s marbles.",human.getMarbles());
                } else{
                    human.addMarbles(gamble);
                    turnResult = String.format("CPU guessed incorrectly, you are now holding %s marbles.",human.getMarbles());
                }
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
