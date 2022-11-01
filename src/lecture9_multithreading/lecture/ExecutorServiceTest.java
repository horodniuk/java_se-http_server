package lecture9_multithreading.lecture;

import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService = Executors.newFixedThreadPool(3);
        executorService = Executors.newSingleThreadExecutor();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("------ task interrupted -------");
                    return;
                }
                System.out.println("------ task done -------");
            }
        };
        Future<?> future = executorService.submit(task);
        System.out.println("isDone=" + future.isDone());
        System.out.println("isCancelled=" + future.isCancelled());
        future.cancel(true);
        System.out.println("isCancelled=" + future.isCancelled());
        executorService.submit(task);
        executorService.shutdown();
        executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);
        executorService.shutdownNow();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("Delayed");
            }
        }, 3, 3, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(10);
        scheduledExecutorService.shutdown();

    }
}