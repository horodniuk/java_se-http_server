package lecture5_exception.hometask;


import lecture3_static_method_abstract_inner_classes.lecture.DataSet;
import lecture3_static_method_abstract_inner_classes.lecture.LinkedList;

public class Queue<T> extends DataStructure<T> {
    public Queue() {
        super(new LinkedList<T>());
    }

    public Queue(DataSet<T> dataSet) {
        super(dataSet);
    }

    @Override
    protected int getCurrentIndex() {
        return 0;
    }

    @Override
    protected RuntimeException createEmptyExceptionInstance() {
        return new QueueIsEmptyException();
    }


    private static class QueueIsEmptyException extends RuntimeException {
        public QueueIsEmptyException() {
            super("Curent queue is Empty");
        }
    }
}
