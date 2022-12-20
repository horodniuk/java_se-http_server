package lecture9_multithreading.lecture3.multithreading.producer_consumer;

import java.util.Queue;

public class ProducerThread implements Runnable {
    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if(list.size() < 10){
                final var randomValue = RandomUtil.getRandom();
                list.add(randomValue);

                System.out.println("Producer get value " + randomValue + ". Size " + list.size());
                }else {
                    System.out.println("Producer does nothing");
                }
                list.notifyAll();
                    try {
                        int random = RandomUtil.getRandom(5);
                        System.out.println("Produser wait " + random);
                        list.wait(random);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}
