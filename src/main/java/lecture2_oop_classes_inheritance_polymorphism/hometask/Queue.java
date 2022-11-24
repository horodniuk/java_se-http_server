package lecture2_oop_classes_inheritance_polymorphism.hometask;

import lecture2_oop_classes_inheritance_polymorphism.lecture.LinkedList;

public class Queue extends DataStructure {
    public Queue() {
        super(new LinkedList());
    }
}
