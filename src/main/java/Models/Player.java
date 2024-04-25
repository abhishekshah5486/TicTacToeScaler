package Models;

import Exceptions.InvalidMoveException;

import java.util.Scanner;

public class Player {
    private String name;
    private PlayerType playerType;
    private Symbol symbol;
    private static Scanner read = new Scanner(System.in);

    public Player(String name, PlayerType playerType, Symbol symbol) {
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Move makeMove(Board board) throws InvalidMoveException {
        // Ask the user to enter valid row number to make a move
        System.out.println("Please enter a row number where you want to make a move : ");
        int row = read.nextInt();
        System.out.println("Please enter a column number where you want to make a move : ");
        int column = read.nextInt();

        return new Move(new Cell(row, column), this);
    }
}
