package lecture5_exception.hometask;

import java.util.Arrays;

public class DynaArray<T> extends DataSet<T> {
    private T[] array;

    public DynaArray() {
        array = (T[]) new Object[10];
    }

    @Override
    public void add(T element) {
        if (size == array.length) {
            T[] temp = array;
            array = (T[]) new Object[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                array[i] = temp[i];
            }
        }
        array[size++] = element;
    }

    @Override
    public T remove(int index) {
        if (index < size) {
            T value = array[index];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--size] = null;
            return  value;
        }
        throw new IndexOutOfBoundsException("this " + index +"not exist");
    }

    @Override
    public T get(int index) {
        if (index < size) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("this " + index +"not exist");
        }
    }

    @Override
    public void clear() {
        super.clear();
        array = (T[]) new Object[10];
    }

    @Override
    public  T[] toArray() {
        return Arrays.copyOf(array, size);
    }

}
