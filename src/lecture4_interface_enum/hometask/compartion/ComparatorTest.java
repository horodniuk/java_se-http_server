package lecture4_interface_enum.hometask.compartion;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static <T> T findMax(T[] array, Comparator<T> presetComparator) {
        return find(array, presetComparator, compareResult -> compareResult > 0);
    }
    public static <T> T findMin(T[] array, Comparator<T> presetComparator) {
        return find(array, presetComparator, compareResult -> compareResult < 0);
    }


    private static <T> T find(T[] array, Comparator<T> presetComparator, CompareCallback compareCallback) {
        if (array == null || array.length == 0) {
            return null;
        } else if (array.length == 1) {
            return array[0];
        } else {
            T result = array[0];
            Comparator<T> comparator = checkComparator(presetComparator, result);
            for (int i = 1; i < array.length; i++) {
                if (compareCallback.shouldUpdateResult(comparator.compare(array[i], result))) {
                    result = array[i];
                }
            }
            return result;
        }
    }

    private static interface CompareCallback {
        boolean shouldUpdateResult(int compareResult);
    }

    public static <T> void bubbleSort(T[] array, Comparator<T> presetComparator) {
        if (array != null && array.length > 1) {
            Comparator<T> comparator = checkComparator(presetComparator, array[0]);
            int firstIndex = 0;
            while (true) {
                boolean swap = false;
                for (int i = array.length - 1; i > firstIndex; i--) {
                    if (comparator.compare(array[i], array[i - 1]) < 0) {
                        T temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                        swap = true;
                    }
                }
                if (swap) {
                    firstIndex++;
                } else {
                    break;
                }
            }
        }
    }

    private static <T> Comparator<T> checkComparator(Comparator<T> presetComparator, T arrayElement) {
        if (presetComparator != null) {
            return presetComparator;
        } else {
            if (arrayElement instanceof Comparable) {
                return (o1, o2) -> ((Comparable<T>) o1).compareTo(o2);
            } else {
                return new HashCodeComparator<>();
            }
        }
    }

    private static class HashCodeComparator<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return System.identityHashCode(o1) - System.identityHashCode(o2);
        }
    }





    public static void main(String[] args) {
        Character[] array1 = {'b', 'd', 'a', 'g', 'h', 'z'};
        System.out.println(findMax(array1, null)); //натуральный порядок
        System.out.println(findMin(array1, null)); //натуральный порядок
        System.out.println(findMax(array1, null)); //обратный порядок по таблице Unicode
        System.out.println(findMin(array1, null)); //обратный порядок по таблице Unicode
        Integer[] array2 = {-1, 3, -2, 4, -9, -7, -8};
        System.out.println(findMax(array2, null)); //натуральный порядок
        System.out.println(findMin(array2, null)); //натуральный порядок
        System.out.println(findMax(array2, null)); //порядок сравнения по модулю
        System.out.println(findMin(array2, null)); //порядок сравнения по модулю
        String[] array3 = {"qwerty", "z", "23", "hello", "hi", "May"};
        System.out.println(findMax(array3, null)); //натуральный порядок
        System.out.println(findMin(array3, null)); //натуральный порядок
        System.out.println(findMax(array3, null)); //порядок сравнения по кол-ву символов в слове
        System.out.println(findMin(array3, null)); //порядок сравнения по кол-ву символов в слове
        System.out.println("------------------------------");
        System.out.println(Arrays.toString(array1));
        bubbleSort(array1, null); //обратный порядок по таблице Unicode
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        bubbleSort(array2, null); //порядок сравнения по модулю
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        bubbleSort(array3, null); //порядок сравнения по кол-ву символов в слове
        System.out.println(Arrays.toString(array3));
        ComparatorTest[] array4 = {new ComparatorTest(), new ComparatorTest(), new ComparatorTest()};
        System.out.println(findMax(array4, null));
        System.out.println(findMin(array4, null));
        System.out.println(Arrays.toString(array4));
        bubbleSort(array4, null);
        System.out.println(Arrays.toString(array4));
    }

}
