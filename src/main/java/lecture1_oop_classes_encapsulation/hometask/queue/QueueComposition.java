package lecture1_oop_classes_encapsulation.hometask.queue;

import lecture1_oop_classes_encapsulation.hometask.linkedList.LinkedList;

public class QueueComposition {
    private final LinkedList queueComposition = new LinkedList();

    public void add (int element){
        queueComposition.add(element);
    }

    public int get(){
        return queueComposition.remove(0);
    }

    public int size (){
        return queueComposition.size();
    }
}
