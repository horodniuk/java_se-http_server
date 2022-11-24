package lecture9_multithreading.lecture2;

public class L1_Intro {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread threadByRunnable = new Thread(new ThreadByRunnable());
        threadByRunnable.start();
        System.out.println("Hello Main thread");
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " Hello my thread - " + i);
            }
        }
    }

    static class ThreadByRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " Hello my thread by Runnable - " + i);
            }
        }
    }
}




