package PROJECT_HTTP_SERVER;

/**
 * Текущее состояние сервера, которое будет доступно всем обработчикам
 */
public class ServerInfo {
    private final String name; // имя сервера
    private final int port;    // порт сервера
    private final int threadCount; // кол-во потоков

    public ServerInfo(String name, int port, int threadCount) {
        this.name = name;
        this.port = port;
        this.threadCount = threadCount;
    }

    public String getName() {
        return name;
    }


    public int getPort() {
        return port;
    }


    public int getThreadCount() {
        return threadCount;
    }


    @Override
    public String toString() {
        return "ServerInfo{" +
               "name='" + name + '\'' +
               ", port=" + port +
               ", threadCount=" + threadCount +
               '}';
    }
}
