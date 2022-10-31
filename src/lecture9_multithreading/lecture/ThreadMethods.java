package lecture9_multithreading.lecture;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ThreadMethods  {
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "runnable-thread");
        System.out.println("ThreadState="+th.getState());
        th.start();
        System.out.println("ThreadState="+th.getState());
        Thread.sleep(1000);
        System.out.println("ThreadId="+th.getId());
        System.out.println("ThreadState="+th.getState());
        System.out.println("ThreadState=" + Arrays.toString(th.getStackTrace()));
        th.dumpStack(); //Static method!!!!!!!
        System.out.println("isAlive="+th.isAlive());
        th.join();
        System.out.println("Completed");
    }
}
