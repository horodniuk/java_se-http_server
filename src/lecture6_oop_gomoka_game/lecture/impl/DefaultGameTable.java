package lecture6_oop_gomoka_game.lecture.impl;

import lecture6_oop_gomoka_game.lecture.CellValue;
import lecture6_oop_gomoka_game.lecture.GameTable;

public class DefaultGameTable implements GameTable {
    private final CellValue[][] gameTable;

    public DefaultGameTable() {
        gameTable = new CellValue[DefaultConstants.SIZE][DefaultConstants.SIZE];
        reInit();
    }




    @Override
    public CellValue getValue(int row, int col) {
        if (row >= 0 && row < getSize() && col >= 0 && col < getSize()) {
            return gameTable[row][col];
        } else {
            throw new IndexOutOfBoundsException("Invalid row or col indexes: row=" + row + ", col=" + col + ", size=" + getSize());
        }
    }

    @Override
    public void setValue(int row, int col, CellValue cellValue) {
        if (row >= 0 && row < getSize() && col >= 0 && col < getSize()) {
            gameTable[row][col] = cellValue;
        } else {
            throw new IndexOutOfBoundsException("Invalid row or col indexes: row=" + row + ", col=" + col + ", size=" + getSize());
        }
    }

    @Override
    public void reInit() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                setValue(i, j, CellValue.EMPTY);
            }
        }
    }

    @Override
    public int getSize() {
        return gameTable.length;
    }

    @Override
    public boolean isCellFree(int row, int col) {
        return getValue(row, col) == CellValue.EMPTY;
    }

    @Override
    public boolean emptyCellExists() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (getValue(i, j) == CellValue.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }
}
