import Controllers.GameController;
import Exceptions.InvalidMoveException;
import Exceptions.SymbolRecurrenceConflictException;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SymbolRecurrenceConflictException, InvalidMoveException {
        Scanner read = new Scanner(System.in);

        GameController gameController = new GameController();
        System.out.print("Please enter the game dimension : ");
        int dimension = read.nextInt();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Abhishek", PlayerType.HUMAN, new Symbol('X')));
        players.add(new Bot("Jimmy", PlayerType.BOT, new Symbol('X'), BotDifficultyLevel.EASY));

        Game game = gameController.startGame(dimension, players);

        while (gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.printBoard(game);
            gameController.makeMove(game);
            System.out.println();
        }
        if (gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game Draw. There are no winners.");
        }
        else if (gameController.checkState(game).equals(GameState.FINISHED)){
            System.out.println("Game over!");
            System.out.println(game.getPlayers().get(game.getCurrentPlayerMoveIndex()).getName() + " has won the game.");
        }
    }
}
