package lecture9_multithreading.lecture3.multithreading.simple;

public class EvenNumbersThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i += 2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
