package lecture9_multithreading.lecture3.multithreading.synchronized_keyword;

public class SynchronizeExample {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();
    }
}
