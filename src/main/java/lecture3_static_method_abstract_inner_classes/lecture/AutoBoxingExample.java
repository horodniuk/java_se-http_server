package lecture3_static_method_abstract_inner_classes.lecture;

public class AutoBoxingExample {
    public static void main(String[] args) {
        Object o = 5;
        System.out.println(o.getClass());
        int d = (int) o;
        System.out.println(d);
    }
}
