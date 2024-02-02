package com.ram.Strategy;

import com.ram.Models.Board;
import com.ram.Models.Move;
import com.ram.Models.Player;

import java.util.HashMap;

public class RowWinningStrategy implements GameWinningStrategy
{
    private HashMap<Integer,HashMap<Character,Integer>> rowsSymbolCount = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move)
    {
        int row = move.getCell().getRow();
        //int column  = move.getCell().getCol();

        char symbol = move.getPlayer().getPlayerSymbol();

        if(!rowsSymbolCount.containsKey(row))
        {
            rowsSymbolCount.put(row,new HashMap<>());
        }

        HashMap<Character,Integer> symbolMap = rowsSymbolCount.get(row);

        if(!symbolMap.containsKey(symbol))
        {
            symbolMap.put(symbol,0);
        }

        symbolMap.put(symbol,symbolMap.get(symbol)+1);

        if(symbolMap.get(symbol).equals(board.getSize()))
        {
            return true;
        }

        return false;

    }

    @Override
    public void handleUndo(Board board, Move move)
    {
        int row = move.getCell().getRow();

        Player lastPlayer = move.getPlayer();


        HashMap<Character,Integer> symbolMap = rowsSymbolCount.get(row);

        int count = symbolMap.get(lastPlayer.getPlayerSymbol());

        symbolMap.put(lastPlayer.getPlayerSymbol(),count-1);
    }
}
