package lecture5_exception.hometask;


import lecture3_static_method_abstract_inner_classes.lecture.DataSet;
import lecture3_static_method_abstract_inner_classes.lecture.DynaArray;

public class Stack <T> extends DataStructure<T> {
    public Stack(DataSet dataSet) {
        super(dataSet);
    }

    public Stack() {
        super(new DynaArray<T>());
    }

    @Override
    protected int getCurrentIndex() {
        return size() - 1;
    }

    @Override
    protected int getCurentIndex() {
        return size() - 1;
    }

    @Override
    protected RuntimeException createEmptyExceptionInstance() {
        return new StackIsEmptyException();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected T[] toArray() {
        T[] mass = (T[]) new Object[dataSet.size()];
        for (int i = 0; i < dataSet.size(); i++) {
            mass[i] = dataSet.get(dataSet.size() - 1 - i);
        }
        return mass;
    }


    private static class StackIsEmptyException extends RuntimeException {
        public StackIsEmptyException() {
            super("Curent stack is Empty");
        }
    }
}
