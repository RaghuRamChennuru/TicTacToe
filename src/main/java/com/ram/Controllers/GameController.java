package com.ram.Controllers;

import com.ram.Models.Game;
import com.ram.Models.Player;
import com.ram.Models.Types.GAME_STATE;
import com.ram.Strategy.GameWinningStrategy;

import java.util.List;

public class GameController
{
    public void printBoard(Game game)
    {
        game.printBoard();
    }

    public Player getWinner(Game game)
    {
        return game.getWinner();
    }

    public void makeMove(Game game)
    {
        game.makeMove();
    }

    public void undo(Game game)
    {
        game.undo();
    }

    public GAME_STATE getGameState(Game game)
    {
        return game.getGameState();
    }

    public Game startGame(int boardSize, List<Player> players, List<GameWinningStrategy> winningStrategyList)
    {
        return Game.getBuilder().setBoardSize(boardSize).setPlayerslist(players).setWinningStrategies(winningStrategyList).buildGame();
    }
}
