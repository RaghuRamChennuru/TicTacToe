package com.ram.Models;

import com.ram.Models.Types.CELL_STATE;

public class Cell
{
    private int col;
    private int row;

    private CELL_STATE cellState;

    private Player player;

    Cell(int row,int col)
    {
        this.col = col;
        this.row = row;
        this.cellState = CELL_STATE.EMPTY; // Initially Empty

    }

    public int getRow()
    {
        return this.row;
    }

    public int getCol()
    {
        return this.col;
    }

    public Player getCellPlayer()
    {
        return this.player;
    }

    public CELL_STATE getCellState()
    {
        return this.cellState;
    }

    public void setCellState(CELL_STATE cellSate)
    {
        this.cellState = cellSate;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public void printCell()
    {
        if(this.cellState.equals(CELL_STATE.EMPTY))
        {
            System.out.print("| - |");
        }
        else if(this.cellState.equals(CELL_STATE.FILLED))
        {
            System.out.print("| "+player.getPlayerSymbol()+" |");
        }
        else
        {
         System.out.print("| X |");
        }
    }
}
