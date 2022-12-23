package lecture9_multithreading.lecture3.concurrent.semaphore;

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
