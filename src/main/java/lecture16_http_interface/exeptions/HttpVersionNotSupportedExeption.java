package lecture16_http_interface.exeptions;

public class HttpVersionNotSupportedExeption extends AbstractRequestParseFalledException {

    public HttpVersionNotSupportedExeption(String message, String startingLine) {
        super(message, startingLine);
        setStatusCode(505);
    }
}
