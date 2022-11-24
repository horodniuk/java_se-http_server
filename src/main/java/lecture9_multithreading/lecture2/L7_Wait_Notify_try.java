package lecture9_multithreading.lecture2;

import java.util.Random;
import java.util.Scanner;

public class L7_Wait_Notify_try {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
    static class P {
        private Double amount;

        public P(double amount) {
            this.amount = amount;
        }

        public void doRefuel(double subtractAmount){
            amount =- subtractAmount;
            System.out.println("amount " + amount + "subtractAmount " +  subtractAmount + " OSTATOK - " + (amount - subtractAmount));
        }
    }

    static class WaitAndNotify {
        public void produce() throws InterruptedException {
            synchronized (this) {
                System.out.println("Produser thread started");
                wait(); // 1- out synh block, 2- wait , when call notify
                System.out.println("Produser thread resumed...");
            }
        }

        public void consume() throws InterruptedException {
            Thread.sleep(2000);
            Scanner scanner = new Scanner(System.in);
            synchronized (this) {
                System.out.println("Waiting for return  key pressed");
                scanner.nextLine();
                notify();
                Thread.sleep(2);
            }
        }
    }


}


