package lecture7_data_structure_collection.lecture;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<Integer> set1 = new TreeSet<>();
        for (int i = 9; i >= 0; i--) {
            set1.add(i);
        }
        System.out.println(set1);
        Set<Integer> set2 = new TreeSet<>((o1, o2) -> o2.compareTo(o1));
        set2.addAll(set1);
        System.out.println(set2);
        Set<TreeSetTest> set3 = new TreeSet<>(new Comparator<TreeSetTest>() {
            @Override
            public int compare(TreeSetTest o1, TreeSetTest o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
        for (int i = 9; i >= 0; i--) {
            set3.add(new TreeSetTest());
        }
        System.out.println(set3);
    }

}
