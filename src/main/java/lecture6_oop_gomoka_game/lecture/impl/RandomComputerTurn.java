package lecture6_oop_gomoka_game.lecture.impl;


import lecture6_oop_gomoka_game.lecture.Cell;
import lecture6_oop_gomoka_game.lecture.CellValue;
import lecture6_oop_gomoka_game.lecture.ComputerTurn;
import lecture6_oop_gomoka_game.lecture.GameTable;
import lecture6_oop_gomoka_game.lecture.conteiner.DataSet;
import lecture6_oop_gomoka_game.lecture.conteiner.DynaArray;

import java.util.Objects;
import java.util.Random;

public class RandomComputerTurn implements ComputerTurn {
    private GameTable gameTable;
    @Override
    public void setGameTable(GameTable gameTable) {
        Objects.requireNonNull(gameTable, "Game table can't be null");
        this.gameTable = gameTable;
    }

    @Override
    public Cell makeTurn() {
        DataSet<Cell> emptyCells = getAllEmptyCells();
        if (emptyCells.size() > 0) {
            Cell randomCell = emptyCells.get(new Random().nextInt(emptyCells.size()));
            gameTable.setValue(randomCell.getRowIndex(), randomCell.getColIndex(), CellValue.COMPUTER);
            return randomCell;
        } else {
            throw new ComputerCantMakeTurnException("All cells are filled! Have you checked draw state before call of computer turn?");
        }
    }

    @Override
    public Cell makeFirstTurn() {
        return makeTurn();
    }

    protected DataSet<Cell> getAllEmptyCells(){
        DataSet<Cell> emptyCells = new DynaArray<>();
        for (int i = 0; i < gameTable.getSize(); i++) {
            for (int j = 0; j < gameTable.getSize(); j++) {
                if (gameTable.isCellFree(i, j)) {
                    emptyCells.add(new Cell(i, j));
                }
            }
        }
        return emptyCells;
    }
}
