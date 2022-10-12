package lecture2_oop_classes_inheritance_polymorphism.hometask;

import lecture2_oop_classes_inheritance_polymorphism.lecture.DynaArray;

public class Stack extends DataStructure {
    public Stack() {
        super(new DynaArray());
    }

    @Override
    protected int getCurentIndex() {
        return size() - 1;
    }

    @Override
    protected int[] toArray() {
        int[] mass = new int[dataSet.size()];
        for (int i = 0; i < dataSet.size(); i++) {
            mass[i] = dataSet.get(dataSet.size() - 1 - i);
        }
        return mass;
    }


}
