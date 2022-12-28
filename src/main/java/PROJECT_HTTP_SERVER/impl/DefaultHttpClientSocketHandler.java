package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.config.HttpClientSocketHandler;
import PROJECT_HTTP_SERVER.config.HttpServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private final Socket clientSocket;
    private final String remoteAddress;
    private final HttpServerConfig httpServerConfig;

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
        } catch (Exception e){
            LOGGER.error("Client request failed: " + e.getMessage(), e);
        }
    }

    private void execute() throws IOException {
        try(Socket socket = clientSocket){
            socket.setKeepAlive(false);
            try(
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                    ){
                processRequest(remoteAddress, inputStream, outputStream);
            }
        }
    }

    private void processRequest(String remoteAddress, InputStream inputStream, OutputStream outputStream) {

    }
}
