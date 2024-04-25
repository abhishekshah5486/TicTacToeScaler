package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();

        for (int j=0; j<size; j++){
            List<Cell> row = new ArrayList<>();
            for (int k=0; k<size; k++){
                row.add(new Cell(j, k));
            }
            this.board.add(row);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void printBoard(){
        for (int j=0; j<size; j++){
            for (int k=0; k<size; k++){
                if (board.get(j).get(k).getCellState() == CellState.EMPTY){
                    System.out.print("|---|");
                } else{
                    System.out.print("|" + board.get(j).get(k).getPlayer().getSymbol().getaChar() + "|");
                }
            }
            System.out.println();
        }
    }
}
