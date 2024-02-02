package com.ram.Models;

import com.ram.Models.Types.CELL_STATE;
import com.ram.Models.Types.GAME_STATE;
import com.ram.Strategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;



public class Game
{
    private Board board;
    private List<Player> players;

    private GAME_STATE gameState;

    private int nextPlayerIndex;

    private List<Move> movesList;

    private Player winner;

    private List<GameWinningStrategy> winningStrategies;


    private Game(Board board,List<Player> players,List<GameWinningStrategy> winningStrategies)
    {
        this.board = board;
        this.players = players;
        this.gameState = GAME_STATE.InProgress; // On Start , default
        this.winningStrategies = winningStrategies;
        this.nextPlayerIndex = 0; // Initial
        this.movesList = new ArrayList<>();
    }

    public Player getWinner()
    {
        return this.winner;
    }

    public void makeMove()
    {
        /*
        * 0. Get The Current Player
        * 1. Take Inputs From User and create a move
        * 2. Validate the move
        * 3. Insert into movesList
        * 4. Check Winner
        *
        * */

        Player currenPlayer = players.get(nextPlayerIndex);

        System.out.println("Current Player : " + currenPlayer.getPlayerName());

        Move currentmove = currenPlayer.makeMove(this.board);

        if(!validateMove(currentmove))
        {
            throw  new RuntimeException("Invalid Move");
        }

        int row  = currentmove.getCell().getRow();
        int column =  currentmove.getCell().getCol();


        Cell cellTobeUpdated = board.getListOfCells().get(row).get(column);
        cellTobeUpdated.setCellState(CELL_STATE.FILLED);
        cellTobeUpdated.setPlayer(currenPlayer);

        movesList.add(currentmove);

        if(checkWinner(currentmove,board)){
            gameState = GAME_STATE.End;
            winner = currentmove.getPlayer();
        }else if(movesList.size() == board.getSize()*board.getSize()){
            gameState = GAME_STATE.Draw;
        }

        nextPlayerIndex++;
        nextPlayerIndex = nextPlayerIndex%players.size();

    }

    public boolean validateMove(Move move)
    {
        int row  = move.getCell().getRow();
        int col = move.getCell().getCol();

        int size = this.board.getSize();

        if(row < 0 || row >= size)
        {
            return false;
        }

        if(col < 0 || col >= size)
        {
            return false;
        }

        if(this.board.getListOfCells().get(row).get(col).getCellState().equals(CELL_STATE.EMPTY))
        {
            return true;
        }

        return false;
    }

    public boolean checkWinner(Move move, Board board)
    {
        for(GameWinningStrategy st : winningStrategies){
            if(st.checkWinner(board,move)){
                return true;
            }
        }
        return false;
    }


    public void undo()
    {
        /*
        * Check Moves Count
        * Get Last Move
        * Remove Last Move
        *
        * Update Last Moved Cell State
        * Remove Column and Row Mappings
        * */

        if(this.movesList.isEmpty())
        {
            throw new RuntimeException("No Moves Done Till Now");
        }

        Move LastMove  = this.movesList.get(this.movesList.size() - 1);
        this.movesList.remove(LastMove);

        Cell LastCell = LastMove.getCell();
        LastCell.setCellState(CELL_STATE.EMPTY);
        LastCell.setPlayer(null);

        for(GameWinningStrategy strategy:winningStrategies)
        {
            strategy.handleUndo(this.board,LastMove);
        }

        nextPlayerIndex--;
        nextPlayerIndex = (nextPlayerIndex + players.size()) % players.size();



    }

    public GAME_STATE getGameState()
    {
        return gameState;
    }

    public void printBoard()
    {
       this.board.printBoard();
    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private List<Player> Playerslist;
        private int boardSize;

        private List<GameWinningStrategy> winningStrategiesBuilder;

        public Builder()
        {
            this.Playerslist = new ArrayList<>();
            this.boardSize = 0;
            this.winningStrategiesBuilder = new ArrayList<>();
        }

        public Builder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public Builder setPlayerslist(List<Player> playerslist) {
            Playerslist = playerslist;
            return this;
        }

        public Builder setWinningStrategies(List<GameWinningStrategy> strategy)
        {
            this.winningStrategiesBuilder = strategy;
            return this;
        }

        public Game buildGame()
        {
          return  new Game(new Board(this.boardSize),this.Playerslist,this.winningStrategiesBuilder);
        }


    }



}
