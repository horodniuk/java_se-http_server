package lecture9_multithreading.lecture3.multithreading.synchronized_keyword;

public class Consumer extends Thread {
    private final Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < Resource.COUNT; i++) {
            resource.get(i);
        }
    }
}
