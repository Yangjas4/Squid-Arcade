package com.example.squidarcade.Marbles.Singleplayer;

public interface Player {
    String getGuess();

    public void setPlayerRole(String newRole);
    public int getMarbles();
    public void generateGamble();
    public void loseMarbles(int marblesLost);
    public void addMarbles(int marblesGained);
    public void setGamble(int gamble);
    public String getPlayerRole();
    public void newGuess();
    public int getGamble();
}
