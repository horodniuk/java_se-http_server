package lecture9_multithreading.lecture3.concurrent.thread_safe_collection;

public class FuelDispenser {
    private static int generator = 1;
    private int id;

    public FuelDispenser() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "{" +
               "id=" + id +
               '}';
    }
}
