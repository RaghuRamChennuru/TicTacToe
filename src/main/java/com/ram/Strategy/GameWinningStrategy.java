package com.ram.Strategy;

import com.ram.Models.Board;
import com.ram.Models.Move;

public interface GameWinningStrategy
{
    boolean checkWinner(Board board, Move move);

    void handleUndo(Board board, Move move);


}
