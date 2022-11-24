package lecture5_exception.lecture.fraction;

public class InvalidFractionNumberArgumentException extends Exception {
    public InvalidFractionNumberArgumentException(String message) {
        super(message);
    }
}
