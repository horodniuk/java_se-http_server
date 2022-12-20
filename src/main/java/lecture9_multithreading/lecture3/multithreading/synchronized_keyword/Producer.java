package lecture9_multithreading.lecture3.multithreading.synchronized_keyword;

public class Producer extends Thread {

    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < Resource.COUNT; i++) {
            resource.put(i);
        }
    }
}
