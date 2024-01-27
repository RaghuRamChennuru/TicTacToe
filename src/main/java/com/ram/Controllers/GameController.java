package com.ram.Controllers;

import com.ram.Models.Game;
import com.ram.Models.Player;
import com.ram.Models.Types.GAME_STATE;

public class GameController
{
    public void printBoard(Game game)
    {
        game.printBoard();
    }

    public Player getWinner(Game game)
    {
        return null;
    }

    public void makeMove(Game game)
    {

    }

    public void undo(Game game)
    {

    }

    public GAME_STATE getGameState(Game game)
    {
        return game.getGameState();
    }

    public Game startGame()
    {
        return new Game();
    }
}
