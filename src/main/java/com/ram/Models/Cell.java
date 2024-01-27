package com.ram.Models;

import com.ram.Models.Types.CELL_STATE;

public class Cell
{
    private int col;
    private int row;

    private CELL_STATE cellState;

    private Player player;

    public Player getCellPlayer()
    {
        return this.player;
    }

    public CELL_STATE getCellState()
    {
        return this.cellState;
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
