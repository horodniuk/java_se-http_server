package lecture9_multithreading.lecture2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class L_11_Semaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        Connection connection = Connection.getConnection();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.doWork();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
    }

    public static class Connection{
        private static Connection connection = new Connection();
        private Connection(){};
        private int countConnection;
        Semaphore semaphore = new Semaphore(10);
        public static Connection getConnection(){
            return connection;
        }

        public void work() throws InterruptedException{
            semaphore.acquire();
            try {
                doWork();
            }finally {
                semaphore.release();
            }
        }

        public void doWork() throws InterruptedException {
            synchronized (this){
               countConnection++;
               System.out.println(countConnection);
            }
            Thread.sleep(2000);

            synchronized (this){
                countConnection--;
            }
        }
    }
}
