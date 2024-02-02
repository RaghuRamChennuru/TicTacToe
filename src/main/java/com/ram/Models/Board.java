package com.ram.Models;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<List<Cell>> listOfCells;

    private int size;

    Board(int size)
    {
        this.size = size;
        listOfCells = new ArrayList<>();

        for(int i=0;i<size;i++)
        {
            listOfCells.add(new ArrayList<>());

         for(int j=0;j<size;j++)
            {
                listOfCells.get(i).add(new Cell(i,j));
            }
        }
    }


    public List<List<Cell>> getListOfCells()
    {
        return this.listOfCells;
    }

    public int getSize()
    {
        return size;
    }

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
