package lecture7_data_structure_collection.lecture;

import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeSet<E> {
        private transient NavigableMap<E,Object> m;
        private static final Object PRESENT = new Object();
        public TreeSet() {
            this.m = new TreeMap<E,Object>();
        }
}
