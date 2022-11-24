package lecture2_oop_classes_inheritance_polymorphism.lecture;

public class OverloadExample {
    public static void main(String[] args) {
        System.out.println(sum(1, 1));
        System.out.println(sum(1.2, 1.5));
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static double sum(double a, double b) {
        return a + b;
    }
}
