package lecture4_interface_enum.lecture.student;

import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        String[] array1 = { "simple", "a new game", "big boss", "Java forever", "London is a capital of Great Britain" };
        System.out.println(findMax(array1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }));
        System.out.println(findMax(array1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.split(" ").length;
                int len2 = o2.split(" ").length;
                return len1 - len2;
            }
        }));
    }
    public static <T> T findMax(T[] array, Comparator<T> comparator) {
        T max = null;
        if (array.length > 0) {
            max = array[0];
        }
        for (int i = 1; i < array.length; i++) {
            if (comparator.compare(array[i], max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}
