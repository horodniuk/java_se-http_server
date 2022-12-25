package lecture9_multithreading.lecture3.concurrent.barrier;



import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class RocketDetailRunnable implements Runnable {
    private final RocketDetail rocketDetail;
    private final CyclicBarrier cyclicBarrier;

    public RocketDetailRunnable(RocketDetail rocketDetail, CyclicBarrier cyclicBarrier) {
        this.rocketDetail = rocketDetail;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Detail is being prepared " + rocketDetail);
        try {
            Thread.sleep(1000);
            System.out.println("Detail is  ready and waiting " + rocketDetail);
            cyclicBarrier.await();
            System.out.println("Detail is used " + rocketDetail);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
