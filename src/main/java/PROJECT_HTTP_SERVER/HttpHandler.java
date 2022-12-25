package PROJECT_HTTP_SERVER;

import java.io.IOException;

public interface HttpHandler {
    void handle (HttpServerContext httpServerContext, HttpRequest httpRequest, HttpResponse httpResponse) throws IOException;

}
