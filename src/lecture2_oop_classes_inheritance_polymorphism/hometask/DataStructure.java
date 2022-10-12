package lecture2_oop_classes_inheritance_polymorphism.hometask;

import lecture2_oop_classes_inheritance_polymorphism.lecture.DataSet;

import java.util.Arrays;

public class DataStructure {
    protected final DataSet dataSet;

    public DataStructure(DataSet dataSet) {
        super();
        this.dataSet = dataSet;
    }


    public void add(int element) { // добавить элемент в набор
        dataSet.add(element);
    }

    protected int getCurentIndex() {
        return 0;
    }

    public int get() {         // удалить и вернуть текущий элемент
        return dataSet.remove(getCurentIndex());
    }

    public int peek() {         // вернуть текущий элемент без удаления из набора
        return dataSet.get(getCurentIndex());
    }

    public int size() {          // размер набора
        return dataSet.size();
    }

    public boolean isEmpty() {    // true, если набор пустой
        return dataSet.size() == 0;
    }

    protected int[] toArray() {
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
