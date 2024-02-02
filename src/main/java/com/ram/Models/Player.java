package com.ram.Models;

import com.ram.Models.Types.PLAYER_TYPE;
import java.util.Scanner;

public class Player
{
    private int id;
    private String name;
    private char symbol;

    private Scanner sc;

    private PLAYER_TYPE playerType;

    public Player(int id, String name,char symbol,PLAYER_TYPE playerType,Scanner scanner)
    {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.sc = scanner;
    }

    public String getPlayerName()
    {
      return   this.name;
    }

    public char getPlayerSymbol()
    {
        return this.symbol;
    }

    public Move makeMove(Board board)
    {
        System.out.println("Please Enter the Row and Column To Make a move");
        int row = sc.nextInt();
        int column  =  sc.nextInt();

        Cell correspondingCell = board.getListOfCells().get(row).get(column);


        return new Move(this,correspondingCell);
    }
}
