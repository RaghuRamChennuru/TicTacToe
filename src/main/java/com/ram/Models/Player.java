package com.ram.Models;

import com.ram.Models.Types.PLAYER_TYPE;

public class Player
{
    private int id;
    private String name;
    private char symbol;

    private PLAYER_TYPE playerType;

    public Player(int id, String name,char symbol,PLAYER_TYPE playerType)
    {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getPlayerName()
    {
      return   this.name;
    }

    public char getPlayerSymbol()
    {
        return this.symbol;
    }
}
