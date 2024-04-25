package Models;

import Exceptions.InvalidMoveException;
import Strategies.WinningAlgorithms.ColumnWinningAlgorithms;
import Strategies.WinningAlgorithms.LeftDiagonalWinningAlgorithm;
import Strategies.WinningAlgorithms.RightDiagonalWinningAlgorithm;
import Strategies.WinningAlgorithms.RowWinningAlgorithms;

import java.util.*;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int currentPlayerMoveIndex;
    private static ColumnWinningAlgorithms columnWinningAlgorithms = new ColumnWinningAlgorithms();
    private static RowWinningAlgorithms rowWinningAlgorithms = new RowWinningAlgorithms();
    private static RightDiagonalWinningAlgorithm rightDiagonalWinningAlgorithm = new RightDiagonalWinningAlgorithm();
    private static LeftDiagonalWinningAlgorithm leftDiagonalWinningAlgorithm = new LeftDiagonalWinningAlgorithm();

    public Game(int dimension, List<Player> players){
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.winner = null;
        this.players = players;
        this.gameState = GameState.IN_PROGRESS;
        this.currentPlayerMoveIndex = 0;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getCurrentPlayerMoveIndex() {
        return currentPlayerMoveIndex;
    }

    public void setCurrentPlayerMoveIndex(int currentPlayerMoveIndex) {
        this.currentPlayerMoveIndex = currentPlayerMoveIndex;
    }

    public void printBoard(){
        this.board.printBoard();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        Player currentPlayer = game.getPlayers().get(currentPlayerMoveIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn.");
        Move move = currentPlayer.makeMove(game.getBoard());

        if (!validateMove(move)){
            throw new InvalidMoveException("Invalid move");
        }
        int row = move.getCell().getRow();
        int column = move.getCell().getCol();
        Cell cellToChange = board.getBoard().get(row).get(column);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setPlayer(currentPlayer);

        Move finalMove = new Move(cellToChange, currentPlayer);
        moves.add(finalMove);

        // Check if there is any winning situation after the current move
        boolean isWinner = columnWinningAlgorithms.checkWinningAlgorithm(board, finalMove) ||
                           rowWinningAlgorithms.checkWinningAlgorithm(board, finalMove) ||
                           leftDiagonalWinningAlgorithm.checkWinningAlgorithm(board, finalMove) ||
                           rightDiagonalWinningAlgorithm.checkWinningAlgorithm(board, finalMove);

        if (isWinner){
            this.winner = currentPlayer;
            this.gameState = GameState.FINISHED;
            return;
        }
        // Check if the match is in a draw state after this move
        if (moves.size() == board.getSize() * board.getSize()){
            this.gameState = GameState.DRAW;
            return;
        }
        this.currentPlayerMoveIndex = (currentPlayerMoveIndex + 1)%players.size();
    }

    public boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int column = move.getCell().getCol();

        if (row < 0 || row == board.getSize()) {
            return false;
        }
        if (column < 0 || column == board.getSize()) {
            return false;
        }
        return board.getBoard().get(row).get(column).getCellState().equals(CellState.EMPTY);
    }
}
