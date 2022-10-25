package lecture5_exception.hometask;

public abstract class DataSet<T> {
    protected int size;
    public DataSet() {
        size = 0;
    }
    public final int size() {
        return size;
    }
    public void clear() {
        size = 0;
    }
    public abstract void add(T element);
    public abstract T get(int index);
    public abstract T remove(int index);
    public abstract T[] toArray();



}
