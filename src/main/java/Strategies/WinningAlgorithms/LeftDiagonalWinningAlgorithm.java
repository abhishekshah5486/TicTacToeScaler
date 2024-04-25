package Strategies.WinningAlgorithms;

import Models.Board;
import Models.Move;

import java.util.HashMap;

public class LeftDiagonalWinningAlgorithm {
    HashMap<Character, Integer> leftDiagonalMap = new HashMap<>();

    public boolean checkWinningAlgorithm(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character aChar = move.getPlayer().getSymbol().getaChar();
        if ( (row + col) == board.getSize()-1) {
            if (!leftDiagonalMap.containsKey(aChar)){
                leftDiagonalMap.put(aChar, 1);
            }
            else {
                leftDiagonalMap.put(aChar, leftDiagonalMap.get(aChar) + 1);
            }
            return leftDiagonalMap.get(aChar) == board.getSize();
        }
        return false;
    }
}
