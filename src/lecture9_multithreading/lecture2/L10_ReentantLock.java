package lecture9_multithreading.lecture2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class L10_ReentantLock {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Lock lock =  new ReentrantLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                task.firstThread();
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                task.secondThread();
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.print();
    }
    static class Task{
        public int counter;
        void increment(){
            for (int i = 0; i < 100000; i++) {
                counter++;
            }
        }

        public void firstThread(){
            increment();
        }

        public void secondThread(){
            increment();
        }

        void print(){
            System.out.println(counter);
        }
    }
}
