package lecture6_oop_gomoka_game.lecture.impl;


import lecture6_oop_gomoka_game.lecture.Cell;
import lecture6_oop_gomoka_game.lecture.WinnerResult;
import lecture6_oop_gomoka_game.lecture.conteiner.DataSet;
import lecture6_oop_gomoka_game.lecture.conteiner.DataUtils;

public class DefaultWinnerResult implements WinnerResult {
    private final DataSet<Cell> winnerCells;

    public DefaultWinnerResult(DataSet<Cell> winnerCells) {
        this.winnerCells = winnerCells != null ?
                DataUtils.newImmutableDataSet(winnerCells) :
                DataUtils.newImmutableDataSet(new Cell[0]);
    }

    @Override
    public boolean winnerExists() {
        return winnerCells.size() > 0;
    }

    @Override
    public DataSet<Cell> getWinnerCells() {
        return winnerCells;
    }
}
