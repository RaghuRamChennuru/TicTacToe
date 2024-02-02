package com.ram.Strategy;

import com.ram.Models.Board;
import com.ram.Models.Move;
import com.ram.Models.Player;

import java.util.HashMap;

public class ColumnWinningStrategy implements  GameWinningStrategy{

    private HashMap<Integer,HashMap<Character,Integer>> columnSymbolCount = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move)
    {

        int column  = move.getCell().getCol();

        char symbol = move.getPlayer().getPlayerSymbol();

        if(!columnSymbolCount.containsKey(column))
        {
            columnSymbolCount.put(column,new HashMap<>());
        }

        HashMap<Character,Integer> symbolMap = columnSymbolCount.get(column);

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
    public void handleUndo(Board board, Move move) {

        int col = move.getCell().getCol();

        Player lastPlayer = move.getPlayer();


        HashMap<Character,Integer> symbolMap = columnSymbolCount.get(col);

        int count = symbolMap.get(lastPlayer.getPlayerSymbol());

        symbolMap.put(lastPlayer.getPlayerSymbol(),count-1);
    }
}
