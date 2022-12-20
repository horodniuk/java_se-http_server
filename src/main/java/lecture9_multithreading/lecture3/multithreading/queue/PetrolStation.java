package lecture9_multithreading.lecture3.multithreading.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;


public class PetrolStation implements Runnable {
    private double amount;
    private Queue<FuelDispenser> carsQueue;

    public PetrolStation(double amount, Queue<FuelDispenser> carsQueue) {
        this.amount = amount;
        this.carsQueue = carsQueue;
    }

    public static Queue<FuelDispenser> fillCarsQueue(int count){
        Queue<FuelDispenser> carsQueue = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            carsQueue.add(new FuelDispenser());
        }
        return carsQueue;
    }
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (carsQueue) {
                            if (!carsQueue.isEmpty()) {
                                FuelDispenser fuelDispenser = carsQueue.remove();
                                int refuelingTime = (new Random().nextInt(10000 - 3000) + 3000);  //заправка занимает время от 3-10 секунд
                                System.out.println(Thread.currentThread().getName() + " oбслуживаеться "+ refuelingTime +" мс на колонке -> " + fuelDispenser);
                                carsQueue.wait(refuelingTime);
                                System.out.println("Осталось "+ amount +" топлива, " +Thread.currentThread().getName() + "  освобождаю колонку -> " + fuelDispenser);
                                carsQueue.add(fuelDispenser);
                                carsQueue.notify();
                                break;
                            } else {
                                System.out.println(Thread.currentThread().getName() + " ожидает свободную колонку");
                                carsQueue.wait();
                            }
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }




}



