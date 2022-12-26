package PROJECT_HTTP_SERVER.exeptions;

public class HttpVersionNotSupportedException extends AbstractRequestParseFalledException {

    public HttpVersionNotSupportedException(String message, String startingLine) {
        super(message, startingLine);
        setStatusCode(505);
    }
}
