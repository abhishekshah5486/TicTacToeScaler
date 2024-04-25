package Strategies.WinningAlgorithms;

import Models.Board;
import Models.Move;

import java.util.HashMap;

public class RightDiagonalWinningAlgorithm {
    HashMap<Character, Integer> rightDiagonalMap = new HashMap<>(); // \\\\\\\\\\\\\

    public boolean checkWinningAlgorithm(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character aChar = move.getPlayer().getSymbol().getaChar();
        if (row == col) {
            if (!rightDiagonalMap.containsKey(aChar)){
                rightDiagonalMap.put(aChar, 1);
            }
            else {
                rightDiagonalMap.put(aChar, rightDiagonalMap.get(aChar) + 1);
            }
            return rightDiagonalMap.get(aChar) == board.getSize();
        }
        return false;
    }
}
