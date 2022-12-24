package lecture16_http_interface.exeptions;

import lecture16_http_interface.Constants;

public class MethodNotAllowedException extends AbstractRequestParseFalledException {
    public MethodNotAllowedException(String method, String startingLine) {
        super("Only " + Constants.ALLOWED_METHODS + " are supported. Current mehtod are " + method,  startingLine);
        setStatusCode(405);
    }
}
