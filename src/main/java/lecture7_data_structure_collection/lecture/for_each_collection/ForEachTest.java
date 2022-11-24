package lecture7_data_structure_collection.lecture.for_each_collection;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ForEachTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();

        for (Integer val : list) {
            System.out.print(val + " ");
        }

        System.out.println();

        Set<Integer> set = new LinkedHashSet<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        for (Integer val : set) {
            System.out.print(val + " ");
        }

        System.out.println();

        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (Integer val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
