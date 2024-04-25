package Models;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, PlayerType playerType, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, playerType,symbol);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
        for (int j=0; j<board.getSize(); j++){
            for (int k=0; k<board.getSize(); k++){
                if (board.getBoard().get(j).get(k).getCellState().equals(CellState.EMPTY)){
                    return new Move(new Cell(j, k), this);
                }
            }
        }
        return null;
    }

}
