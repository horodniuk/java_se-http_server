package lecture5_exception.hometask;



import lecture3_static_method_abstract_inner_classes.lecture.DataSet;

import java.util.Arrays;

public abstract class DataStructure<T> {
    protected final DataSet<T> dataSet;

    public DataStructure(DataSet<T> dataSet) {
        super();
        this.dataSet = dataSet;
    }

    protected abstract int getCurrentIndex();

    public void add(T element) { // добавить элемент в набор
        dataSet.add(element);
    }

    protected int getCurentIndex() {
        return 0;
    }

    public T get() {         // удалить и вернуть текущий элемент
        if (isEmpty()){
            throw createEmptyExceptionInstance();
        } else {
            return dataSet.remove(getCurentIndex());
        }
    }

    public T peek() {         // вернуть текущий элемент без удаления из набора
        if (isEmpty()){
            throw createEmptyExceptionInstance();
        } else {
            return dataSet.get(getCurentIndex());
        }
    }

    protected abstract RuntimeException createEmptyExceptionInstance();

    public int size() {          // размер набора
        return dataSet.size();
    }

    public boolean isEmpty() {    // true, если набор пустой
        return dataSet.size() == 0;
    }

    protected T[] toArray() {
        return dataSet.toArray();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataStructure that = (DataStructure) o;
        if (!Arrays.equals(toArray(), that.toArray())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(toArray());
        return result;
    }

}
