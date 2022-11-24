package lecture7_data_structure_collection.hometask.collection_utils;

import java.util.*;

public class CollectionUtils {
    public static <T> List<T> union(Collection<T>... collections) {
        Set<T> union = new LinkedHashSet<>();
        for (Collection<T> collection : collections) {
            union.addAll(collection);
        }
        return new ArrayList<>(union);
    }

    public static <T> List<T> intersection(Collection<T>... collections) {
        if (collections.length > 0) {
            Set<T> union = new LinkedHashSet<>(collections[0]);
            for (int i = 1; i < collections.length; i++) {
                union.retainAll(collections[i]);
            }
            return new ArrayList<>(union);
        } else {
            return Collections.emptyList();
        }
    }
}
