package lecture9_multithreading.lecture2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class L9_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 1; i++) {
            service.submit(new Processor(countDownLatch));
        }
        service.shutdown();
        countDownLatch.await();
        System.out.println("Lanche is opened");

    }

    static class Processor implements Runnable{
        private CountDownLatch countDownLatch;
        public Processor(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " - Proccessor run");
            countDownLatch.countDown();
        }
    }
}
