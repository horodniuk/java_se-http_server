package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.Constants;
import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.HttpResponse;
import PROJECT_HTTP_SERVER.HttpServerContext;
import PROJECT_HTTP_SERVER.config.HttpClientSocketHandler;
import PROJECT_HTTP_SERVER.config.HttpServerConfig;
import PROJECT_HTTP_SERVER.config.ReadableHttpResponse;
import PROJECT_HTTP_SERVER.exeptions.AbstractRequestParseFalledException;
import PROJECT_HTTP_SERVER.exeptions.HttpServerException;
import PROJECT_HTTP_SERVER.exeptions.MethodNotAllowedException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * класс отвечающий за обработку запроса в отдельном потоке
 */
public class DefaultHttpClientSocketHandler implements HttpClientSocketHandler {
    private static final Logger ACCESS_LOGGER = LoggerFactory.getLogger("ACCESS_LOG");
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHttpClientSocketHandler.class);
    private final Socket clientSocket;  // клиентский сокет
    private final String remoteAddress; // удаленный адресс
    private final HttpServerConfig httpServerConfig; // объект сервер конфига

    public DefaultHttpClientSocketHandler(Socket clientSocket, DefaultHttpServerConfig defaultHttpServerConfig) {
        super();
        this.clientSocket = clientSocket; // сокетное соеденение
        this.remoteAddress = clientSocket.getRemoteSocketAddress().toString(); // удаленный адресс
        this.httpServerConfig = defaultHttpServerConfig; // конфигурация сервера
    }

    /**
     * если нет выполыется задача - логирруем ошибку
     */
    @Override
    public void run() {
        try {
            execute();
        } catch (Exception e) {
            LOGGER.error("Client request failed: " + e.getMessage(), e);
        }
    }

    private void execute() throws IOException {
        try (Socket socket = clientSocket) {
            socket.setKeepAlive(false); // данный сокет не должен поддерживать keep alive соеденения
            try (
                    InputStream inputStream = socket.getInputStream();  // получаем потоки ввода
                    OutputStream outputStream = socket.getOutputStream();// получаем потоки вывода
            ) {
                processRequest(remoteAddress, inputStream, outputStream);
            }
        }
    }

    private void processRequest(String remoteAddress, InputStream inputStream, OutputStream outputStream) throws IOException {
        ReadableHttpResponse response = httpServerConfig.getHttpResponseBuilder().buildNewHttpResponse();
        String startingLine = null;
        try {
            // пытаемся распарсить запрос
            HttpRequest request = httpServerConfig.getHttpRequestParser().parseHttpRequest(inputStream, remoteAddress);
            startingLine = request.getStartingLine();
            processRequest(request, response);
        } catch (AbstractRequestParseFalledException exception) {
            startingLine = exception.getStartingLine();
            handleException(exception, response);
        } catch (EOFException exception) {
            LOGGER.warn("Client socket closed connection");
            return;
        }
        httpServerConfig.getHttpResponseBuilder().prepareHttpResponse(response, startingLine.startsWith(Constants.HEAD));
        ACCESS_LOGGER.info("Request: {} - \"{}\", Response{}({} bytes)", remoteAddress, startingLine, response.getStatus(), response.getBodyLength());
        httpServerConfig.getHttpResponseWriter().writerHttpResponse(outputStream, response);
    }

    private void processRequest(HttpRequest request, HttpResponse response) {
        HttpServerContext httpServerContext = httpServerConfig.getHttpServerContext();
        try {
            httpServerConfig.getHttpRequestDispatcher().handle(httpServerContext, request, response);
        } catch (Exception e) {
            handleException(e, response);
        }
    }

    private void handleException(Exception exception, HttpResponse response) {
        LOGGER.error("Exception during request " + exception.getMessage(), exception);
        if (exception instanceof HttpServerException) {
            HttpServerException e = (HttpServerException) exception;
            response.setStatus(e.getStatusCode());
            if (exception instanceof MethodNotAllowedException) {
                response.setHeader("Allow", StringUtils.join(Constants.ALLOWED_METHODS, ", "));
            } else {
                response.setStatus(500);
            }
        }
    }
}
