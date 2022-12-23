package lecture9_multithreading.lecture3.concurrent.semaphore;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;


public class PetrolStation implements Runnable {
    private double amount;
    private Semaphore availableSlots;

    public PetrolStation(double amount, Semaphore availableSlots) {
        this.amount = amount;
        this.availableSlots = availableSlots;
    }

    public static Queue<FuelDispenser> fillCarsQueue(int count) {
        Queue<FuelDispenser> carsQueue = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            carsQueue.add(new FuelDispenser());
        }
        return carsQueue;
    }

    @Override
    public void run() {
        try {
            availableSlots.acquire();
            int refuelingTime = (new Random().nextInt(10000 - 3000) + 3000);
            System.out.println(Thread.currentThread().getName() + " oбслуживаеться " + refuelingTime + " мс на колонке -> ");
            Thread.sleep(refuelingTime);
            System.out.println("Осталось " + amount + " топлива, " + Thread.currentThread().getName() + "  освобождаю колонку -> ");
            availableSlots.release();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}



