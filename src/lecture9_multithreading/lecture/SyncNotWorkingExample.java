package lecture9_multithreading.lecture;

import java.util.concurrent.TimeUnit;

public class SyncNotWorkingExample {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public synchronized void run() {
                    for(int i=0;i<5;i++) {
                        System.out.println(Thread.currentThread().getName()+"->"+i);
                        try {
                            TimeUnit.MILLISECONDS.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "Thread-"+i).start();
        }
    }
}
