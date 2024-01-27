package com.ram.Models;

import java.util.List;

public class Board
{
    private List<List<Cell>> listOfCells;

    private int size;

    public void printBoard()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                listOfCells.get(i).get(j).printCell();
            }

            System.out.println();
        }
    }
}
