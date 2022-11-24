package lecture6_oop_gomoka_game.lecture;

public interface WinnerChecker {
    void setGameTable(GameTable gameTable);
    WinnerResult isWinnerFound(CellValue cellValue);

}
