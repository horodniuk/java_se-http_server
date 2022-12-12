package lecture_0_functional_programming.lecture;

import java.util.Comparator;

public class LambdaExample {
    public static void main(String[] args) {
        Comparator<Integer> comporator = Integer::compare;
        System.out.println(comporator.compare(25, 100));
    }

   /*private static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }*/
}
