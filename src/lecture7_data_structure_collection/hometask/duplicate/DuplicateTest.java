package lecture7_data_structure_collection.hometask.duplicate;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateTest implements Comparable<DuplicateTest> {
    public static void main(String[] args) {
        DuplicateTest element = new DuplicateTest();
        Set<DuplicateTest> set1 = new HashSet<>();
        Set<DuplicateTest> set2 = new TreeSet<>();
        for (int i = 0; i < 1000; i++) {
            set1.add(element);
            set2.add(element);
        }
        System.out.println(set1.size());
        System.out.println(set2.size());
    }

    @Override
    public int compareTo(DuplicateTest o) {
        return 0;
    }
}
