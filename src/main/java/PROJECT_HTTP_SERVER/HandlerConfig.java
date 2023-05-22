package PROJECT_HTTP_SERVER;

import PROJECT_HTTP_SERVER.exeptions.HttpServerConfigException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


// можем указать отдельные обработчики
public class HandlerConfig {
    private final Map<String, HttpHandler> httpHandlers = new HashMap<>();

    public HandlerConfig addHandler(String url, HttpHandler httpHandler) {
        Objects.requireNonNull(url);
        Objects.requireNonNull(httpHandler);
        HttpHandler prevHttpHandler = httpHandlers.get(url);
        if (prevHttpHandler != null) {
            throw new HttpServerConfigException("Http handler already exists for url=" + url +
                                                ". Http handler class: " + prevHttpHandler.getClass().getName());
        }
        httpHandlers.put(url, httpHandler);
        return this;
    }

    public Map<String, HttpHandler> toMap() {
        return Collections.unmodifiableMap(httpHandlers);
    }
}
