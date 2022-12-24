package lecture16_http_interface.config;

import lecture16_http_interface.HttpRequest;
import lecture16_http_interface.HttpServer;
import lecture16_http_interface.exeptions.HttpServerException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Компонент будет парсить http запрос
 */
public interface HttpRequestParser extends Runnable {
    HttpRequest parseHttpRequest(InputStream inputStream, String remoteAddress) throws IOException, HttpServerException;
}
