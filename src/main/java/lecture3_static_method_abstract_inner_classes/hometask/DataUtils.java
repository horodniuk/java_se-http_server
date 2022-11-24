package lecture3_static_method_abstract_inner_classes.hometask;

import lecture3_static_method_abstract_inner_classes.lecture.DataSet;
import lecture3_static_method_abstract_inner_classes.lecture.DynaArray;
import lecture3_static_method_abstract_inner_classes.lecture.LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DataUtils {
    public static <T> DynaArray<T> newDynaArray() {
        return new DynaArray<T>();
    }

    public static <T> DataSet<T> newImmutableDataSet(final DataSet<T> dataSet) {
        return newImmutableDataSet(dataSet.toArray()); // Использовать анонимный внутренний класс
    }

    public static <T> DataSet<T> newImmutableDataSet(final T[] array) {
        return new DataSet<T>() {
            {
                size = array.length;
            }

            @Override
            public void add(T element) {

            }

            @Override
            public T get(int index) {
                return array[index];
            }

            @Override
            public T remove(int index) {
                return null;
            }

            @Override
            public T[] toArray() {
                return (T[]) Arrays.copyOf(array, size);
            }
        }; // Использовать анонимный внутренний класс
    }

    public static <T> DataSet<T> newImmutableDataSet(final T element, final T... elements) {
        T[] array = (T[]) new Object[elements.length + 1];
        array[0] = element;
        System.arraycopy(elements, 0, array, 1, elements.length);
        return newImmutableDataSet(array); // Использовать анонимный внутренний класс
    }

    public static <T> LinkedList<T> newLinkedListWithDuplicates(final DataSet<T>... dataSets) {
        LinkedList<T> result = new LinkedList<>();
        for (DataSet<T> dataSet : dataSets) {
            if (dataSet instanceof LinkedList<T>) {
                result.addLinkedList((LinkedList<T>) dataSet);
            }
            for (int i = 0; i < dataSet.size(); i++) {
                result.add(dataSet.get(i));
            }
        }
        return result;
    }

    @SafeVarargs
    public static <T> DataSet<T> newDataSetWithoutDuplicates(final DataSet<T>... dataSets) {
        DataSetWithoutDuplicates<T> result = new DataSetWithoutDuplicates<>();
        for (DataSet<T> dataSet : dataSets) {
           if(dataSet instanceof LinkedList<T>){
               T[]array = dataSet.toArray();
               for (T t : array) {
                   result.add(t);
               }
           } else {
               for (int i = 0; i < dataSet.size(); i++) {
                   result.add(dataSet.get(i));
               }
           }
        }

        return result; // Использовать внутренний класс для реализации логики по удалению дубликатов
    }

    public static <T> Queue<T> newQueue(final DataSet<T> dataSet) {
        Queue<T> queue = new Queue<>();
        for (int i = 0; i < queue.size(); i++) {
            queue.add(dataSet.get(i));
        }
        return queue; //Учитывать эффективность массива и связного списка при создании очереди
    }

    public static <T> Stack<T> newStack(final DataSet<T> dataSet) {
        Stack<T> stack = new Stack<>();
        for (int i = 0; i < stack.size(); i++) {
            stack.add(dataSet.get(i));
        }
        return stack; //Учитывать эффективность массива и связного списка при создании стэка
    }

    public static <T> Queue<T> newQueue(final T[] array) {
        Queue<T> queue = new Queue<>();
        for (int i = 0; i < queue.size(); i++) {
            queue.add(array[i]);
        }
        return queue; //Учитывать эффективность массива и связного списка при создании очереди
    }

    public static <T> Stack<T> newStack(final T[] array) {
        Stack<T> stack = new Stack<>();
        for (int i = 0; i < stack.size(); i++) {
            stack.add(array[i]);
        }
        return stack; //Учитывать эффективность массива и связного списка при создании стэка
    }

    private DataUtils() {
    }
}
