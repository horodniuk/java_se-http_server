package lecture9_multithreading.lecture3.concurrent.latch;

import java.util.Arrays;
import java.util.concurrent.*;

public class LatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(RocketDetail.values().length);
        final var executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Rocket(countDownLatch));
        for (RocketDetail detail : RocketDetail.values()) {
            RocketDetailRunnable rocketDetailRunnable = new RocketDetailRunnable(detail, countDownLatch);
            executorService.submit(rocketDetailRunnable);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
