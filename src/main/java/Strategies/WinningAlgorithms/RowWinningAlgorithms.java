package Strategies.WinningAlgorithms;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;

public class RowWinningAlgorithms {
    HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<Integer, HashMap<Character, Integer>>();

    public boolean checkWinningAlgorithm(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character aChar = move.getPlayer().getSymbol().getaChar();

        if (!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }
        HashMap<Character, Integer> currRow = rowMaps.get(row);
        if (!currRow.containsKey(aChar)) {
            currRow.put(aChar, 1);
        }
        else {
            int countCharacter = currRow.get(aChar);
            currRow.put(aChar, countCharacter + 1);
        }
        return rowMaps.get(row).get(aChar) == board.getSize();
    }
}
