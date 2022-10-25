package lecture6_oop_gomoka_game.lecture.impl;

import lecture6_oop_gomoka_game.lecture.Cell;
import lecture6_oop_gomoka_game.lecture.CellValue;
import lecture6_oop_gomoka_game.lecture.GameTable;
import lecture6_oop_gomoka_game.lecture.HumanTurn;

import java.util.Objects;

public class DefaultHumanTurn implements HumanTurn {
    private GameTable gameTable;

    @Override
    public void setGameTable(GameTable gameTable) {
        Objects.requireNonNull(gameTable, "Game table can't be null");
        this.gameTable = gameTable;
    }

    @Override
    public Cell makeTurn(int row, int col) {
        gameTable.setValue(row, col, CellValue.HUMAN);
        return new Cell(row, col);
    }
}
