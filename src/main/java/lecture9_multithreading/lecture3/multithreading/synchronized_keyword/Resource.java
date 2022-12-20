package lecture9_multithreading.lecture3.multithreading.synchronized_keyword;

import lombok.SneakyThrows;

public class Resource {
    public static final int COUNT = 5;
    private int value;
    private boolean isBusyMonitor = false;

    public int getValue() {
        return value;
    }

    @SneakyThrows
    public synchronized void put(int value){
        if (isBusyMonitor){
            wait();
        }
        isBusyMonitor = true;
        System.out.println("Put " + value + " " + Thread.currentThread().getName());
        notifyAll();

    }
    @SneakyThrows
    public synchronized int get(int value){
        if (!isBusyMonitor){
            wait();
        }
        System.out.println("Get " + value+ " " + Thread.currentThread().getName());
        notifyAll();
        isBusyMonitor = false;
        return value;
    }


}
