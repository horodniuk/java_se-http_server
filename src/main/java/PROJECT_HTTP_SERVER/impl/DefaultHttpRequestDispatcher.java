package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HttpHandler;
import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.HttpResponse;
import PROJECT_HTTP_SERVER.HttpServerContext;
import PROJECT_HTTP_SERVER.config.HttpRequestDispatcher;
import PROJECT_HTTP_SERVER.exeptions.HttpServerException;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class DefaultHttpRequestDispatcher implements HttpRequestDispatcher {

    private final HttpHandler defaultHttpHandler;
    private final Map<String, HttpHandler> httpHandlers;

    DefaultHttpRequestDispatcher(HttpHandler defaultHttpHandler, Map<String, HttpHandler> httpHandlers) {
        super();
        Objects.requireNonNull(defaultHttpHandler, "Default handler should be not null");
        Objects.requireNonNull(httpHandlers, "httpHandlers should be not null");
        this.defaultHttpHandler = defaultHttpHandler;
        this.httpHandlers = httpHandlers;
    }

    @Override
    public void handle(HttpServerContext context, HttpRequest request, HttpResponse response) throws IOException {
        try {
            HttpHandler handler = getHttpHandler(request);
            handler.handle(context, request, response);
        } catch (RuntimeException e) {
            if (e instanceof HttpServerException) {
                throw e;
            } else {
                throw new HttpServerException("Handle request: " + request.getUri() + " failed: " + e.getMessage(), e);
            }
        }
    }

    protected HttpHandler getHttpHandler(HttpRequest request) {
        HttpHandler handler = httpHandlers.get(request.getUri());
        if (handler == null) {
            handler = defaultHttpHandler;
        }
        return handler;
    }
}
