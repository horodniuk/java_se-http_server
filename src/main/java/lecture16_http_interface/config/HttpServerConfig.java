package lecture16_http_interface.config;

import lecture16_http_interface.HttpServerContext;
import lecture16_http_interface.ServerInfo;

import java.net.Socket;
import java.util.concurrent.ThreadFactory;

public interface HttpServerConfig {
    ServerInfo getServerInfo();

    String getStatusMessage(int statusCode);

    HttpRequestParser getHttpRequestParser();

    HttpResponseBuilder getHttpResponseBuilder();

    HttpResponseWriter getHttpResponseWriter();

    HttpServerContext getHttpServerContext();

    HttpRequestDispatcher getHttpRequestDispatcher();

    ThreadFactory getWorkerThreadFactory();

    HttpClientSocketHandler buildNewHttpClientSocketHandler (Socket clientSocket);



}
