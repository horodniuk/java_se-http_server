package lecture1_oop_classes_encapsulation.lecture;

import java.util.Arrays;

public class DynamicArray {
    private int[] array;
    private int size;
    public void add(int element) {
        if(array == null) {
            clear();
        } else if (size == array.length) {
            int[] temp = array;
            array = new int[temp.length * 2];
            System.arraycopy(temp, 0, array, 0, temp.length);
        }
        array[size++] = element;
    }
    public int get(int index) {
        return array[index];
    }
    public int size(){
        return size;
    }
    public void clear(){
        size = 0;
        array = new int[10];
    }
    public int[] toArray(){
        return Arrays.copyOf(array, size);
    }
}
