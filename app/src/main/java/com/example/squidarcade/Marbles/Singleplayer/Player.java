package com.example.squidarcade.Marbles.Singleplayer;

public interface Player {
    public void setPlayerRole(String newRole);
    public int getMarbles();
    public void setGamble();
    public void loseMarbles(int marblesLost);
    public void setGamble(int gamble);
    public String getPlayerRole();
}
