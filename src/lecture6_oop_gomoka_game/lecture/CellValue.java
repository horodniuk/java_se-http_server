package lecture6_oop_gomoka_game.lecture;

public enum CellValue {
    EMPTY(' '),
    HUMAN('X'),
    COMPUTER('O');

    private char value;

    CellValue(char value) {
        this.value = value;
    }

    public String getValue() {
        return String.valueOf(value);
    }
}
