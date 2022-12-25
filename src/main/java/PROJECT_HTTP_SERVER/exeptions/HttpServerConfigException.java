package PROJECT_HTTP_SERVER.exeptions;

public class HttpServerConfigException extends HttpServerException {

    public HttpServerConfigException(String message) {
        super(message);
    }

    public HttpServerConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpServerConfigException(Throwable cause) {
        super(cause);
    }
}
