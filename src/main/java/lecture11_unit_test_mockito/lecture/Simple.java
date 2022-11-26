package lecture11_unit_test_mockito.lecture;

public class Simple {
    public static void main(String[] args) {
        int actual = 2 + 2;
        int expected = 5;
        if (actual != expected) {
            throw new AssertionError("expected: <" + expected + "> but was: <" + actual + ">");
        }
    }
}
