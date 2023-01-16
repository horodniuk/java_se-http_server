package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HttpServer;
import PROJECT_HTTP_SERVER.config.HttpServerConfig;
import PROJECT_HTTP_SERVER.exeptions.HttpServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DefaultHttpServer implements HttpServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHttpServer.class);
    private HttpServerConfig httpServerConfig;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private Thread mainServerThread;
    private volatile boolean serverStopped;

    public DefaultHttpServer(HttpServerConfig httpServerConfig) {
        this.httpServerConfig = httpServerConfig;
        this.serverSocket = createServerSocket();
        this.executorService = createExecutorService();
        this.mainServerThread = createMainServerThread(createServerRunnable());
        this.serverStopped = serverStopped;
    }

    private Thread createMainServerThread(Runnable serverRunnable) {
        Thread thread = new Thread(serverRunnable, "Main Server Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(false);
        return thread;
    }

    private Runnable createServerRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                while (!mainServerThread.isInterrupted()) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        executorService.submit(httpServerConfig.buildNewHttpClientSocketHandler(clientSocket));
                    } catch (IOException e) {
                        if (!serverSocket.isClosed()) {
                            LOGGER.error("Can't accept client socket: " + e.getMessage());
                        }
                        destroyHttpServer();
                        break;
                    }
                }
                System.exit(0);
            }
        };
    }

    private ExecutorService createExecutorService() {
        ThreadFactory threadFactory = httpServerConfig.getWorkerThreadFactory();
        int threadCount = httpServerConfig.getServerInfo().getThreadCount();
        if (threadCount > 0) {
            return Executors.newFixedThreadPool(threadCount, threadFactory);
        } else {
            return Executors.newCachedThreadPool(threadFactory);
        }
    }

    protected ServerSocket createServerSocket() {
        try {
            ServerSocket serverSocket = new ServerSocket(httpServerConfig.getServerInfo().getPort());
            serverSocket.setReuseAddress(true);
            return serverSocket;
        } catch (IOException e) {
            throw new HttpServerException("Can,t create server socket with port =" + httpServerConfig.getServerInfo().getPort(), e);
        }
    }

    @Override
    public void start() {
        if (mainServerThread.getState() != Thread.State.NEW) {
            throw new HttpServerException("Current web server already started or stopped! Please create a new http server instance.");
        }
        Runtime.getRuntime().addShutdownHook(getShutdownHook());
        mainServerThread.start();
        LOGGER.info("Server started: " + httpServerConfig.getServerInfo());
    }

    @Override
    public void stop() {
        LOGGER.info("Detected stop cmd");
        mainServerThread.interrupt();
        try {
            serverSocket.close();
        } catch (IOException e) {
            LOGGER.warn("Error during close server socket: " + e.getMessage(), e);
        }

    }

    protected Thread getShutdownHook() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                if (!serverStopped) {
                    destroyHttpServer();
                }
            }
        }, "ShutdownHook");
    }


    private void destroyHttpServer() {
        try {
            httpServerConfig.close();
        } catch (Exception e) {
            LOGGER.error("Close httpServerConfig failed " + e.getMessage(), e);
        }
        executorService.shutdownNow();
        LOGGER.info("Server stopped");
        serverStopped = true;
    }
}
