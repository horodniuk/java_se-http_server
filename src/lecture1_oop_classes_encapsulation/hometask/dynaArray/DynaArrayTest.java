package lecture1_oop_classes_encapsulation.hometask.dynaArray;

import java.util.Arrays;

public class DynaArrayTest {
    public static void main(String[] args) {
        DynaArray arr = new DynaArray();
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }
        System.out.println(Arrays.toString(arr.toArray()));
        arr.remove(5);
        arr.remove(0);
        System.out.println(Arrays.toString(arr.toArray()));
    }
}
