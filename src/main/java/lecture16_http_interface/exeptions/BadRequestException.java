package lecture16_http_interface.exeptions;

public class BadRequestException extends AbstractRequestParseFalledException {
    public BadRequestException(String message, Throwable cause, String startingLine) {
        super(message, cause, startingLine);
        setStatusCode(400);
    }
}
