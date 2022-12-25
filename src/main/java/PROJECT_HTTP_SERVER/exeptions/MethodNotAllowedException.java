package PROJECT_HTTP_SERVER.exeptions;

import PROJECT_HTTP_SERVER.Constants;

public class MethodNotAllowedException extends AbstractRequestParseFalledException {
    public MethodNotAllowedException(String method, String startingLine) {
        super("Only " + Constants.ALLOWED_METHODS + " are supported. Current mehtod are " + method,  startingLine);
        setStatusCode(405);
    }
}
