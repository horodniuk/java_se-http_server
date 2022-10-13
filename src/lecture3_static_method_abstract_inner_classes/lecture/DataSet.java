package lecture3_static_method_abstract_inner_classes.lecture;

public abstract class DataSet {
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
    public abstract void add(int element);
    public abstract int get(int index);
    public abstract int remove(int index);
    public abstract int[] toArray();



}
