package lecture9_multithreading.lecture;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TerminateThread implements Runnable {
    private Thread thread;

    public TerminateThread() {
        thread = new Thread(this, "TerminateThread");
    }

    public void start(){
        thread.start();
    }

    public void stop(){
      //  thread.stop();
      //  thread.suspend();
        thread.interrupt();

    }

    @Override
    public void run() {
        while (!thread.isInterrupted()){
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
            System.out.println(new Date());
        }
    }

    public static void main(String[] args) {
        TerminateThread t = new TerminateThread();
        t.start();
        while (true){
            String cmd = new Scanner(System.in).nextLine();
            if ("q".equals(cmd)){
                t.stop();
                System.out.println("Finished");
                break;
            }
        }
    }
}
