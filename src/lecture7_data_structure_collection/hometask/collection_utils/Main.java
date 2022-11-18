package lecture7_data_structure_collection.hometask.collection_utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

import static lecture7_data_structure_collection.hometask.collection_utils.CollectionUtils.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(union(Arrays.asList(new Integer[]{1, 1, 2, 3, 4})));

        System.out.println(union(
                Arrays.asList(new Integer[]{1, 1, 2, 3, 4}),
                new TreeSet<Integer>(Arrays.asList(new Integer[]{1, 1, 2, 3, 4, 5, 6}))));

        System.out.println(intersection(
                Arrays.asList(new Integer[]{1, 1, 2, 3, 4})));

        System.out.println(intersection(
                Arrays.asList(new Integer[]{1, 1, 2}),
                new TreeSet<Integer>(Arrays.asList(new Integer[]{2, 3, 4, 5, 6}))));

        System.out.println(intersection(
                Arrays.asList(new Integer[]{1, 1, 2}),
                new TreeSet<Integer>(Arrays.asList(new Integer[]{2, 3, 4, 5, 6})),
                new LinkedList<>(Arrays.asList(new Integer[]{4, 6}))));
    }
}
