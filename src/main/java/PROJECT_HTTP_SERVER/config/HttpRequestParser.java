package PROJECT_HTTP_SERVER.config;

import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.exeptions.HttpServerException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Компонент будет парсить http запрос
 */
public interface HttpRequestParser extends Runnable {
    HttpRequest parseHttpRequest(InputStream inputStream, String remoteAddress) throws IOException, HttpServerException;
}
