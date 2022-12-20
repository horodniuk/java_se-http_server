package lecture9_multithreading.lecture3.multithreading.producer_consumer;

import java.util.Queue;

public class ConsumerThread implements Runnable {
    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        synchronized (list){
            while (true){
                if (!list.isEmpty()){
                    Integer removeValue = list.remove();
                    System.out.println("Consumer get value " + removeValue +". Size " + list.size());
                } else {
                    System.out.println("Consumer is waiting, list is empty");
                }

                try {
                    int random = RandomUtil.getRandom();
                    System.out.println("Consumer wait " + random);
                    list.notifyAll();
                    list.wait(random);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
