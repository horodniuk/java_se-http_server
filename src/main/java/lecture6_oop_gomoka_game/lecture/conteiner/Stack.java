package lecture6_oop_gomoka_game.lecture.conteiner;

public class Stack<T> extends DataStructure<T> {
    public Stack() {
        super(new DynaArray<T>());
    }

    protected Stack(DataSet<T> dataSet) {
        super(dataSet);
    }

    @Override
    protected final int getCurrentIndex() {
        return size() - 1;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected T[] toArray() {
        T[] array = (T[]) new Object[dataSet.size()];
        for (int i = 0; i < dataSet.size(); i++) {
            array[i] = dataSet.get(dataSet.size() - 1 - i);
        }
        return array;
    }

    @Override
    protected RuntimeException createEmptyExceptionInstance() {
        return new StackIsEmptyException();
    }

    public static class StackIsEmptyException extends RuntimeException {
        private StackIsEmptyException() {
            super("Current stack is empty");
        }
    }
}
