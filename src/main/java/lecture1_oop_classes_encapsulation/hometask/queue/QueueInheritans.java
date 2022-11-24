package lecture1_oop_classes_encapsulation.hometask.queue;

import lecture1_oop_classes_encapsulation.hometask.linkedList.LinkedList;

public class QueueInheritans extends LinkedList {
    public void add (int element){
        super.add(element);
    }

    public int get(){
        return super.remove(0);
    }

    public int size (){
        return super.size();
    }

}
