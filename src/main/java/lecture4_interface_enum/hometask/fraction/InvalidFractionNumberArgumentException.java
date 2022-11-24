package lecture4_interface_enum.hometask.fraction;

public class InvalidFractionNumberArgumentException extends IllegalArgumentException {
    public InvalidFractionNumberArgumentException(String s) {
        super(s);
    }

    public InvalidFractionNumberArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
