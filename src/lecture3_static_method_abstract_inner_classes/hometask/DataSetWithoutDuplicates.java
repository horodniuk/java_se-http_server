package lecture3_static_method_abstract_inner_classes.hometask;

import lecture3_static_method_abstract_inner_classes.lecture.DynaArray;

public class DataSetWithoutDuplicates <T> extends DynaArray<T> {
    @Override
    public void add(T element) {
        boolean found = false;
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(element)){
                found = true;
                break;
            }
        }
        if(!found){
            super.add(element);
        }

    }
}
