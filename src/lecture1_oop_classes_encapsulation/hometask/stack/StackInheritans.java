package lecture1_oop_classes_encapsulation.hometask.stack;

import lecture1_oop_classes_encapsulation.hometask.dynaArray.DynaArray;

public class StackInheritans extends DynaArray {
    public void add(int element) {
        super.add(element);
    }
    public int get(){
        return super.remove(super.size() - 1);
    }
    public int size(){
        return super.size();
    }
}
