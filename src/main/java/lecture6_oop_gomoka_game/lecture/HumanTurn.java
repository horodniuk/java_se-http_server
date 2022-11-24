package lecture6_oop_gomoka_game.lecture;

public interface HumanTurn {
    void setGameTable(GameTable gameTable);
    Cell makeTurn(int row, int col);
}
