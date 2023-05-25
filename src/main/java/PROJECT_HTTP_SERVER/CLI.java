package PROJECT_HTTP_SERVER;

import PROJECT_HTTP_SERVER.handler.ServerInfoHttpHandler;
import PROJECT_HTTP_SERVER.handler.TestJdbcHandler;
import PROJECT_HTTP_SERVER.impl.HttpServerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private static final Logger LOGGER = LoggerFactory.getLogger(CLI.class);
    private static final List<String> QUIT_CMDS = List.of("q", "quit", "exit");

    public static void main(String[] args) {
        Thread.currentThread().setName("CLI-main thread");
        try {
            HttpServerFactory httpServerFactory = HttpServerFactory.create();
            HttpServer httpServer = httpServerFactory.createHttpServer(getHandlerConfig(),null);
            httpServer.start();
            waitForStopCommand(httpServer);
        } catch (Exception e) {
            LOGGER.error("Can not execute cmd: " + e.getMessage(), e);
        }
    }

    private static void waitForStopCommand(HttpServer httpServer) {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name())) {
            while (true) {
                String cmd = scanner.nextLine();
                  if (QUIT_CMDS.contains(cmd.toLowerCase())) {
                    httpServer.stop();
                    break;
                } else {
                    LOGGER.error("Unsupported cmd: " + cmd + ". To shutdown server please type: q");
                }
            }
        }
    }

    private static HandlerConfig getHandlerConfig(){
        return new HandlerConfig()
                .addHandler("/info", new ServerInfoHttpHandler())
                .addHandler("/jdbc", new TestJdbcHandler());
    }
}
