package lecture6_oop_gomoka_game.lecture.impl;

public class ComputerCantMakeTurnException extends IllegalArgumentException {
    public ComputerCantMakeTurnException(String s) {
        super(s);
    }
}
