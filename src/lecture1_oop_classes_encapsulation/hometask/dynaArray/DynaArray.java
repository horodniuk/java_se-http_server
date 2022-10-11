package lecture1_oop_classes_encapsulation.hometask.dynaArray;

import java.util.Arrays;

public class DynaArray {
    private int[] array;
    private int size;

    public void add(int element) {
        if (array == null) {
            clear();
        } else if (size == array.length) {
            int[] temp = array;
            array = new int[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                array[i] = temp[i];
            }
        }
        array[size++] = element;
    }

    int get(int index) {
        return array[index];
    }

    public int size() {
        return size;
    }

    void clear() {
        size = 0;
        array = new int[10];
    }

    int[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public int remove(int index) {
        if (array == null || index < 0 || index >= array.length) {
            return 0;
        }
        int removedElement = array[index];
        int lastElementIndex = array.length - 1;
        if (index != lastElementIndex) {
            for (int i = 0, j = 0; i < array.length - 1; i++, j++) {
                if (i == index) {
                    j++;
                }
                array[i] = array[j];
            }
        }
        --size;
        return removedElement;
    }
}
