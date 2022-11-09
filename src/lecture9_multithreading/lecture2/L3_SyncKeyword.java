package lecture9_multithreading.lecture2;

public class L3_SyncKeyword {
    private int counter = 100000;
    public static void main(String[] args) throws InterruptedException {
        new L3_SyncKeyword().doWork(50);
    }
    synchronized int subtraction(int counter, int number){
              return counter -= number;

    }
    public void doWork(int number) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter = subtraction(counter, number);
                    System.out.println(Thread.currentThread().getName() + " -> " + counter);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter = subtraction(counter, number);
                    System.out.println(Thread.currentThread().getName() + " -> " + counter);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }
}
