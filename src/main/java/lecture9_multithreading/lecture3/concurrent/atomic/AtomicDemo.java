package lecture9_multithreading.lecture3.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        int value;
        final var atomicInteger = new AtomicInteger();
        value = atomicInteger.incrementAndGet();

        value += atomicInteger.addAndGet(10);
        System.out.println(value);
    }
}
