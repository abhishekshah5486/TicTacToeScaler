package Strategies.WinningAlgorithms;

import Models.Board;
import Models.Move;

import java.util.HashMap;

public class ColumnWinningAlgorithms {
    HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();

    public boolean checkWinningAlgorithm(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character aChar = move.getPlayer().getSymbol().getaChar();

        if (!colMaps.containsKey(col)) {
            colMaps.put(col, new HashMap<Character, Integer>());
        }
        HashMap<Character, Integer> currCol = colMaps.get(col);
        if (!currCol.containsKey(aChar)) {
            currCol.put(aChar, 1);
        }
        else {
            int countCharacter = currCol.get(aChar);
            currCol.put(aChar, countCharacter + 1);
        }
        return colMaps.get(col).get(aChar) == board.getSize();
    }
}
