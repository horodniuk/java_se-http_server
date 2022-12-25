package PROJECT_HTTP_SERVER.config;

import PROJECT_HTTP_SERVER.HttpServerContext;
import PROJECT_HTTP_SERVER.ServerInfo;

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
