package com.ram;

import com.ram.Controllers.GameController;
import com.ram.Models.Game;
import com.ram.Models.Player;
import com.ram.Models.Types.GAME_STATE;
import com.ram.Models.Types.PLAYER_TYPE;
import com.ram.Strategy.ColumnWinningStrategy;
import com.ram.Strategy.GameWinningStrategy;
import com.ram.Strategy.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(" Welcome To Tic Tac Toe");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number Of Players");

        int players = sc.nextInt();

        List<Player> listOfPlayers= new ArrayList<>();

        for(int i=0;i<players;i++)
        {
            System.out.println("Enter Player "+i+" Name");
            String name = sc.next();
            System.out.println("Enter Player "+i+" Symbol");
            char symbol = sc.next().charAt(0);

            listOfPlayers.add(new Player(i,name,symbol, PLAYER_TYPE.HUMAN,sc));
        }

        List<GameWinningStrategy> winStrategy = new ArrayList<>();

        winStrategy.add(new ColumnWinningStrategy());
        winStrategy.add(new RowWinningStrategy());

        GameController controller = new GameController();

        Game game = controller.startGame(players+1,listOfPlayers,winStrategy);

        while(controller.getGameState(game).equals(GAME_STATE.InProgress))
        {
                controller.printBoard(game);

                System.out.println("Do You Want To Undo - Y/N");
                char  undo_resp= sc.next().charAt(0);

                if(undo_resp == 'Y')
                {
                    controller.undo(game);
                    continue;
                }

              controller.makeMove(game);

        }

        if(controller.getGameState(game).equals(GAME_STATE.Draw))
        {
            System.out.println("Game is Draw");
        }
        else
        {
            System.out.println("Game is completed , Winner of the game : "+ controller.getWinner(game).getPlayerName());
        }


    }
}