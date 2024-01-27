package com.ram;

import com.ram.Controllers.GameController;
import com.ram.Models.Game;
import com.ram.Models.Player;
import com.ram.Models.Types.GAME_STATE;
import com.ram.Models.Types.PLAYER_TYPE;

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

        for(int i=1;i<=players;i++)
        {
            System.out.println("Enter Player "+i+" Details");
            String name = sc.next();
            char symbol = sc.next().charAt(1);

            listOfPlayers.add(new Player(i,name,symbol, PLAYER_TYPE.HUMAN));
        }

        GameController controller = new GameController();

        Game game = controller.startGame();

        while(controller.getGameState(game).equals(GAME_STATE.InProgress))
        {
                controller.printBoard(game);

                System.out.println("Do You Want To Undo - Y/N");
                char  undo_resp= sc.next().charAt(1);

                if(undo_resp == 'Y')
                {
                    controller.undo(game);
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