package lecture6_oop_gomoka_game.lecture;

import lecture6_oop_gomoka_game.lecture.conteiner.DataSet;

public interface WinnerResult {
    boolean winnerExists();
    DataSet<Cell> getWinnerCells();
}
