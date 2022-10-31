package lecture9_multithreading.lecture;

import java.util.concurrent.TimeUnit;

public class RunnableTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("RunnableTest finished");
    }

    public static void main(String[] args) {
        Thread th = new Thread(new RunnableTest(), "RunnableTest");
        th.setDaemon(true);
        th.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main finished");
    }
}
