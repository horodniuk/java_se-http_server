package PROJECT_HTTP_SERVER.impl;

import java.util.concurrent.ThreadFactory;

public class DefaultThreadFactory implements ThreadFactory {
    private String name;
    private int count;

    DefaultThreadFactory() {
        super();
        count = 1;
        name = "executor-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + (count++));
        thread.setDaemon(false);
        thread.setPriority(8);
        return thread;
    }
}
