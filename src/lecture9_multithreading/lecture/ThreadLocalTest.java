package lecture9_multithreading.lecture;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    public static void main(String[] args) {
        final ThreadLocal<String> name = new ThreadLocal<>();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                name.set(Thread.currentThread().getName());
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name.get());
            }).start();
        }
    }

    static class SimpleVar<T> {
        T value;

        public synchronized T get() {
            return value;
        }

        public synchronized void set(T value) {
            this.value = value;
        }
    }

}
