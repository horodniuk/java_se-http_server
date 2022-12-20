package lecture9_multithreading.lecture3.multithreading.simple;

public class Main {
    public static void main(String[] args) {
        var t1 = new  EvenNumbersThread();
        t1.start();
        System.out.println("End");
    }
}
