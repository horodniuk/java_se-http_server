package lecture9_multithreading.lecture3.concurrent.barrier;



import java.util.Arrays;
import java.util.concurrent.*;

public class LatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(RocketDetail.values().length, ()-> System.out.println("Pysk"));
        ExecutorService threadPool =  Executors.newFixedThreadPool(5);
        Arrays.stream(RocketDetail.values())
                .map(detail-> new RocketDetailRunnable(detail, cyclicBarrier))
                .forEach(threadPool::submit);

        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.MINUTES);
    }
}
