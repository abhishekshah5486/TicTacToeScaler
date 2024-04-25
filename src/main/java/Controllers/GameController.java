package Controllers;

import Exceptions.InvalidMoveException;
import Exceptions.SymbolRecurrenceConflictException;
import Models.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameController {

    public Game startGame(int dimension, List<Player> players) throws SymbolRecurrenceConflictException {
        // check if the two players have the same symbols or not
        // Throw some exception if two players have exactly the same symbol
        if (!validatePlayerSymbols(players)) {
            throw new SymbolRecurrenceConflictException("Symbol Conflict Exception");
        }
        return new Game(dimension, players);
    }

    public boolean validatePlayerSymbols(List<Player> players){
        Set<Character> symbolSet = new HashSet<>();
        for (int j=0; j<players.size(); j++){
            if (symbolSet.contains(players.get(j).getSymbol().getaChar())){
                return false;
            }
            symbolSet.add(players.get(j).getSymbol().getaChar());
        }
        return true;
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove(game);
    }
}
