package lecture6_oop_gomoka_game.lecture.conteiner;

public class Queue <T> extends DataStructure<T>{
    public Queue() {
        super(new LinkedList<T>());
    }

    protected Queue(DataSet<T> dataSet) {
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

    public static class QueueIsEmptyException extends RuntimeException {
        private QueueIsEmptyException(){
            super("Current queue is empty");
        }
    }
}
