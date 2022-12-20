package lecture9_multithreading.lecture3.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        final var threadPool = Executors.newFixedThreadPool(5);
        threadPool.submit(()-> {
            System.out.println("its collable");
            return 1;
        });
    }
}
