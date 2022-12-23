package lecture9_multithreading.lecture3.concurrent.latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable {
    private final CountDownLatch countDownLatch;

    public Rocket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Rocket getting ready start");
        try {
            countDownLatch.await();
            System.out.println("Start!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
