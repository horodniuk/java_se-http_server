package lecture1_oop_classes_encapsulation.hometask.stack;

public class StackTest {
    public static void main(String[] args) {
        StackComposition s = new StackComposition();
        for (int i = 0; i < 5; i++) {
            s.add(i);
        }
        while (s.size() > 0) {
            System.out.print(s.get() + " ");
        }
        System.out.println();

        System.out.println("~~~~~~~~~~~~~~~~");

        StackInheritans s2 = new StackInheritans();
        for (int i = 0; i < 5; i++) {
            s2.add(i);
        }
        while (s2.size() > 0) {
            System.out.print(s2.get() + " ");
        }
        System.out.println();
    }
}
