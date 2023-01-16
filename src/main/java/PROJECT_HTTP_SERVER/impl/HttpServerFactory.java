package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HttpServer;
import PROJECT_HTTP_SERVER.config.HttpServerConfig;
import PROJECT_HTTP_SERVER.config.ReadableHttpResponse;

import java.util.Properties;

public class HttpServerFactory {
    protected HttpServerFactory() {
    }

    public static HttpServerFactory create() {
        return new HttpServerFactory();
    }

    public HttpServer createHttpServer(Properties overridesServerProperties) {
        HttpServerConfig httpServerConfig = new DefaultHttpServerConfig(overridesServerProperties);
        return new DefaultHttpServer(httpServerConfig);
    }
}
