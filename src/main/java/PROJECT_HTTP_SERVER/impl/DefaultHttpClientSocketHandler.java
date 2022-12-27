package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.config.HttpClientSocketHandler;
import PROJECT_HTTP_SERVER.config.HttpServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;

public class DefaultHttpClientSocketHandler implements HttpClientSocketHandler {
    private static final Logger ACCESS_LOGGER = LoggerFactory.getLogger("ACCESS_LOG");
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHttpClientSocketHandler.class);
    private final Socket clientSocket;
    private final String remoteAddress;
    private final HttpServerConfig httpServerConfig;

    public DefaultHttpClientSocketHandler(Socket clientSocket, DefaultHttpServerConfig defaultHttpServerConfig) {
        super();
        this.clientSocket = clientSocket;
        this.remoteAddress = clientSocket.getRemoteSocketAddress().toString();
        this.httpServerConfig = defaultHttpServerConfig;
    }

    @Override
    public void run() {

    }
}
