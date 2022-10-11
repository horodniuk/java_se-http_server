package lecture1_oop_classes_encapsulation.lecture;

import java.util.Arrays;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        for (int i = 0; i < 50; i++) {
            array.add(i);
        }
        System.out.println(Arrays.toString(array.toArray()));
    }
}
