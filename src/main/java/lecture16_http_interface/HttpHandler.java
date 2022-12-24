package lecture16_http_interface;

import java.io.IOException;

public interface HttpHandler {
    void handle (HttpServerContext httpServerContext, HttpRequest httpRequest, HttpResponse httpResponse) throws IOException;

}
