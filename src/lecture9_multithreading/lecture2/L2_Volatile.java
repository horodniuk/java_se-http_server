package lecture9_multithreading.lecture2;

import java.util.Scanner;

public class L2_Volatile {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();
    }

    static class MyThread extends Thread{
        private volatile boolean running = true;

        @Override
        public void run() {
          while (running){
              System.out.println("Hello");
              try {
                  Thread.sleep(2000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        }

        public void shutdown(){
            this.running = false;
        }
    }


}




