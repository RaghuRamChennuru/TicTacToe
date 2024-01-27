package com.ram.Models;

import com.ram.Models.Types.GAME_STATE;

import java.util.List;



public class Game
{
    private Board board;
    private List<Player> players;

    private GAME_STATE gameState;

    private int nextPlayerIndex;

    private List<Move> movesList;

    private Player winner;


    public GAME_STATE getGameState()
    {
        return gameState;
    }

    public void printBoard()
    {
       this.board.printBoard();
    }
}
