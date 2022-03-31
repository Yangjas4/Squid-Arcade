package com.example.squidarcade.Marbles.Singleplayer;

public class newGame {

    private Player winner;
    private Player human;
    private Player cpu;

    public newGame() {
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

}
