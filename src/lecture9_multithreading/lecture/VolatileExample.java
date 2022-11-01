package lecture9_multithreading.lecture;

public class VolatileExample {
    private int display = 5;
    private void execute(){
        new Thread(() -> display += 1).start();
        new Thread(() -> System.out.println(display)).start();
        System.out.println(display);
    }

    public static void main(String[] args) {
        new VolatileExample().execute();
    }
}
