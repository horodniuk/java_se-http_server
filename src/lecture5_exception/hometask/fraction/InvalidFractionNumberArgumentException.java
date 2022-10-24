package lecture5_exception.hometask.fraction;

public class InvalidFractionNumberArgumentException extends Exception {
    public InvalidFractionNumberArgumentException(String message) {
        super(message);
    }
}
