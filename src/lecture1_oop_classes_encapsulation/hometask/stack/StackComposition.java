package lecture1_oop_classes_encapsulation.hometask.stack;

import lecture1_oop_classes_encapsulation.hometask.dynaArray.DynaArray;

public class StackComposition {
    DynaArray stackComposition = new DynaArray();
    public void add(int element) {
        stackComposition.add(element);
    }
    public int get(){
        return stackComposition.remove(stackComposition.size() - 1);
    }
    public int size(){
        return stackComposition.size();
    }
}
