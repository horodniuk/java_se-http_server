package lecture6_oop_gomoka_game.lecture;

public interface ComputerTurn {
    void setGameTable(GameTable gameTable);
    Cell makeTurn();
    Cell makeFirstTurn();
}
