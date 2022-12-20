package lecture0_functional_programming.generic;

import java.util.ArrayList;
import java.util.List;

public class BoundExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        print(list);

        List<String> list2 = new ArrayList<>();
        list2.add("1");
       // print(list2);
    }

    private static void print(List<? extends Number> list){
        System.out.println(list);
    }
}
