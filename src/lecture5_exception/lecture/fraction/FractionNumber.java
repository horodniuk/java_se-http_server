package lecture5_exception.lecture.fraction;

public interface FractionNumber {
    int DEFAULT_DIVISOR = 1; // значение делителя по умолчанию, делимое равно 0
    int getDividend(); // вернуть делимое
    int getDivisor(); // вернуть делитель
    void setDividend(int dividend); // установить делимое
    void setDivisor(int divisor); // установить делитель, если не равно 0, иначе out  Invalid divisor
    double getValue(); // вернуть десятичное представление дроби
    String toString(); // отобразить в формате: ½ 2/5 и т.д.
    FractionNumber add(FractionNumber secondArgument); // Вернуть новый объект FractionNumber,являющийся результатом сложения this и secondArgument
    FractionNumber sub(FractionNumber secondArgument);
    FractionNumber mul(FractionNumber secondArgument);
    FractionNumber div(FractionNumber secondArgument);
}
