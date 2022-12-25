package PROJECT_HTTP_SERVER.exeptions;

public abstract class AbstractRequestParseFalledException extends HttpServerException {
    private final String startingLine;

    public AbstractRequestParseFalledException(String message, String startingLine) {
        super(message);
        this.startingLine = startingLine;
    }

    public AbstractRequestParseFalledException(String message, Throwable cause, String startingLine) {
        super(message, cause);
        this.startingLine = startingLine;
    }

    public AbstractRequestParseFalledException(Throwable cause, String startingLine) {
        super(cause);
        this.startingLine = startingLine;
    }

    public String getStartingLine() {
        return startingLine;
    }
}
