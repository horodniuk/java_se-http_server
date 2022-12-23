package lecture9_multithreading.lecture3.concurrent.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final var threadPool = Executors.newFixedThreadPool(5);
        Future<Integer> future = threadPool.submit(()-> {
            Thread.sleep(2000L);
            System.out.println("its collable");
            return 1;
        });
        System.out.println("Result " + future.get());
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);
        System.out.println("main end");
    }
}
