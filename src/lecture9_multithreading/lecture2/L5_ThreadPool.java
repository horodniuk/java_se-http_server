package lecture9_multithreading.lecture2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class L5_ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            service.submit(new Work(i));
        }
        service.shutdown();
        System.out.println("All task submitted");
        service.awaitTermination(1, TimeUnit.DAYS);
    }
    static class  Work implements Runnable{
        private int id;

        public Work(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Work " + id + " was completed");
        }
    }
}
