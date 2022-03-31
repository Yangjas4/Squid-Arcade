package com.example.squidarcade.Marbles.Singleplayer;

public interface Player {
    public void setPlayerRole(String newRole);
    public int getMarbles();
    public int generateGamble();
    public void loseMarbles(int marblesLost);
    public void setGamble(int gamble);
    public String getPlayerRole();
    public String getGuess();
}
