package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.HttpResponse;
import PROJECT_HTTP_SERVER.HttpServerContext;
import PROJECT_HTTP_SERVER.config.HttpRequestDispatcher;

import java.io.IOException;

public class HelloWorldHttpRequestDispatcher implements HttpRequestDispatcher {

    @Override
    public void handle(HttpServerContext httpServerContext, HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
        httpResponse.setBody("<h1>Hello world!</h1>");
    }
}
