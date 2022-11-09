package lecture9_multithreading.lecture2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class L4_SyncLock {
    public static void main(String[] args) {
        new Worker().execute();
    }

    static class Worker {
        Random random = new Random();
        Object lock1 = new Object();
        Object lock2 = new Object();

        private List<Integer> list1 = new ArrayList<>();
        private List<Integer> list2 = new ArrayList<>();

        public void addToList1() {
            synchronized (list1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list1.add(random.nextInt(100));
            }
        }

        public void addToList2() {
            synchronized (list2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
        }

        public void work() {
            for (int i = 0; i < 1000; i++) {
                addToList1();
                addToList2();
            }
        }

    public void execute() {
        long before = System.currentTimeMillis();
        Thread t1 = new Thread(() -> work());
        Thread t2 = new Thread(() -> work());
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis();
        System.out.println("Program took " + (after - before) + " ms to run");
        System.out.println(list1.size());
        System.out.println(list2.size());
    }

}

}
