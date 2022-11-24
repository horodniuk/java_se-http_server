package lecture7_data_structure_collection.lecture;

import java.util.HashMap;

public class HashSet<E> {
    private transient HashMap<E,Object> map;
    private static final Object PRESENT = new Object();
    public HashSet() {
        map = new HashMap<>();
    }

}
