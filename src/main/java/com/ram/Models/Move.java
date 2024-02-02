package com.ram.Models;

import java.util.List;

public class Move
{
    private Player player;

    private Cell cell;

    Move(Player player,Cell cell)
    {
        this.player = player;
        this.cell = cell;

    }

    public Cell getCell()
    {
        return this.cell;
    }

    public Player getPlayer()
    {
        return this.player;
    }
}
