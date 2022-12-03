package lecture9_multithreading.lecture;

public class ThreadPropertiesTest {
    public static void main(String[] args) {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

            }
        });
        th.setDaemon(false);
        th.setName("r.Test thread");
        th.setPriority(Thread.MAX_PRIORITY);
        th.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.err.println("Exception in the thread: "+t);
                e.printStackTrace();
            }
        });
    }
}
