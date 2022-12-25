package PROJECT_HTTP_SERVER.exeptions;

public class BadRequestException extends AbstractRequestParseFalledException {
    public BadRequestException(String message, Throwable cause, String startingLine) {
        super(message, cause, startingLine);
        setStatusCode(400);
    }
}
